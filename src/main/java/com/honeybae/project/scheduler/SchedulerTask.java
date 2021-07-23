package com.honeybae.project.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.honeybae.project.service.AuctionService;
@Component
@EnableScheduling
public class SchedulerTask {

	@Autowired
	AuctionService auctionService;

//	@Scheduled(cron = "0/1 * * * * *")
	@Scheduled(fixedDelay = 1000)
	public  void auctionScheduler() throws Exception{
		auctionService.changeForEndState();
	}

}
