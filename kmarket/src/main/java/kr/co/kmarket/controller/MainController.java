package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.ProductsVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model) {
		List<CategoriesVo> cate1List = service.selectCategories();
		List<ProductsVo> hitList = service.selectHitProduct();
		List<ProductsVo> bestList = service.selectBestProduct();
		
		//System.out.println("길이1 : "+cate1List.size());
		//System.out.println("길이2 : "+cate1List.get(0).getCate2List().size());
		model.addAttribute("cate1List", cate1List);
		model.addAttribute("hitList", hitList);
		model.addAttribute("bestList", bestList);
		
		return "/index";
	}

	@ResponseBody
	@GetMapping("/main/recommend")
	public List<ProductsVo> recommend(Model model) {
		return service.selectRecProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/newItems")
	public List<ProductsVo> newItems() {
		return service.selectNewProduct();
	}

	@ResponseBody
	@GetMapping("/main/discountItems")
	public List<ProductsVo> discountItems() {
		return service.selectDiscountProduct();
	}
}
