package kr.co.kmarket.admin.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.persistence.AdminCategory1Repo;
import kr.co.kmarket.admin.persistence.AdminCategory2Repo;
import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.Category2Vo;
import kr.co.kmarket.vo.ProductsVo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	@Autowired
	private AdminCategory1Repo cate1Repo;
	@Autowired
	private AdminCategory2Repo cate2Repo;
	
	@GetMapping("/admin/product/list")
	public String list(Model model, String pg) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountProducts();
		int pageEnd = service.getPageEnd(total);
				
		List<ProductsVo> products = service.selectProducts(start);
		
		model.addAttribute("products", products);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	@PostMapping("/admin/product/register")
	public String register(ProductsVo vo, HttpServletRequest req) throws Exception {
		vo.setThumb1(vo.getFile1().getOriginalFilename());
		vo.setThumb2(vo.getFile2().getOriginalFilename());
		vo.setThumb3(vo.getFile3().getOriginalFilename());
		vo.setDetail(vo.getFile4().getOriginalFilename());
		
		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		
		service.insertProduct(vo);
		
		// 파일 업로드
		MultipartFile f1 = vo.getFile1();
		MultipartFile f2 = vo.getFile2();
		MultipartFile f3 = vo.getFile3();
		MultipartFile f4 = vo.getFile4();
		
		//f1.transferTo(new File("/thumb/file1.jpg"));
		//f2.transferTo(new File("/thumb/file2.jpg"));
		//f3.transferTo(new File("/thumb/file3.jpg"));
		//f4.transferTo(new File("/thumb/file4.jpg"));
		
		return "redirect:/admin/product/register";
	}
	
	@ResponseBody
	@GetMapping("/admin/product/cate1")
	public List<Category1Vo> getCate1() {
		return cate1Repo.findAll();
	}
	
	@ResponseBody
	@GetMapping("/admin/product/cate2")
	public List<Category2Vo> getCate2(int code1) {
		return cate2Repo.findByCode1OrderBySeq(code1);
	}
	
}
