package kr.co.kmarket.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.admin.persistence.AdminProductsRepo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDao dao;
	@Autowired
	private AdminProductsRepo repo;
	
	public void insertProduct(ProductsVo vo) {
		repo.save(vo);
	} 
	
	public ProductsVo selectProduct() {
		return dao.selectProduct();
	}
	
	public List<ProductsVo> selectProducts(int start) {
		return dao.selectProducts(start);
	} 
	
	public void updateProduct() {
		dao.updateProduct();
	}
	
	public void deleteProduct() {
		dao.deleteProduct();
	}
	
	// Limit start 계산
	public int getLimitStart(String pg) {
		if (pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
	}
	
	// 전체 게시물 개수
	public int selectCountProducts() {
		return dao.selectCountProducts();
	}
	
	// 페이지 번호 계산
	public int getPageEnd(int total) {
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		}else {
			pageEnd = (total / 10) + 1;
		}
		
		return pageEnd;
	}
	
	// list count 계산
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
}
