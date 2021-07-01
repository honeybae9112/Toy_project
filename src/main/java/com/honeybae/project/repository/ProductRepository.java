package com.honeybae.project.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.honeybae.project.dto.Product;
@Component
public class ProductRepository {
	
	private static Map<String,Object> DB = new LinkedHashMap<>();

	public List<Product> selectList()throws Exception{
		List<Product> respList = new ArrayList<>();
		for(String productId : DB.keySet()) {
			respList.add((Product)DB.get(productId));
		}
		return respList;
	}

	public Product selectOne(String productId)throws Exception{
		return (Product)DB.get(productId);
	}
	public int getCount()throws Exception{
		int count = 0;
		for(String productId : DB.keySet()) {
			count ++;
		}
		return count;
	}
	public void readCount(String productId)throws Exception{
		Product dbData = (Product) DB.get(productId);
		int readCount = dbData.getReadCount();
		dbData.setReadCount(readCount+1);
	}
	
	public void addProduct(Product dto)throws Exception{
		DB.put(dto.getProductId(), dto);
	}
	
	public void updateProduct(String productId,Product dto)throws Exception{
		DB.replace(productId, dto);
	}
	
	public void deleteProduct(String productId)throws Exception{
		DB.remove(productId);
	}
	
}
	
	
