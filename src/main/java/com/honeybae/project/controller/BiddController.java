package com.honeybae.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Bidd;
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
		biddService.insert(dto);
	}
}
