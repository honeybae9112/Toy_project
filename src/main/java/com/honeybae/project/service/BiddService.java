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
	
	// 동시간 입찰을 처리하려면??
	public synchronized void add(int auctionId,Bidd dto) {
		int biddPrice = dto.getBiddPrice();
		int bidderId = dto.getBidderId();
		dto.setBiddDate(TimeUtil.getDate(new Date(),"yyyy-MM-dd HH:mm:ss:SSS"));
		
		Auction auction = auctionMapper.select(auctionId);
		Integer auctionMaxPrice = auction.getMaxPrice();
		Integer auctionMinPrice = auction.getMinPrice();
		int currentPrice = auction.getCurrentPrice();

		if(auction.getAuctionState()==START) {
			Bidd bidd = select(auctionId,bidderId);
			if(bidd != null) {
				int biddId = bidd.getId();
				if(auctionMinPrice != null && auctionMaxPrice != null) {
					if(biddPrice>auctionMinPrice && biddPrice<auctionMaxPrice) {
						update(biddId,biddPrice);
					}
				}else {
					update(biddId,biddPrice);
				}
			}else {
				if(auctionMinPrice != null && auctionMaxPrice != null) {
					if(biddPrice>=auctionMinPrice && biddPrice<=auctionMaxPrice) {
						biddMapper.add(dto);
					}
				}else {
					biddMapper.add(dto);
				}
			}
			if(biddPrice>currentPrice) {
				updateCurrentPrice(auctionId,biddPrice);
				updateSuccessful(auctionId, bidderId);
			}
		}
	}
	public void update(int biddId,int biddPrice) {
		Bidd biddDto = new Bidd();
		biddDto.setId(biddId);
		biddDto.setBiddPrice(biddPrice);
		biddDto.setBiddDate(TimeUtil.getDate(new Date(),"yyyy-MM-dd HH:mm:SSS"));
		biddMapper.update(biddDto);
	}
	private void updateCurrentPrice(int auctionId,int biddPrice) {
		Auction auctionDto = new Auction();
		auctionDto.setId(auctionId);
		auctionDto.setCurrentPrice(biddPrice);
		auctionMapper.updateByCurrentPrice(auctionDto);
	}
	private void updateSuccessful(int auctionId,int bidderId) {
		Bidd biddDto = new Bidd();
		biddDto.setAuctionId(auctionId);
		biddDto.setBidderId(bidderId);
		biddDto.setSuccessfulFlag(true);
		biddMapper.updateBySucceccful(biddDto);
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
	public void delete(int biddId) {
		Bidd bidd = select(biddId);
		int bidderPrice = bidd.getBiddPrice();
		int auctionId = bidd.getAuctionId();
		boolean biddSuccessful = bidd.isSuccessfulFlag();

		Auction auction = auctionMapper.select(auctionId);
		int currentPrice = auction.getCurrentPrice();

		biddMapper.delete(biddId);
		if(biddSuccessful) {
			// 최대값 입찰자가 여러명이면??
			// 입찰시간이 동일하면 ??? 
			Bidd maxBidd = biddMapper.selectMaxPrice(auctionId);
			if(maxBidd !=null) {
					int maxPrice = maxBidd.getBiddPrice();
					String biddDate = maxBidd.getBiddDate();
					if(maxPrice>0) {
						Auction auctionDto = new Auction();
						auctionDto.setId(auctionId);
						auctionDto.setCurrentPrice(maxPrice);
						auctionMapper.updateByCurrentPrice(auctionDto);
						
						Bidd biddDto = new Bidd();
						biddDto.setId(maxBidd.getId());
						biddDto.setSuccessfulFlag(true);
						biddMapper.updateBySucceccful(biddDto);
					}
			}
		}
	}
	public void deleteAuction(int auctionId) {
		biddMapper.deleteByAuction(auctionId);
	}



}
