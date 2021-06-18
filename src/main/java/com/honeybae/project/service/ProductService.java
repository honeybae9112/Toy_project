package com.honeybae.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Product;
import com.honeybae.project.repository.ProductRepository;

@Service
public class ProductService  {
//	@Autowired
//	ProductMapper productMapper;
	@Autowired
	ProductRepository productRepository;

	public List<Product> selectAll(Product dto) throws Exception {
//		List<Product> respList = productMapper.selectList(dto); 
		List<Product> respList = productRepository.selectList(dto); 
		return respList;
	}

	public Product selctOne(String productId) throws Exception {
		// 조회수 증가
//		productMapper.readCount(dto);
//		productRepository.readCount(dto);
//		return productMapper.selectGet(dto);
		return productRepository.selectGet(productId);
	}

	public void addProduct(Product dto) throws Exception {
		// 오늘날짜에 등록된 수 조회 후 ProductNo set
//		Date time = new Date();
//		String today = TimeUtil.get(time,"yyMMdd");
//		dto.setProductId(today);
////		int productCount = productMapper.count(dto);
//		int productCount = productRepository.count(dto);
//		String seq = String.format("%03d", productCount+1);
//		String productNo = "PR" + today + seq;
//		dto.setProductId(productNo);
//		dto.setWriteTime(TimeUtil.get(time));
//		dto.setUpdateTime(TimeUtil.get(time));
//		productMapper.productAdd(dto);
//		productRepository.addProduct(dto);
	}

	public void deleteProduct(Product dto) throws Exception {
//		dto.setDeleteYn("Y");
//		dto.setUpdateTime(TimeUtil.get(new Date()));
		
//		productMapper.productDelete(dto);
//		productRepository.deleteProduct(dto);
//		productMapper.delete(dto);
	}

	public void updateProduct(Product dto) throws Exception {
		// 수정가능항목
		// 삭제후 재등록? 업데이트?
		// 업데이트는 전체항목? or 브랜드,타입,모델 
//		productMapper.productUpdate(dto);
	}
	
	
}
