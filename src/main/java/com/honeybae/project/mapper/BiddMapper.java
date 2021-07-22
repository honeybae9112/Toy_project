package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Bidd;

@Mapper
@Repository
public interface BiddMapper {

	public void addByBidd(Bidd dto)throws Exception;
	public void updateByPrice(Bidd dto)throws Exception;
	public Bidd selectMyOne(Bidd dto)throws Exception;
	public List<Bidd> selectMyList(int bidderId)throws Exception;

}
