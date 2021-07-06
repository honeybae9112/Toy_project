package com.honeybae.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Product;
import com.honeybae.project.dto.Search;
import com.honeybae.project.mapper.ProductMapper;
import com.honeybae.project.util.TimeUtil;

@Service
public class ProductService  {
	@Autowired
	ProductMapper productMapper;

	public List<Product> selectList(Search searchDto) throws Exception {
		int minPrice = searchDto.getMinPrice();
		int maxPrice = searchDto.getMaxPrice();
		String brand = searchDto.getBrand();
		String type = searchDto.getType();
		int size = searchDto.getSize();
		Boolean collaboration= searchDto.getCollaboration();
		Boolean retro=searchDto.getRetro();
		Boolean used=searchDto.getUsed();
		Boolean soldout=searchDto.getSoldout();
		
		// 중복 빈도가 가장 적은 것 (세분화 된것?) 
		// WHERE절에 자주 활용 되는것
		// SELECT WHERE 시 검색 속도 향상 
		// 빈번한 데이터 변경시 성능이 떨어질수있음 비효율
		
		// 예상 index
		// brand = 30개 이상(nike.adidas.puma 등등)
		// type = 운동화,농구화,스니커즈 등등 (약10개항목)
		// size = 200 ~ 300 ( 10개)
		
		if( brand == null
				&& type == null
				&& size ==0
				&& collaboration == null
				&& retro == null
				&& used == null
				&& soldout == null
				&& minPrice ==0
				&& maxPrice ==0) {
			return productMapper.selectAll();
		}else {
			// 모든 조건 존재시
			if( brand == null
					&& type == null
					&& size ==0
					&& collaboration == null
					&& retro == null
					&& used == null
					&& soldout == null
					&& minPrice ==0
					&& maxPrice ==0) {
				return productMapper.selectList(searchDto);
			}else {
				// 개별 1개 조건씩 조회해서 set
				Set<Product> setList = new HashSet<Product>();
				
				if(brand != null) {
					setList.addAll(productMapper.selectBrand(brand));
				}
				if(type != null) {
					setList.addAll(productMapper.selectType(type));
				}
				if(size != 0) {
					setList.addAll(productMapper.selectSize(size));
				}
				if(collaboration != null) {
					setList.addAll(productMapper.selectCollaboration(collaboration));
				}
				if(retro != null) {
					setList.addAll(productMapper.selectRetro(retro));
				}
				if(soldout != null) {
					setList.addAll(productMapper.selectSoldout(soldout));
				}
				if(minPrice != 0 || maxPrice != 0 ) {
					Map<String, Integer> priceMap = new HashMap();
					priceMap.put("minPrice", minPrice);
					priceMap.put("maxPrice", maxPrice);
					setList.addAll(productMapper.selectPrice(priceMap));
				}
				return  new ArrayList<>(setList);
			}
		}
	}

	public Product selectOne(int productId) throws Exception {
		// 조회수 증가
		productMapper.viewCount(productId);
		return productMapper.selectOne(productId);
	}

	public void addProduct(Product dto) throws Exception {
		Date time = new Date();
		dto.setWriteTime(TimeUtil.get(time));
		dto.setUpdateTime(TimeUtil.get(time));
		productMapper.addProduct(dto);
	}

	public void deleteProduct(int productId) throws Exception {
		productMapper.deleteProduct(productId);
	}

	public void updateProduct(int productId,Product dto) throws Exception {
		dto.setProductId(productId);
		dto.setUpdateTime(TimeUtil.get(new Date()));
		productMapper.updateProduct(dto);
	}
	
	
}
