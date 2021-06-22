package com.honeybae.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.honeybae.project.dto.Product;
import com.honeybae.project.repository.ProductRepository;
import com.honeybae.project.util.TimeUtil;

@Service
public class ProductService  {
//	@Autowired
//	ProductMapper productMapper;
	@Autowired
	ProductRepository productRepository;

	public List<Product> selectList(Product dto) throws Exception {
		// 검색 조건
		// 대분류
		// 	- 브랜드,타입,사이즈,색상,콜라보 별 조회
		//	- 금액 min~max 사이 조회
		// 정렬
		// 	- 가격순
		//	- 조회수순
		// 지정명 검색
		
		// 다수의 조건 경우 ??
		// map?? dto ??
		// 전체 목록을 조회해서 로직에서 처리?
		
		
		String brand = dto.getBrand()!=null?dto.getBrand():"";
		String type = dto.getType()!=null?dto.getType():"";
		int size = dto.getSize()!=0?dto.getSize():0;
		String color = dto.getColor()!=null?dto.getColor():"";
		boolean collaborationYn = dto.isCollaborationYn();
		
		// 조건 미존재시  전체리스트
		if(	brand.equals("") 
				&& type.equals("")
				&& size == 0
				&& color.equals("")
				&& collaborationYn == false	) {
			return productRepository.selectList();
		}else {
			// 조건 존재시
			//조건 분기가 너무 많아진다..
			List<Product> dbList = productRepository.selectList();
			List<Product> respList = new ArrayList<>();
		
			// 모두 조건 존재시
			for(Product dbData : dbList) {
				if(!brand.equals("") 
						&& !type.equals("")
						&& size != 0
						&& !color.equals("")
						&& collaborationYn != false) {
					if(dbData.getBrand().equals(brand)
							&& dbData.getType().equals(type)
							&& dbData.getSize()==size
							&& dbData.getColor().equals(color)
							&& dbData.isCollaborationYn() == true) {
						respList.add(dbData);
					}
				}
			}
			
			return respList;
		}
//		Map<String,Object> searchMap = new HashMap<>();
//		if(dto.getBrand()!=null) {
//			searchMap.put("brand", dto.getBrand());
//		}
//		if(dto.getType()!=null) {
//			searchMap.put("type", dto.getType());
//		}
//		if(dto.getSize()!=0) {
//			searchMap.put("size", dto.getSize());
//		}
//		if(dto.getColor()!=null) {
//			searchMap.put("color", dto.getColor());
//		}
//		if(dto.isCollaborationYn()==true) {
//			searchMap.put("collaborationYn", dto.isCollaborationYn());
//		}
//		
//		if(searchMap != null && searchMap.isEmpty()) {
//			List<Product> dbList = productRepository.selectList();
//			for(Product dbData : dbList) {
//				if(searchMap.containsKey("brand")
//						&& searchMap.containsKey("type")
//						&& searchMap.containsKey("size")
//						&& searchMap.containsKey("color")
//						&& searchMap.containsKey("collaborationYn")	) {
//					
//				}
//			}
//			
//		}else {
//			return productRepository.selectList();
//		}
	}

	public Product selectOne(String productId) throws Exception {
		// 조회수 증가
		productRepository.readCount(productId);
		return productRepository.selectGet(productId);
	}

	public void addProduct(Product dto) throws Exception {
		// 오늘날짜에 등록된 수 조회 후 ProductNo set
		Date time = new Date();
		String today = TimeUtil.get(time,"yyMMdd");
		dto.setProductId(today);
		int iSeq = productRepository.getCount();
		String seq = String.format("%03d", iSeq+1);
		String productNo = "PR" + today + seq;
		dto.setProductId(productNo);
		dto.setWriteTime(TimeUtil.get(time));
		dto.setUpdateTime(TimeUtil.get(time));
		productRepository.addProduct(dto);
	}

	public void deleteProduct(String productId) throws Exception {
		productRepository.deleteProduct(productId);
	}

	public void updateProduct(Product dto) throws Exception {
		// 수정가능항목
		// 삭제후 재등록? 업데이트?
		// 업데이트는 전체항목? or 브랜드,타입,모델 
		dto.setUpdateTime(TimeUtil.get(new Date()));
		productRepository.updateProduct(dto);
	}
	
	
}
