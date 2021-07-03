package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Product;
@Repository
@Mapper
public interface ProductMapper {
	
	public List<Product> selectList(Product dto)throws Exception;
	public Product selectGet(Product dto);
	public void addProduct(Product dto);
	public void updateProduct(Product dto);
	public void deleteProduct(Product dto);
	public void delete(Product dto);
	public int count(Product dto);
	public void readCount(Product dto);

}
