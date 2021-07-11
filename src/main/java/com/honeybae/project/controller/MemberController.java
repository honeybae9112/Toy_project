package com.honeybae.project.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Member;
import com.honeybae.project.service.MemberService;

@RestController
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MemberService memberService;
	
	@PostMapping(value="/signup")
	public Map<String,Object> create(@RequestBody Member member)throws Exception{
		logger.debug("member signUp");
		memberService.addMember(member);
		Map<String,Object> respData = new LinkedHashMap<>();
		respData.put("status", "success");
		return respData;
	}
	
	
	
}
