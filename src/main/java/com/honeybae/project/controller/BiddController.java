package com.honeybae.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Bidd;
import com.honeybae.project.dto.BiddVO;
import com.honeybae.project.service.BiddService;

@RestController
public class BiddController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BiddService biddService;

	@PostMapping(value="/bidd/{auctionId}")
	public void insert(@PathVariable(name = "auctionId")int auctionId,
						@RequestBody Bidd dto)throws Exception{
		dto.setAuctionId(auctionId);
		biddService.addBidd(dto);
	}

	@GetMapping(value = "/bidd")
	public List<BiddVO> list(Bidd dto)throws Exception{
		return biddService.selectMyList(dto.getBidderId());
	}
	@GetMapping(value = "/bidd/{auctionId}")
	public BiddVO get(@PathVariable(name="auctionId")int auctionId,
						@RequestParam int bidderId)throws Exception{
		return biddService.selectMyOne(auctionId,bidderId);
	}

}
