package com.honeybae.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.service.AuctionService;

@RestController
public class AuctionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuctionService auctionService;

	@GetMapping(value = "/auction")
	public List<Auction> list(Auction dto)throws Exception{
		return auctionService.selectList();
	}
	@GetMapping(value = "/auction/{auctionId}")
	public Auction object(@PathVariable(value = "auctionId")int auctionId)throws Exception{
		return auctionService.selectOne(auctionId);
	}

	@PostMapping(value = "/auction")
	public void insert(@RequestBody	Auction dto)throws Exception{
		auctionService.insert(dto);
	}


}
