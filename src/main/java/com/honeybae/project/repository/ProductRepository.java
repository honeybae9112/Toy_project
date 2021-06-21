package com.honeybae.project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.honeybae.project.dto.Product;
@Component
public class ProductRepository {
	
	private static List<Map<String,Object>> DB = new ArrayList<>();

	public List<Product> selectList()throws Exception{
		List<Product> respList = new ArrayList<>();
		for(Map<String,Object> dbData : DB) {
			ObjectMapper mapper = new ObjectMapper();
			Product product = mapper.convertValue(dbData, Product.class);
			respList.add(product);
		}
		return respList;
	}
	public List<Product> selectList(Map searchData)throws Exception{
		List<Product> respList = new ArrayList<>();
		for(Map<String,Object> dbData : DB) {
			Product product = null;
			ObjectMapper mapper = new ObjectMapper();
			String dbBrand = (String)dbData.get("brand");
			String searchBrand = (String)searchData.get("brand");
			if(dbBrand.equals(searchBrand)) {
				product = mapper.convertValue(dbData, Product.class);
				respList.add(product);
			}
		}
		return respList;
	}
	
	public Product selectGet(String productId)throws Exception{
		Product product = null;
		for(Map<String, Object> dbData :  DB) {
			if(dbData.get("productId").equals(productId)) {
				ObjectMapper mapper = new ObjectMapper();
				product = mapper.convertValue(dbData, Product.class);
			}
		}
		return product;
	}
	
	public int getCount()throws Exception{
		return DB.size();
	}
	public void readCount(String productId)throws Exception{
		for(Map<String,Object> data : DB) {
			String dbProductId = (String)data.get("productId");
			if(dbProductId.equals(productId)) {
				int readCount = (int) data.get("readCount");
				readCount += 1;
				data.put("readCount", readCount);
			}
		}
	}
	
	public void addProduct(Product dto)throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> product = mapper.convertValue(dto, Map.class);
		DB.add(product);
	}
	
	public void updateProduct(Product dto)throws Exception{
		for(Map<String, Object> dbData : DB) {
			String dbProductId = (String)dbData.get("productId");
			if(dbProductId.equals(dto.getProductId())) {
				ObjectMapper mapper = new ObjectMapper();
				dbData.putAll(mapper.convertValue(dto, Map.class));
			}
		}
	}
	
	public void deleteProduct(String productId)throws Exception{
		for(Map<String, Object> dbData : DB) {
			String dbProductId = (String)dbData.get("productId");
			if(dbProductId.equals(productId)) {
				DB.remove(dbData);
			}
		}
		
		
	}
	
}
	
	
