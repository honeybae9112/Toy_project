package com.honeybae.project.service;

import java.util.List;

import com.honeybae.project.dto.Product;

public interface ProductService {
	
	List<Product> selectAll(Product dto)throws Exception;

	Product selctOne(String productNo)throws Exception;
	
	void productAdd(Product dto)throws Exception;
	
	void productDelete(Product dto)throws Exception;

	void productUpdate(Product dto)throws Exception;

}
