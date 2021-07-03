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
		// 조건1
		// price 최소값 최대값 사이의 리스트 리턴 
		int minPrice = searchDto.getMinPrice();
		int maxPrice = searchDto.getMaxPrice();
		String brand = searchDto.getBrand();
		String type = searchDto.getType();
		int size = searchDto.getSize();
		boolean collaboration= searchDto.isCollaboration();
		boolean retro=searchDto.isRetro();
		boolean used=searchDto.isUsed();
		boolean soldout=searchDto.isSoldout();
		
		
		if( brand == null
				&& type == null
				&& size ==0
				&& collaboration == false
				&& retro == false
				&& used == false
				&& soldout == false
				&& minPrice ==0
				&& maxPrice ==0) {
			return productMapper.selectAll();
		}else {
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
