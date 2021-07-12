package com.honeybae.project.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Member;
import com.honeybae.project.dto.SessionVO;
import com.honeybae.project.mapper.MemberMapper;
import com.honeybae.project.util.TimeUtil;


@Service
public class MemberService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void addMember(Member dto)throws Exception{
		Member member = memberMapper.checkByEmail(dto.getEmail());
		if(member == null) {
			String encodePassword = passwordEncoder.encode(dto.getPassword());
			dto.setPassword(encodePassword);
			dto.setRole(0);
			dto.setRegisterDate(TimeUtil.get(new Date()));
			dto.setDeleteFlag(false);
			memberMapper.addMember(dto);
		}
	}
	
	public SessionVO login(Member dto)throws Exception{
		// 아이디로 DB pwd를 가져와서
		// parameter pwd와 비교 화여 결과 리턴
		String password = memberMapper.checkByPassword(dto.getEmail());
		if(passwordEncoder.matches(dto.getPassword(), password)) {
			return memberMapper.getUserInfo(dto.getEmail());
		}
		return null;
	}

	public void resignMember(Member dto)throws Exception {
		dto.setDeleteFlag(true);
		memberMapper.resignMember(dto);
	}

}
