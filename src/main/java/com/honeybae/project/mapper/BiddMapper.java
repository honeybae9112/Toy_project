package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Bidd;
import com.honeybae.project.dto.BiddVO;

@Mapper
@Repository
public interface BiddMapper {

	BiddVO select(int biddId);
	BiddVO select(Bidd biddDto);
	List<BiddVO> selectList(int bidderId);
	List<BiddVO> selectListByAuction(int auctionId);
	void add(Bidd dto);
	void update(Bidd biddDto);
	void delete(int auctionId);
	void deleteByAuction(int auctionId);



}
