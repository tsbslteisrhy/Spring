package kr.co.ch07.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.ch07.dao.UserDao;
import kr.co.ch07.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	private UserDao dao;
	
	// controller와 dao 매개역할이므로 dao의 메서드를 가지고 있어야 함
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	
	public void selectUser() {}
	
	public List<UserVO> selectUsers() {
		return dao.selectUsers();
	}
	
	public void updateUser() {}
	
//	public void deleteUser(List<UserVO> users) {
//		dao.deleteUser(users);
//	}
	
}
