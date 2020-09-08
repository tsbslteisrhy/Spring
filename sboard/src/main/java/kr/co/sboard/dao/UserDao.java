package kr.co.sboard.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Repository
public class UserDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void selectUser() {}
	public void selectUsers() {}
	
	public void insertUser(UserVO vo) {
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return mybatis.selectOne("mapper.user.SELECT_TERMS");
	}
	
	public int selectUserCount(String uid) {
		return mybatis.selectOne("mapper.user.SELECT_USER_COUNT", uid);
	}
}
