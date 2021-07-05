package com.honeybae.project.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

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
			// 개별 1개 조건씩 조회
			return productMapper.selectList(searchDto);
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
