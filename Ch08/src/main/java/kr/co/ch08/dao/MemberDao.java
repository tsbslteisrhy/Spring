package kr.co.ch08.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.MemberVO;

@Repository
public class MemberDao {

	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("mapper.member.INSERT_MEMBER", vo);
	}
	
	public MemberVO selectMember(String uid) {
		MemberVO member = mybatis.selectOne("mapper.member.SELECT_MEMBER", uid);
		return member;
	}
	
	public List<MemberVO> selectMembers() {
		List<MemberVO> members = mybatis.selectList("mapper.member.SELECT_MEMBERS");
		return members;
	}
	
	public void updateMember(MemberVO vo) {
		mybatis.update("mapper.member.UPDATE_MEMBER", vo);
	}
	
	public void deleteMember(String uid) {
		mybatis.delete("mapper.member.DELETE_MEMBER", uid);
	}
}
