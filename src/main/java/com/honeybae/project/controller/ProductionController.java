package com.honeybae.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Product;
import com.honeybae.project.service.ProductService;
@RestController
public class ProductionController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	// 표출갯수 지정
	@GetMapping(value="/product")
	public Map<String,Object> list(Product dto)throws Exception {
		logger.debug("productList");
		List<Product> list = productService.selectAll(dto);
		Map<String,Object> respData = new HashMap<String,Object>();
		respData.put("status", "success");
		respData.put("totalCount", list.size());
		respData.put("list", list);
		return respData;
	}
	@GetMapping(value="/product/{productNo}")
	public Product get(@PathVariable("productNo")String productNo)throws Exception{
		logger.debug("productGet");
		return productService.selctOne(productNo);
	}
	
	// 추가해야할 항목
	// 필수값 검사 
	// 트랜잭션 처리
	// 리턴값 처리 ?
	@PostMapping(value="/product")
	public Map<String,Object> create(@RequestBody Product dto)throws Exception{
		logger.debug("productCreate");
//		productService.productAdd(dto);
		Map<String,Object> respData = new HashMap<String,Object>();
		respData.put("status", "success");
		return respData;
	}
	@PutMapping(value="/product")
	public Map<String,String> update(@RequestBody Product dto)throws Exception{
		logger.debug("productUpdate");
//		productService.productUpdate(dto);
		Map<String,String> respData = new HashMap<String,String>();
		respData.put("status", "success");
		return respData;
	}
	@DeleteMapping(value="/product")
	public Map<String,String> delete(@RequestBody Product dto)throws Exception{
		logger.debug("productDelete");
//		productService.productDelete(dto);
		Map<String,String> respData = new HashMap<String,String>();
		respData.put("status", "success");
		return respData;
	}
	
}
