package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.ProductsVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model) {
		List<Category1Vo> cate1List = service.selectCate1();
		List<ProductsVo> hitList = service.selectHitProduct();
		List<ProductsVo> bestList = service.selectBestProduct();
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
}
