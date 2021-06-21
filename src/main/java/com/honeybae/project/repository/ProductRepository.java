package com.honeybae.project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.honeybae.project.dto.Product;
@Component
public class ProductRepository {
	
	private static List<Map<String,Object>> dbData = new ArrayList<>();

	public List<Product> selectList(Product dto)throws Exception{
		List<Product> respList = new ArrayList<>();
		for(Map<String,Object> data : dbData) {
			ObjectMapper mapper = new ObjectMapper();
			Product product = mapper.convertValue(data, Product.class);
			respList.add(product);
		}
		return respList;
	}
	
	public Product selectGet(String productId)throws Exception{
		Product product = null;
		for(Map<String, Object> data :  dbData) {
			if(data.get("productId").equals(productId)) {
				ObjectMapper mapper = new ObjectMapper();
				product = mapper.convertValue(data, Product.class);
			}
		}
		return product;
	}
	
	public int getCount()throws Exception{
		return dbData.size();
	}
	public void readCount(String productId)throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		for(Map<String,Object> data : dbData) {
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
		dbData.add(product);
	}
	
	public void updateProduct(Product dto)throws Exception{
		for(Map<String, Object> data : dbData) {
			String productId = (String)data.get("productId");
			if(productId.equals(dto.getProductId())) {
				ObjectMapper mapper = new ObjectMapper();
				data = mapper.convertValue(dto, Map.class);
			}
		}
	}
	
	public void deleteProduct(String productId)throws Exception{
		for(Map<String, Object> data : dbData) {
			String dbProductId = (String)data.get("productId");
			if(dbProductId.equals(productId)) {
				dbData.remove(data);
			}
		}
		
		
	}
	
}
	
	
