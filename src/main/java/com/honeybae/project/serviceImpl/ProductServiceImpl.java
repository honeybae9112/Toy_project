package com.honeybae.project.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeybae.project.dto.Product;
import com.honeybae.project.mapper.ProductMapper;
import com.honeybae.project.service.ProductService;
import com.honeybae.project.util.TimeUtil;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> selectAll(Product dto) throws Exception {
		List<Product> respList = productMapper.selectList(dto); 
		return respList;
	}

	@Override
	public Product selctOne(String productNo) throws Exception {
		Product dto = new Product();
		dto.setProductNo(productNo);
		// 조회수 증가
		productMapper.readCount(dto);
		return productMapper.selectGet(dto);
	}

	@Override
	public void productAdd(Product dto) throws Exception {
		// 오늘날짜에 등록된 수 조회 후 ProductNo set
		Date time = new Date();
		String today = TimeUtil.get(time,"yyMMdd");
		dto.setProductNo(today);
		int productCount = productMapper.count(dto);
		String seq = String.format("%03d", productCount+1);
		String productNo = "PR" + today + seq;
		dto.setProductNo(productNo);
		dto.setWriteTime(TimeUtil.get(time));
		dto.setUpdateTime(TimeUtil.get(time));
		productMapper.productAdd(dto);
	}

	@Override
	public void productDelete(Product dto) throws Exception {
		dto.setDeleteYn("Y");
		dto.setUpdateTime(TimeUtil.get(new Date()));
		
		productMapper.productDelete(dto);
//		productMapper.delete(dto);
	}

	@Override
	public void productUpdate(Product dto) throws Exception {
		// 수정가능항목
		// 삭제후 재등록? 업데이트?
		// 업데이트는 전체항목? or 브랜드,타입,모델 
//		productMapper.productUpdate(dto);
	}
	
	
}
