package com.honeybae.project.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Auction;
import com.honeybae.project.dto.AuctionVO;
import com.honeybae.project.dto.Bidd;
import com.honeybae.project.dto.BiddVO;
import com.honeybae.project.mapper.AuctionMapper;
import com.honeybae.project.mapper.BiddMapper;
import com.honeybae.project.util.AuctionState;
import com.honeybae.project.util.TimeUtil;
@Service
public class BiddService extends AuctionState {
	@Autowired
	AuctionMapper auctionMapper;
	@Autowired
	BiddMapper	biddMapper;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void add(int auctionId,Bidd dto) {
		int biddPrice = dto.getBiddPrice();
		int bidderId = dto.getBidderId();
		AuctionVO auctionVo = auctionMapper.select(auctionId);
		// 경매중 시 입찰
		if(auctionVo.getAuctionState()==START) {
			// 나의 입찰내역을 조회 한뒤
			// 입찰한 기록이 존재하면 입찰가와 날짜를 수정하고
			// 없으면 추가한다
			BiddVO biddVo = select(auctionId,bidderId);
			if(biddVo != null) {
				int biddId = biddVo.getId();
				update(biddId,biddPrice);
			}else {
				dto.setBiddDate(TimeUtil.getDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
				biddMapper.add(dto);
			}
			// 현재가보다 입찰가가 높은 경우 경매에 현재가격을 업데이트한다
			int currentPrice = auctionVo.getCurrentPrice();
			//여러명 동시에 동일 가격 입찰시 가격이 같으면 ?
			if(currentPrice < biddPrice) {
				Auction auctionDto = new Auction();
				auctionDto.setId(auctionId);
				auctionDto.setCurrentPrice(biddPrice);
				auctionMapper.updateByPrice(auctionDto);
			}else {
				// 현재가 보다 작으면?
			}
		// 진행중이 아니면?
		}else {

		}
	}
	public BiddVO select(int auctionId, int bidderId) {
		Bidd biddDto = new Bidd();
		biddDto.setAuctionId(auctionId);
		biddDto.setBidderId(bidderId);
		return biddMapper.select(biddDto);
	}
	public BiddVO select(int biddId) {
		return biddMapper.select(biddId);
	}
	public List<BiddVO> selectList(int bidderId){
		return biddMapper.selectList(bidderId);
	}
	public List<BiddVO> selectListAuction(int auctionId) {
		return biddMapper.selectListByAuction(auctionId);
	}
	public void update(int biddId,int biddPrice) {
		Bidd biddDto = new Bidd();
		biddDto.setId(biddId);
		biddDto.setBiddPrice(biddPrice);
		biddDto.setBiddDate(TimeUtil.getDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		biddMapper.update(biddDto);
	}
	public void delete(int biddId) {
		biddMapper.delete(biddId);
	}
	public void deleteAuction(int auctionId) {
		biddMapper.deleteByAuction(auctionId);
	}



}
