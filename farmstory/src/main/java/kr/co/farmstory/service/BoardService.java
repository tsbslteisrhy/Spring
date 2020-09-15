package kr.co.farmstory.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.FileVO;

@Service
public class BoardService {
	
	@Inject
	private BoardDao dao;
	
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}
	
	public BoardVO selectBoard(String group, String cate, String seq) {
		return dao.selectBoard(group, cate, seq);
	}
	
	public List<BoardVO> selectBoards(int start, String cate) {
		return dao.selectBoards(start, cate);
	}
	
	public void updateBoard() {}
	public void deleteBoard() {}
	
	public List<BoardVO> selectLatest(String cate) {
		return dao.selectLatest(cate);
	}
	
	// Limit start ���
	public int getLimitStart(String pg) {
		if (pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
	}
	
	// ��ü �Խù� ����
	public int selectCountBoard(String cate) {
		return dao.selectCountBoard(cate);
	}
	
	// ������ ��ȣ ���
	public int getPageEnd(int total) {
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		}else {
			pageEnd = (total / 10) + 1;
		}
		
		return pageEnd;
	}
	
	// list count ���
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
	// ���� �׷� ���
	public int getGroupCurrent(String pg) {
		int page = Integer.parseInt(pg);
		return (int)Math.ceil(page/10.0);
	}
	
	// �׷� ���� ���
	public int getGroupStart(int groupCurrent) {
		return (groupCurrent -1) * 10 + 1;
	}
	
	// �׷� �� ���
	public int getGroupEnd(int groupCurrent, int pageEnd) {
		int groupEnd =  groupCurrent * 10;
		
		if(groupEnd > pageEnd) {
			groupEnd = pageEnd;
		}
		
		return groupEnd;
	}
	
	// ���� ���ε�
	public FileVO fileUpload(HttpServletRequest req, MultipartFile file, int seq) {
		
		String path = req.getSession().getServletContext().getRealPath("/resources/files/");
		
		if(!file.isEmpty()) {
			// ���� ÷�� ���� ��
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			
			// �������ϸ� ����
			String uName = UUID.randomUUID().toString()+ext;
			
			// ���� ����
			try {
				file.transferTo(new File(path+uName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileVO vo = new FileVO();
			vo.setParent(seq);
			vo.setOldName(oName);
			vo.setNewName(uName);
			
			return vo;
		}else {
			// ���� ÷�� �� ���� ��
			return null;
		}
	}
	
	// ���� �ٿ�ε�
	public void fileDownload() {}
}
