package com.honeybae.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.AuctionVO;
import com.honeybae.project.dto.Product;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.mapper.ProductMapper;
import com.honeybae.project.util.TimeUtil;

@Service
public class AuctionService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuctionMapper auctionMapper;
	@Autowired
	ProductMapper productMapper;

	public List<AuctionVO> selectList()throws Exception{
		List<AuctionVO> respList = new ArrayList();
		for(Auction auction:auctionMapper.selectByList()) {
			Product product = productMapper.selectOne(auction.getProductId());
			AuctionVO vo = new AuctionVO(	auction.getId()
											,product
											, auction.getStartDate()
											, auction.getEndDate()
											, auction.getCurrentPrice()
											, auction.getAuctionState());
			respList.add(vo);
		}
		return respList;
	}

	public AuctionVO selectOne(int auctionId)throws Exception{
		Auction auction = auctionMapper.selectByOne(auctionId);
		Product product = productMapper.selectOne(auction.getProductId());
		AuctionVO vo = new AuctionVO(	auction.getId()
										,product
										, auction.getStartDate()
										, auction.getEndDate()
										, auction.getCurrentPrice()
										, auction.getAuctionState());
		return vo;
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
