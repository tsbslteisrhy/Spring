package kr.co.farmstory.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.BoardVO;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@GetMapping("/board/write")
	public String write(String group, String cate, Model model) {
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(BoardVO vo, String group, String cate, Model model, HttpServletRequest req) {
		vo.setRegip(req.getRemoteAddr());
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String list(String group, String cate, String pg, Model model) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountBoard(cate);
		int pageEnd = service.getPageEnd(total);
		int count = service.getListCount(total, start);
				
		List<BoardVO> boards = service.selectBoards(start, cate);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute("boards", boards);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		
		return "/board/list";
	}
	
	@GetMapping("/board/view")
	public String view(String group, String cate, String seq, Model model) {
		BoardVO board = service.selectBoard(group, cate, seq);
		
		model.addAttribute("board", board);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute("seq", seq);
		
		return "/board/view";
	}
	
	@GetMapping("/board/modify")
	public String modify(String group, String cate, Model model) {
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "/board/modify";
	}
	
	@GetMapping("/board/delete")
	public void delete(String group, String cate, Model model) {
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
	}
}
