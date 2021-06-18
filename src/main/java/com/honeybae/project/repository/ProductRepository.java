package com.honeybae.project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.honeybae.project.dto.Product;
@Component
public class ProductRepository {
	
	private static List<Map<String,Object>> dbData = new ArrayList<>();

	public List<Product> selectList(Product dto)throws Exception{
//		Map<String,Object> data = new HashMap<String, Object>();
		List<Product> respList = new ArrayList<>();
		for(Map data : dbData) {
			Product product = new Product();
			product.setProductId((String)data.get("productId"));
			product.setBrand((String)data.get("brand"));
			product.setCollaborationYn((boolean)data.get("collaborationYn"));
			product.setCollaborationBrand((String)data.get("collaborationBrand"));
			product.setType((String)data.get("type"));
			product.setModel((String)data.get("model"));
			product.setName((String)data.get("name"));
			product.setColor((String)data.get("color"));
			product.setPrice((int)data.get("price"));
			product.setSize((int)data.get("size"));
			product.setQuantity((int)data.get("quantity"));
			product.setDescription((String)data.get("description"));
			product.setInMaterial((String)data.get("inMaterial"));
			product.setOutMaterial((String)data.get("outMaterial"));
			product.setRealSizeLength((float)data.get("realSizeLength"));
			product.setRealSizeWidth((float)data.get("realSizeWidth"));
			product.setWeight((float)data.get("weight"));
			product.setUsedYn((boolean)data.get("usedYn"));
			product.setReleaseDate((String)data.get("releaseDate"));
			product.setRetroYn((boolean)data.get("retroYn"));
			product.setWriter((String)data.get("writer"));
			product.setWriteTime((String)data.get("writeTime"));
			product.setUpdateTime((String)data.get("updateTime"));
			product.setSoldoutYn((boolean)data.get("soldoutYn"));
			product.setDeleteYn((boolean)data.get("deleteYn"));
			product.setReadCount((int)data.get("readCount"));
			respList.add(product);
		}
		return respList;
	}
	
	public Product selectGet(String productId)throws Exception{
		Product product = new Product();
		for(Map<String, Object> data :  dbData) {
			if(data.get("productId").equals(productId)) {
				product.setProductId((String)data.get("productId"));
				product.setBrand((String)data.get("brand"));
				product.setCollaborationYn((boolean)data.get("collaborationYn"));
				product.setCollaborationBrand((String)data.get("collaborationBrand"));
				product.setType((String)data.get("type"));
				product.setModel((String)data.get("model"));
				product.setName((String)data.get("name"));
				product.setColor((String)data.get("color"));
				product.setPrice((int)data.get("price"));
				product.setSize((int)data.get("size"));
				product.setQuantity((int)data.get("quantity"));
				product.setDescription((String)data.get("description"));
				product.setInMaterial((String)data.get("inMaterial"));
				product.setOutMaterial((String)data.get("outMaterial"));
				product.setRealSizeLength((float)data.get("realSizeLength"));
				product.setRealSizeWidth((float)data.get("realSizeWidth"));
				product.setWeight((float)data.get("weight"));
				product.setUsedYn((boolean)data.get("usedYn"));
				product.setReleaseDate((String)data.get("releaseDate"));
				product.setRetroYn((boolean)data.get("retroYn"));
				product.setWriter((String)data.get("writer"));
				product.setWriteTime((String)data.get("writeTime"));
				product.setUpdateTime((String)data.get("updateTime"));
				product.setSoldoutYn((boolean)data.get("soldoutYn"));
				product.setDeleteYn((boolean)data.get("deleteYn"));
				product.setReadCount((int)data.get("readCount"));
			}
		}
		return product;
	}
	
}
	
	
