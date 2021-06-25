package com.honeybae.project.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.honeybae.project.dto.Product;
import com.honeybae.project.dto.Search;
import com.honeybae.project.service.ProductService;
@RestController
public class ProductionController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	// 표출갯수 지정
	@GetMapping(value="/product")
	public Map<String,Object> list(Search dto)throws Exception {
		logger.debug("productList");
		System.out.println(dto.toString());
		List<Product> list = productService.selectList(dto);
		Map<String,Object> respData = new LinkedHashMap<>();
		respData.put("status", "success");
		respData.put("totalCount", list.size());
		respData.put("list", list);
		return respData;
	}
	@GetMapping(value="/product/{productNo}")
	public Map<String,Object> get(@PathVariable("productNo")String productId)throws Exception{
		logger.debug("productGet");
		Product data = productService.selectOne(productId);
		Map<String,Object> respData = new LinkedHashMap<>();
		respData.put("status", "success");
		respData.put("data", data);
		return respData;
	}
	
	// 추가해야할 항목
	// 필수값 검사 
	// 리턴값 처리 ?
	@PostMapping(value="/product")
	public Map<String,Object> create(@RequestBody Product dto)throws Exception{
		logger.debug("productCreate");
		productService.addProduct(dto);
		Map<String,Object> respData = new HashMap<String,Object>();
		respData.put("status", "success");
		return respData;
	}
	@PutMapping(value="/product")
	public Map<String,String> update(@RequestBody Product dto)throws Exception{
		logger.debug("productUpdate");
		productService.updateProduct(dto);
		Map<String,String> respData = new HashMap<String,String>();
		respData.put("status", "success");
		return respData;
	}
	@DeleteMapping(value="/product")
	public Map<String,String> delete(@RequestBody Product dto)throws Exception{
		logger.debug("productDelete");
		System.out.println(dto.getProductId());
		productService.deleteProduct(dto.getProductId());
		Map<String,String> respData = new HashMap<String,String>();
		respData.put("status", "success");
		return respData;
	}
	
}
