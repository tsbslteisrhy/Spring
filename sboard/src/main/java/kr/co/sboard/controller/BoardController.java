package kr.co.sboard.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

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
		
		int groupCurrent = service.getGroupCurrent(pg);
		int groupStart = service.getGroupStart(groupCurrent);
		int groupEnd= service.getGroupEnd(groupCurrent, pageEnd);
		
		
		
		List<BoardVO> articles = service.selectBoards(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		model.addAttribute("count", count);
		
		model.addAttribute("groupCurrent", groupCurrent);
		model.addAttribute("groupStart", groupStart);
		model.addAttribute("groupEnd", groupEnd);
		
		return "/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, BoardVO vo) {
		vo.setRegip(req.getRemoteAddr());
		
		MultipartFile file = vo.getFname();
		
		if(file.isEmpty()) {
			vo.setFile(0);
		}else {
			vo.setFile(1);
		}
		
		int seq = service.insertBoard(vo);
		FileVO fvo = service.fileUpload(req, file, seq);
		
		if(fvo != null) {
			service.insertFile(fvo);
		}
		
		return "redirect:/list";
	}
	
	@GetMapping("/view")
	public String view(int seq, Model model) {
		
		BoardVO vo = service.selectBoard(seq);
		
		model.addAttribute(vo);
		return "/view";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
	@GetMapping("/file/download")
	public void fileDownload(String newName, String oldName, HttpServletRequest req, HttpServletResponse resp) {
		
		// 파일테이블에서 파일정보 가져오기
		//FileVO vo = service.fileDownload(parent);

		String filePath = req.getSession().getServletContext().getRealPath("/");
		filePath += "resources/files/"+newName;

		try {
			File file = new File(filePath);
			
			String name = new String(oldName.getBytes("UTF-8"), "iso-8859-1");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setHeader("Content-Disposition", "attachment; filename="+name);
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			
			// 스트림 연결 : 파일 ---- response객체 
			BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream()); 
			
			
			byte buffer[] = new byte[1024*8];
			
			while(true){
				// Input스트림으로 데이터 읽어오기	
				int read = bis.read(buffer);
				if(read == -1){
					break;
				}
				
				// Output 스트림으로 데이터 쓰기
				bos.write(buffer, 0, read);
			}
			
			bis.close();
			bos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
