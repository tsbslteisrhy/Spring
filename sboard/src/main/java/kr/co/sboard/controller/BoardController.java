package kr.co.sboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Model model, String pg) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountBoard();
		int pageEnd = service.getPageEnd(total);
		int count = service.getListCount(total, start);
		
		List<BoardVO> articles = service.selectBoards(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		
		return "/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, BoardVO vo) {
		vo.setRegip(req.getRemoteAddr());
		service.insertBoard(vo);
		
		return "redirect:/list";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
}
