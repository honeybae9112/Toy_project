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
		// 조건1
		// price 20000~50000 의 리스트 리턴 
		int minPrice = searchDto.getMinPrice();
		int maxPrice = searchDto.getMaxPrice();
		
		if(minPrice ==0 && maxPrice==0) {
			return productRepository.selectList();
		}else {
			// case1. 전체 목록을 조회해서 순차적으로 비교한다
			List<Product> respList = new ArrayList<>();
			for(Product dbData : productRepository.selectList()) {
				if(maxPrice == 0) {
					if(dbData.getPrice()>=minPrice) {
						respList.add(dbData);
					}
				}else if(minPrice == 0) {
					if(dbData.getPrice()<=maxPrice) {
						respList.add(dbData);
					}
				}
				else if(maxPrice>minPrice) {
					if(dbData.getPrice()>=minPrice
							&& dbData.getPrice()<=maxPrice) {
						respList.add(dbData);
					}
				}
			}
			return respList;
		}
	}

	public Product selectOne(String productId) throws Exception {
		// 조회수 증가
		productRepository.readCount(productId);
		return productRepository.selectOne(productId);
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

	public void updateProduct(String productId,Product dto) throws Exception {
		dto.setUpdateTime(TimeUtil.get(new Date()));
		productRepository.updateProduct(productId,dto);
	}
	
	
}
