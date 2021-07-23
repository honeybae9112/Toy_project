package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.Bidd;

@Repository
@Mapper
public interface AuctionMapper {

	public List<Auction> selectByAllAuctionList()throws Exception;
	public Auction selectByAuction(int auctionId)throws Exception;

	public void	addAuction(Auction dto)throws Exception;

	public void updateForMaxPrice(Auction dto);
	public void updateForAbortState(Auction dto);
	public void updateForEndState(Auction dto);
}
