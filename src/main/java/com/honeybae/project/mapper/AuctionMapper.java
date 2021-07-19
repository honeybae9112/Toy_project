package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Auction;

@Repository
@Mapper
public interface AuctionMapper {

	public List<Auction> selectByList()throws Exception;
	public Auction selectByOne(int auctionId)throws Exception;
	public void	insert(Auction dto)throws Exception;
}
