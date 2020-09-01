package kr.co.ch04.sub2;

import org.springframework.stereotype.Component;

@Component("bs2")
public class BoardService {
	
	public void insert() {
		System.out.println("핵심관심 - insert...");
		return;
	}
	
	public void select() {
		System.out.println("핵심관심 - select...");
	}
	
	public void update(int seq) {
		System.out.println("핵심관심 - update...");
	}
	
	public void delete(int seq, String uid) {
		System.out.println("핵심관심 - delete...");
		
		// 예외 발생 - 5번째 문자 없음 : afterthrow 횡단관심 발생
		char ch = uid.charAt(5);
	}
	
}
