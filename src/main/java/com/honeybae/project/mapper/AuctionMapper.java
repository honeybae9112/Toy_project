package com.honeybae.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.AuctionVO;

@Repository
@Mapper
public interface AuctionMapper {

	void add(Auction auctionDto);
	Auction select(int auctionId);
	List<Auction> selectList(int auctionState);
	List<Auction> selectAll();

	void update(Auction dto);
	void updateByPrice(Auction dto);
	void updateByState(Auction dto);
	void updateByStartDate(Auction dto);
	void updateByEndDate(Auction dto);
}
