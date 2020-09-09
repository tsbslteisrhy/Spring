package kr.co.sboard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class UserDaoTest {
	
	@Inject
	private UserDao dao;
	
	//@Test - µøΩ√ `Ω««‡ ∞°¥…
	public void selectTerms() {
		dao.selectTerms();
	}
	
	//@Test
	public void selectUserCount() {
		int result = dao.selectUserCount("a101");
		System.out.println("result : "+result);
	}
	
	@Test
	public void insertUser() {
		UserVO vo = new UserVO();
		vo.setUid("a109");
		vo.setPass1("1234");
		vo.setName("¿”≤©¡¥");
		vo.setNick("≤©¡¥");
		vo.setEmail("lim@gmail.com");
		vo.setHp("010-1234-1212");
		vo.setRegip("192.16.21.12");
		
		dao.insertUser(vo);
	}
}
