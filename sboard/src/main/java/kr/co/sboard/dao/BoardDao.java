package kr.co.sboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.BoardVO;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("mapper.board.INSERT_BOARD", vo);
	}
	
	public void selectBoard() {}
	
	public List<BoardVO> selectBoards(int start) {
		return mybatis.selectList("mapper.board.SELECT_BOARDS", start);
	}
	
	public void updateBoard() {}
	public void deleteBoard() {}
	
	public int selectCountBoard() {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD");
	}
	
}
