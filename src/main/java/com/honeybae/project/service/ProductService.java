package com.honeybae.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Product;
import com.honeybae.project.dto.Search;
import com.honeybae.project.repository.ProductRepository;
import com.honeybae.project.util.TimeUtil;

@Service
public class ProductService  {
//	@Autowired
//	ProductMapper productMapper;
	@Autowired
	ProductRepository productRepository;

	public List<Product> selectList(Search searchDto) throws Exception {
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
		
		if(searchDto.getBrand()==null
				&& searchDto.getType()==null
				&& searchDto.getSize()==0
				&& searchDto.getColor()==null
				&& searchDto.isCollaborationYn()==false) {
			return productRepository.selectList();
		}else {
			List<Product> dbList = productRepository.selectList();
			List<Product> respList = new ArrayList();
			for(Product data : dbList) {
				if(searchDto.getBrand()!= null
						&& data.getBrand().equals(searchDto.getBrand())) {
					respList.add(data);
				}else if(searchDto.getType()!= null
							&&	data.getType().equals(searchDto.getType())){
					respList.add(data);
				}else if(searchDto.getSize()!= 0
						&&	data.getSize()==searchDto.getSize()){
					respList.add(data);
				}else if(searchDto.getColor()!= null
						&&	data.getColor().equals(searchDto.getColor())){
					respList.add(data);
				}else if(searchDto.isCollaborationYn()!= false
						&&	data.isCollaborationYn()==searchDto.isCollaborationYn()){
					respList.add(data);
				}
			}
			return respList;
		}
		
//		
//		String brand = searchDto.getBrand()!=null?searchDto.getBrand():"";
//		String type = searchDto.getType()!=null?searchDto.getType():"";
//		int size = searchDto.getSize()!=0?searchDto.getSize():0;
//		String color = searchDto.getColor()!=null?searchDto.getColor():"";
//		boolean collaborationYn = searchDto.isCollaborationYn();
//		
//		// 조건 미존재시  전체리스트
//		if(	brand.equals("") 
//				&& type.equals("")
//				&& size == 0
//				&& color.equals("")
//				&& collaborationYn == false	) {
//			return productRepository.selectList();
//		}else {
//			// 조건 존재시
//			//조건 분기가 너무 많아진다..
//			List<Product> dbList = productRepository.selectList();
//			List<Product> respList = new ArrayList<>();
//		
//			// 모두 조건 존재시
//			for(Product dbData : dbList) {
//				if(!brand.equals("") 
//						&& !type.equals("")
//						&& size != 0
//						&& !color.equals("")
//						&& collaborationYn != false) {
//					if(dbData.getBrand().equals(brand)
//							&& dbData.getType().equals(type)
//							&& dbData.getSize()==size
//							&& dbData.getColor().equals(color)
//							&& dbData.isCollaborationYn() == true) {
//						respList.add(dbData);
//					}
//				}
//			}
//			
//			return respList;
//		}
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
