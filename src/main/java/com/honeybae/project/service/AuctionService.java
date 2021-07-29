package com.honeybae.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.AuctionVO;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.mapper.ProductMapper;
import com.honeybae.project.util.AuctionState;

@Service
public class AuctionService extends AuctionState{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuctionMapper auctionMapper;

	public void add(Auction dto) {
		Auction auctionDto = new Auction();
		int productId = dto.getProductId();
		String startDate = dto.getStartDate();
		String endDate = dto.getEndDate();
		Integer currentPrice = dto.getCurrentPrice();
		Integer minPrice = dto.getMinPrice();
		Integer maxPrice = dto.getMaxPrice();
		int auctionState = dto.getAuctionState();


		Auction Auction = auctionMapper.select(productId);
		if(Auction == null) {
			if(auctionState == 0) {
				auctionDto.setAuctionState(WAIT);
			}else {
				auctionDto.setAuctionState(START);
			}
			if(minPrice != null) {
				auctionDto.setMinPrice(minPrice);
			}
			if(maxPrice != null) {
				auctionDto.setMaxPrice(maxPrice);
			}
			if(startDate !=null) {
				auctionDto.setStartDate(startDate);
			}
			if(endDate !=null) {
				auctionDto.setEndDate(endDate);
			}
			if(currentPrice !=null) {
				auctionDto.setCurrentPrice(currentPrice);
			}
			auctionMapper.add(auctionDto);
		}

	}

	public Auction select(int auctionId) {
		return auctionMapper.select(auctionId);
	}

	public List<Auction> selectList(int auctionState) {
		switch (auctionState) {
		case 0:
			return auctionMapper.selectList(WAIT);
		case 1:
			return auctionMapper.selectList(START);
		case 2:
			return auctionMapper.selectList(END);
		case 3:
			return auctionMapper.selectList(ABORT);
		default:
			return auctionMapper.selectAll();
		}
	}

	public void update(int auctionId,Auction dto) {
		Auction auctionDto = new Auction();
		auctionDto.setId(auctionId);
		String startDate = dto.getStartDate();
		String endDate =dto.getEndDate();
		Integer currenctPrice = dto.getCurrentPrice();
		int auctionState = dto.getAuctionState();

		Auction auction = auctionMapper.select(auctionId);

		if(currenctPrice > auction.getCurrentPrice()) {
			auctionDto.setCurrentPrice(currenctPrice);
			auctionMapper.update(auctionDto);
		}
		if(startDate!=null && auction.getStartDate()==null) {
			auctionDto.setStartDate(startDate);
			auctionMapper.updateByStartDate(auctionDto);
		}
		if(endDate!=null && auction.getEndDate()==null) {
			auctionDto.setEndDate(endDate);
			auctionMapper.updateByEndDate(auctionDto);
		}
		if(auctionState != WAIT) {
			switch (auctionState) {
			case 1:
				auctionDto.setAuctionState(START);
				break;
			case 2:
				auctionDto.setAuctionState(END);
				break;
			case 3:
				auctionDto.setAuctionState(ABORT);
				break;
			}
			auctionMapper.updateByState(auctionDto);
		}
	}
}
