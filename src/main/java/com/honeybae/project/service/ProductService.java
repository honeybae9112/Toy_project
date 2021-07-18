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
		Integer minPrice = searchDto.getMinPrice();
		Integer maxPrice = searchDto.getMaxPrice();
		String brand = searchDto.getBrand();
		String category = searchDto.getCategory();
		int size = searchDto.getSize();
		Boolean collaboration= searchDto.getCollaboration();
		Boolean retro=searchDto.getRetro();
		Boolean used=searchDto.getUsed();
		Integer sellStatus=searchDto.getSellStatus();

		if( brand == null
				&& category == null
				&& size ==0
				&& collaboration == null
				&& retro == null
				&& used == null
				&& sellStatus == null
				&& minPrice == null
				&& maxPrice == null) {
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
		dto.setWritedDate(TimeUtil.get(time));
		dto.setModifiedDate(TimeUtil.get(time));
		productMapper.addProduct(dto);
	}

	public void deleteProduct(int productId,int memberId) throws Exception {
		Product dto = new Product();
		dto.setId(productId);
		dto.setModifierId(memberId);
		dto.setModifiedDate(TimeUtil.get(new Date()));
		productMapper.deleteProduct(dto);
	}

	public void updateProduct(int productId,Product dto) throws Exception {
		dto.setId(productId);
		dto.setModifiedDate(TimeUtil.get(new Date()));
		productMapper.updateProduct(dto);
	}


}
