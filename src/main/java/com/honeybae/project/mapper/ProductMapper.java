package com.honeybae.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.honeybae.project.dto.Product;
import com.honeybae.project.dto.Search;
@Repository
@Mapper
public interface ProductMapper {
	
	public List<Product> selectAll()throws Exception;
	public List<Product> selectList(Search searchDto)throws Exception;
	public Product selectOne(int productId)throws Exception;
	public void addProduct(Product productDto)throws Exception;
	public void updateProduct(Product productDto)throws Exception;
	public void deleteProduct(int productId)throws Exception;
	public void delete(int productId)throws Exception;
	public void viewCount(int productId)throws Exception;
	
	
	public List<Product> selectBrand(String brand)throws Exception;
	public List<Product> selectType(String type)throws Exception;
	public List<Product> selectSize(int size)throws Exception;
	public List<Product> selectCollaboration(boolean collaboration)throws Exception;
	public List<Product> selectRetro(boolean retro)throws Exception;
	public List<Product> selectUsed(boolean used)throws Exception;
	public List<Product> selectSoldout(boolean soldout)throws Exception;
	public List<Product> selectPrice(Map<String, Integer> priceMap)throws Exception;

}
