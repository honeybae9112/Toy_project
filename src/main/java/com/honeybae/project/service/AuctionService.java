package com.honeybae.project.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.util.TimeUtil;

@Service
public class AuctionService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuctionMapper auctionMapper;

	public List<Auction> selectList()throws Exception{
		return auctionMapper.selectByList();
	}

	public Auction selectOne(int auctionId)throws Exception{
		return auctionMapper.selectByOne(auctionId);
	}

	public void insert(Auction dto)throws Exception{
		Date currentDate = new Date();
		dto.setStartDate(TimeUtil.getDate(currentDate, "yyyy-MM-dd HH:mm:ss"));
		dto.setEndDate(TimeUtil.getDayCalculation(currentDate, "yyyy-MM-dd HH:mm:ss", 7));
		dto.setCurrentPrice(0);
		dto.setAuctionState(0);
		auctionMapper.insert(dto);
	}




}
