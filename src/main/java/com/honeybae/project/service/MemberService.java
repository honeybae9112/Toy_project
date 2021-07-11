package com.honeybae.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Member;
import com.honeybae.project.mapper.MemberMapper;
import com.honeybae.project.util.TimeUtil;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void addMember(Member dto)throws Exception{
		Member member = memberMapper.checkById(dto.getEmail());
		if(member == null) {
			String encodePassword = passwordEncoder.encode(dto.getPassword());
			dto.setPassword(encodePassword);
			dto.setRole(0);
			dto.setRegisterDate(TimeUtil.get(new Date()));
			dto.setDeleteFlag(false);
			memberMapper.addMember(dto);
		}
	}

}
