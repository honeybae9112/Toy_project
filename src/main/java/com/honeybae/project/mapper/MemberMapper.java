package com.honeybae.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Member;

@Repository
@Mapper
public interface MemberMapper {

	Member checkById(String email);
	
	void addMember(Member member);
	
	

}
