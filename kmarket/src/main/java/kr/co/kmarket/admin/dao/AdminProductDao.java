package kr.co.kmarket.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface AdminProductDao {

	public void insertProduct(ProductsVo vo); 
	public ProductsVo selectProduct(); 
	public List<ProductsVo> selectProducts(); 
	public void updateProduct(); 
	public void deleteProduct();
	
	public int selectCountProducts();
	
}
