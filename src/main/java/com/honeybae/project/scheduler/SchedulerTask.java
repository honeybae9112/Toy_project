package com.honeybae.project.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.service.AuctionService;
import com.honeybae.project.util.TimeUtil;
@Component
@EnableScheduling
public class SchedulerTask {

	@Autowired
	AuctionService auctionService;

//	@Scheduled(cron = "0/1 * * * * *")
	@Scheduled(fixedDelay = 1000)
	public  void auctionScheduler() throws Exception{
		// 시작된 경매를 조회하고
		// 종료시간이 존재하는 경매만 현재시간보다 이전이면 종료로 업데이트
		final int START = 1; 
		List<Auction> auctionList = auctionService.selectList(START);
		for(Auction auction : auctionList) {
			if(auction.getEndDate() != null) {
				Date endDate = TimeUtil.getDate(auction.getEndDate(),"yyyy-MM-dd HH:mm:ss");
				Date nowDate = TimeUtil.getDate(TimeUtil.getDate(new Date()));
				if(endDate.compareTo(nowDate)<=0 ) {
					auctionService.updateEndState(auction.getId());
					// 입찰자가 하나도 없으면?
				}
			}
		}
	}
}
