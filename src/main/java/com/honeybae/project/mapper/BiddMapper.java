package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Bidd;
import com.honeybae.project.dto.BiddVO;

@Mapper
@Repository
public interface BiddMapper {

	Bidd select(int biddId);
	Bidd select(Bidd biddDto);
	List<Bidd> selectList(int bidderId);
	List<Bidd> selectListByAuction(int auctionId);
	void add(Bidd dto);
	void update(Bidd biddDto);
	void updateBySucceccful(Bidd biddDto);
	void delete(int biddId);
	void deleteByAuction(int auctionId);
	Bidd selectMaxPrice(int auctionId);



}
