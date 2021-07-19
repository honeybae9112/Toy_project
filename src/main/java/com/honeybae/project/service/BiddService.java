package com.honeybae.project.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.Bidd;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.mapper.BiddMapper;
import com.honeybae.project.util.TimeUtil;
@Service
public class BiddService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BiddMapper biddMapper;

	@Autowired
	AuctionMapper auctionMapper;

	public void insert(Bidd dto)throws Exception{
		Bidd bidd = biddMapper.selectByOne(dto);
		dto.setBiddDate(TimeUtil.getDate(new Date()));
		if(null == bidd) {
			biddMapper.insert(dto);
		}else {
			update(dto);
		}

		int currentPrice = auctionMapper.selectByOne(dto.getAuctionId())
						   .getCurrentPrice();
		if(dto.getBiddPrice() > currentPrice) {
			Auction auctionDto = new Auction();
			auctionDto.setId(dto.getAuctionId());
			auctionDto.setCurrentPrice(dto.getBiddPrice());
			auctionMapper.updateByPrice(auctionDto);
		}
	}

	public void update(Bidd dto)throws Exception{
		biddMapper.update(dto);
	}
}
