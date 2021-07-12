package com.honeybae.project.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Member;
import com.honeybae.project.dto.SessionVO;
import com.honeybae.project.service.MemberService;

@RestController
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MemberService memberService;
	
	// 회원가입
	@PostMapping(value="/signup")
	public Map<String,Object> create(@RequestBody Member member)throws Exception{
		logger.debug("member signUp");
		memberService.addMember(member);
		Map<String,Object> respData = new LinkedHashMap<>();
		respData.put("status", "success");
		return respData;
	}
	@PutMapping(value="/resign")
	public void resign(HttpServletRequest req)throws Exception{
		logger.debug("membe resign");
		Member userInfo = (Member)req.getAttribute("userInfo");
		memberService.resignMember(userInfo);
	}
	
	// 로그인
	@PostMapping(value="/signin")
	public SessionVO signin(@RequestBody Member member
						,HttpServletRequest req)throws Exception{
		logger.debug("member signin");
		SessionVO userInfo = memberService.login(member);
		if(userInfo != null) {
			req.getSession().setAttribute("userInfo", userInfo);
		}
		return userInfo;
	}
	// 로그아웃 
	@GetMapping(value="/signout")
	public void signout(HttpServletRequest req)throws Exception{
		logger.debug("member signout");
		req.getSession().invalidate();
	}
	
	
	
}
