package com.honeybae.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Pagination;
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
		String category = searchDto.getCategory();
		int size = searchDto.getSize();
		Boolean collaboration= searchDto.getCollaboration();
		Boolean retro=searchDto.getRetro();
		Boolean used=searchDto.getUsed();
		Boolean soldout=searchDto.getSoldout();
		
		if( brand == null
				&& category == null
				&& size ==0
				&& collaboration == null
				&& retro == null
				&& used == null
				&& soldout == null
				&& minPrice ==0
				&& maxPrice ==0) {
			Pagination pagination = new Pagination();
			pagination.setCurrentPage(searchDto.getCurrentPage());
			pagination.setPageRowSize(searchDto.getPageRowSize());
			return productMapper.selectAll(pagination);
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
		dto.setWriteDate(TimeUtil.get(time));
		dto.setUpdateDate(TimeUtil.get(time));
		productMapper.addProduct(dto);
	}

	public void deleteProduct(int productId) throws Exception {
		productMapper.deleteProduct(productId);
	}

	public void updateProduct(int productId,Product dto) throws Exception {
		dto.setId(productId);
		dto.setUpdateDate(TimeUtil.get(new Date()));
		productMapper.updateProduct(dto);
	}
	
	
}
