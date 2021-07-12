package com.honeybae.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Member;
import com.honeybae.project.dto.SessionVO;

@Repository
@Mapper
public interface MemberMapper  {

	String checkByPassword(String email)throws Exception;
	Member checkByEmail(String email)throws Exception;
	SessionVO getUserInfo(String email)throws Exception;
	void addMember(Member member)throws Exception;
	void resignMember(Member member)throws Exception;
	
	
	

}
