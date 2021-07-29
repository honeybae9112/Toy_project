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
		biddService.add(auctionId,dto);
	}

	@GetMapping(value = "/bidd")
	public List<BiddVO> list(@RequestParam int bidderId)throws Exception{
		return biddService.selectList(bidderId);
	}
	@GetMapping(value = "/bidd/{auctionId}")
	public List<BiddVO> listAuction(@PathVariable int auctionId)throws Exception{
		return biddService.selectListAuction(auctionId);
	}
	@GetMapping(value = "/bidd/{bidderId}/{auctionId}")
	public BiddVO get(@PathVariable(name="bidderId")int bidderId,
						@RequestParam int auctionId)throws Exception{
		return biddService.select(bidderId,auctionId);
	}
	@PutMapping(value = "/bidd/{biddId}")
	public void update(@PathVariable(name="biddId")int biddId,
						@RequestBody int biddPrice)throws Exception{
		biddService.update(biddId, biddPrice);
	}
	@DeleteMapping(value = "/bidd/{biddId}")
	public void delete(@PathVariable(name="biddId")int biddId)throws Exception{
		biddService.delete(biddId);
	}

}
