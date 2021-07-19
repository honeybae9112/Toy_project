package com.honeybae.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Bidd;

@Mapper
@Repository
public interface BiddMapper {

	public void insert(Bidd dto)throws Exception;
	public void update(Bidd dto)throws Exception;

	public Bidd selectByOne(Bidd dto)throws Exception;

}
