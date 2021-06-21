package com.honeybae.project.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Product;
import com.honeybae.project.repository.ProductRepository;
import com.honeybae.project.util.TimeUtil;

@Service
public class ProductService  {
//	@Autowired
//	ProductMapper productMapper;
	@Autowired
	ProductRepository productRepository;

	public List<Product> selectAll(Product dto) throws Exception {
		List<Product> respList = productRepository.selectList(dto); 
		return respList;
	}

	public Product selctOne(String productId) throws Exception {
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
		productRepository.updateProduct(dto);
	}
	
	
}
