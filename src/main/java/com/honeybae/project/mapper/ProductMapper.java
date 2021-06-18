package com.honeybae.project.mapper;

import java.util.List;

import com.honeybae.project.dto.Product;
//@Mapper
//@Repository
public interface ProductMapper {
	
	public List<Product> selectList(Product dto)throws Exception;
	public Product selectGet(Product dto);
	public void productAdd(Product dto);
	public void productUpdate(Product dto);
	public void productDelete(Product dto);
	public void delete(Product dto);
	public int count(Product dto);
	public void readCount(Product dto);

}
