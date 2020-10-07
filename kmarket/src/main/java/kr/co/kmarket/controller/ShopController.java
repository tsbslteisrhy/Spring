package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductsVo;

@Controller
public class ShopController {

	@Autowired
	private ShopService service;
	
	@GetMapping("/shop/search")
	public String search() {
		return "/shop/search";
	}
	
	@GetMapping("/shop/list")
	public String list(int cate1, int cate2, int sort, Model model, HttpSession sess) {
		// DB 자주 access하면 좋지 않으므로 session에 정보를 저장하여 불러오는 방식을 택한다.
		// List<CategoriesVo> cate1List = service.selectCategories();
		// model.addAttribute("cate1List", cate1List);
		
		List<ProductsVo> items = service.selectProducts(cate1, cate2, sort);
		
		List<CategoriesVo> categories = (List<CategoriesVo>) sess.getAttribute("cate1List");
		String tit1 = categories.get(cate1-1).getTitle();
		String tit2 = categories.get(cate1-1).getCate2List().get(cate2-1).getTitle();
		
		model.addAttribute("tit1", tit1);
		model.addAttribute("tit2", tit2);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("items", items);
		
		return "/shop/list";
	}
	
	@GetMapping("/shop/view")
	public String view() {
		return "/shop/view";
	}
	
	@GetMapping("/shop/cart")
	public String cart() {
		return "/shop/cart";
	}
	
	@GetMapping("/shop/order")
	public String order() {
		return "/shop/order";
	}
	
	@GetMapping("/shop/order-complete")
	public String orderComplete() {
		return "/shop/order-complete";
	}
}
