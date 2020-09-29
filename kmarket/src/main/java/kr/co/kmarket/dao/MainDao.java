package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface MainDao {

	public List<Category1Vo> selectCate1();
	public List<ProductsVo> selectHitProduct();
	public List<ProductsVo> selectBestProduct();
	public List<ProductsVo> selectRecProduct();
}
