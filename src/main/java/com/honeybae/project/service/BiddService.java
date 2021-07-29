package com.honeybae.project.service;

import java.util.Date;
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
import com.honeybae.project.util.TimeUtil;
@Service
public class BiddService extends AuctionState {
	@Autowired
	AuctionMapper auctionMapper;
	@Autowired
	BiddMapper	biddMapper;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void add(int auctionId,Bidd dto) {
		int biddPrice = dto.getBiddPrice();
		int bidderId = dto.getBidderId();
		Auction auction = auctionMapper.select(auctionId);
		Integer auctionMaxPrice = auction.getMaxPrice();
		Integer auctionMinPrice = auction.getMinPrice();
		int currentPrice = auction.getCurrentPrice();
		dto.setBiddDate(TimeUtil.getDate(new Date(),"yyyy-MM-dd HH:mm:ss"));

		if(auction.getAuctionState()==START) {
			Bidd bidd = select(auctionId,bidderId);
			if(bidd != null) {
				int biddId = bidd.getId();
				if(auctionMinPrice != null && auctionMaxPrice != null) {
					if(biddPrice>auctionMinPrice && biddPrice<auctionMaxPrice) {
						update(biddId,biddPrice);
						updateAuctionPrice(auctionId,currentPrice,biddPrice);
					}
				}else {
					update(biddId,biddPrice);
					updateAuctionPrice(auctionId,currentPrice,biddPrice);
				}
			}else {
				if(auctionMinPrice != null && auctionMaxPrice != null) {
					if(biddPrice>auctionMinPrice && biddPrice<auctionMaxPrice) {
						biddMapper.add(dto);
						updateAuctionPrice(auctionId,currentPrice,biddPrice);
					}
				}else {
					biddMapper.add(dto);
					updateAuctionPrice(auctionId,currentPrice,biddPrice);
				}
			}
		}
	}
	private void updateAuctionPrice(int auctionId,int currentPrice,int biddPrice) {
		if(biddPrice>currentPrice) {
			Auction auctionDto = new Auction();
			auctionDto.setId(auctionId);
			auctionDto.setCurrentPrice(biddPrice);
			auctionMapper.updateByPrice(auctionDto);
		}
	}

	public Bidd select(int auctionId, int bidderId) {
		Bidd biddDto = new Bidd();
		biddDto.setAuctionId(auctionId);
		biddDto.setBidderId(bidderId);
		return biddMapper.select(biddDto);
	}
	public Bidd select(int biddId) {
		return biddMapper.select(biddId);
	}
	public List<Bidd> selectList(int bidderId){
		return biddMapper.selectList(bidderId);
	}
	public List<Bidd> selectListAuction(int auctionId) {
		return biddMapper.selectListByAuction(auctionId);
	}
	public void update(int biddId,int biddPrice) {
		Bidd biddDto = new Bidd();
		biddDto.setId(biddId);
		biddDto.setBiddPrice(biddPrice);
		biddDto.setBiddDate(TimeUtil.getDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		biddMapper.update(biddDto);
	}
	public void delete(int biddId) {
		Bidd bidd = select(biddId);
		int bidderPrice = bidd.getBiddPrice();
		int auctionId = bidd.getAuctionId();

		Auction auction = auctionMapper.select(auctionId);
		int currentPrice = auction.getCurrentPrice();

		biddMapper.delete(biddId);
		if(bidderPrice == currentPrice) {
			int biddMaxPrice = biddMapper.selectMaxPrice(auctionId);
			Auction auctionDto = new Auction();
			auctionDto.setId(auctionId);
			auctionDto.setCurrentPrice(biddMaxPrice);
			auctionMapper.updateByPrice(auctionDto);
		}
	}
	public void deleteAuction(int auctionId) {
		biddMapper.deleteByAuction(auctionId);
	}



}
