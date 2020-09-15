package kr.co.farmstory.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.vo.BoardVO;

@Repository
public class BoardDao {

	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("mapper.board.INSERT_BOARD", vo);
	}
	
	public BoardVO selectBoard(String group, String cate, String seq) {
		Map<String,	Object> values = new HashMap<>();
		values.put("group", group);
		values.put("cate", cate);
		values.put("seq", seq);
		
		return mybatis.selectOne("mapper.board.SELECT_BOARD", values);
	}
	
	public List<BoardVO> selectBoards(int start, String cate) {
		Map<String, Object> values = new HashMap<>();
		values.put("start", start);
		values.put("cate", cate);
		
		return mybatis.selectList("mapper.board.SELECT_BOARDS", values);
	}
	public int selectCountBoard(String cate) {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD", cate);
	}
	
	public void updateBoard() {}
	public void deleteBoard() {}
	
	public List<BoardVO> selectLatest(String cate) {
		return mybatis.selectList("mapper.board.SELECT_LATEST", cate);
	}
}
