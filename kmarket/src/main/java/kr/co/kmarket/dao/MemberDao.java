package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ResultVo;

@Repository
public interface MemberDao {
	
	public ResultVo selectCountUid(String uid);
}
