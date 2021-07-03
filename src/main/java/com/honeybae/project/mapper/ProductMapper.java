package com.honeybae.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Product;
import com.honeybae.project.dto.Search;
@Repository
@Mapper
public interface ProductMapper {
	
	public List<Product> selectAll()throws Exception;
	public List<Product> selectList(Search searchDto)throws Exception;
	public Product selectOne(int productId);
	public void addProduct(Product productDto);
	public void updateProduct(Product productDto);
	public void deleteProduct(int productId);
	public void delete(int productId);
	public void viewCount(int productId);

}
