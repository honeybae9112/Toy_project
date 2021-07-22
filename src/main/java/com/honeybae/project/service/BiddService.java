package com.honeybae.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.Bidd;
import com.honeybae.project.dto.BiddVO;
import com.honeybae.project.dto.Product;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.mapper.BiddMapper;
import com.honeybae.project.mapper.ProductMapper;
import com.honeybae.project.util.TimeUtil;
@Service
public class BiddService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BiddMapper biddMapper;
	@Autowired
	AuctionMapper auctionMapper;
	@Autowired
	ProductMapper productMapper;

	public void addBidd(Bidd dto)throws Exception{

		Auction auctionData = auctionMapper.selectByOne(dto.getAuctionId());
		int currentPrice = auctionData.getCurrentPrice();

		if(dto.getBiddPrice() > currentPrice) {
			Bidd bidd = biddMapper.selectMyOne(dto);
			dto.setBiddDate(TimeUtil.getDate(new Date()));
			if(null == bidd) {
				biddMapper.addByBidd(dto);
			}else {
				biddMapper.updateByPrice(dto);
			}
			Auction auctionDto = new Auction();
			auctionDto.setId(dto.getAuctionId());
			auctionDto.setCurrentPrice(dto.getBiddPrice());
			auctionMapper.updateByPrice(auctionDto);
		}
	}
	public  List<BiddVO> selectMyList(int bidderId)throws Exception{
		List<BiddVO> respList = new ArrayList<>();
		for(Bidd bidd : biddMapper.selectMyList(bidderId)) {
			Auction auction = auctionMapper.selectByOne(bidd.getAuctionId());
			Product product = productMapper.selectOne(auction.getProductId());
			BiddVO vo = new BiddVO(bidd.getId()
									, bidd.getBiddPrice()
									, bidd.getBiddDate()
									, product
									, auction);
			respList.add(vo);
		}
		return respList;
	}
	public BiddVO selectMyOne(int auctionId, int bidderId)throws Exception {
		Bidd biddDto = new Bidd();
		biddDto.setAuctionId(auctionId);
		biddDto.setBidderId(bidderId);
		Bidd bidd = biddMapper.selectMyOne(biddDto);
		Auction auction = auctionMapper.selectByOne(bidd.getAuctionId());
		Product product = productMapper.selectOne(auction.getProductId());
		BiddVO vo = new BiddVO(bidd.getId()
								, bidd.getBiddPrice()
								, bidd.getBiddDate()
								, product
								, auction);
		return vo;
	}
}
