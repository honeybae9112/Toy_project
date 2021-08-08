package com.honeybae.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.Bidd;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.mapper.BiddMapper;
import com.honeybae.project.util.AuctionState;

@Service
public class AuctionService extends AuctionState{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuctionMapper auctionMapper;
	@Autowired
	BiddMapper biddMapper;

	public void add(Auction dto) {
		Auction auctionDto = new Auction();
		int productId = dto.getProductId();
		String startDate = dto.getStartDate();
		String endDate = dto.getEndDate();
		Integer currentPrice = dto.getCurrentPrice();
		Integer minPrice = dto.getMinPrice();
		Integer maxPrice = dto.getMaxPrice();
		int auctionState = dto.getAuctionState();

		Auction auction = auctionMapper.select(productId);
		if(auction == null) {
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
		}else {
			update(auction.getId(),dto);
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

		String startDate = dto.getStartDate();
		String endDate =dto.getEndDate();
		Integer minPrice = dto.getMinPrice();
		Integer maxPrice = dto.getMaxPrice();
		int auctionState = dto.getAuctionState();

		List<Bidd> biddList = biddMapper.selectListByAuction(auctionId);
		// 경매 수정시 입찰자가 존재하면 ??
		Auction auctionDto = new Auction();
		auctionDto.setId(auctionId);
		if(biddList.size()>0) {
			// 입찰자들에게 알람 후 수정 ?

		}else {
			if(startDate == null && endDate == null && minPrice == null && maxPrice == null) {
				if(auctionState != WAIT) {
					auctionDto = auctionState(auctionDto, auctionState);
				}
			}else {
				if(minPrice != null ) {
					auctionDto.setMinPrice(minPrice);
				}
				if(maxPrice != null ) {
					auctionDto.setMaxPrice(maxPrice);
				}
				if(startDate!=null) {
					auctionDto.setStartDate(startDate);
				}
				if(endDate!=null) {
					auctionDto.setEndDate(endDate);
				}
				if(auctionState != WAIT) {
					auctionDto = auctionState(auctionDto, auctionState);
				}
			}
			auctionMapper.update(auctionDto);
		}
	}

	private Auction auctionState(Auction auctionDto,int auctionState) {
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
		return auctionDto;
	}
	
	public void updateEndState(int auctionId) {
		auctionMapper.updateEndState(auctionId);
	}
}
