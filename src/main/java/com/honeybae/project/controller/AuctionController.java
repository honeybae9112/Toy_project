package com.honeybae.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.AuctionVO;
import com.honeybae.project.service.AuctionService;

@RestController
public class AuctionController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AuctionService auctionService;

	@PostMapping(value = "/auction")
	public void add(@RequestBody Auction dto)throws Exception{
		auctionService.add(dto);
	}

	@GetMapping(value = "/auction")
	public List<AuctionVO> list(@RequestParam int auctionState)throws Exception{
		return auctionService.selectList(auctionState);
	}

	@GetMapping(value = "/auction/{auctionId}")
	public AuctionVO get(@PathVariable(value = "auctionId")int auctionId)throws Exception{
		return auctionService.select(auctionId);
	}

	@PutMapping(value="/auction/{auctionId}")
	public void update (@PathVariable(value="auctionId")int auctionId,
							  @RequestBody Auction dto)throws Exception{
		auctionService.update(auctionId,dto);
	}


}
