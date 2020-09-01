package kr.co.ch04.sub1;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Inject
	private LogAdvice log;

	public void insert() {
		log.beforeLog();
		System.out.println("핵심관심 - insert...");
		log.afterLog();
	}
	
	// LogAdvice -beforeLog() 실행 위치
	public void select() {
		System.out.println("핵심관심 - select...");
	}
	// LogAdvice -afterLog() 실행 위치
	
	public void update(int seq) {
		System.out.println("핵심관심 - update...");
	}
	
	public void delete(int seq, String uid) {
		System.out.println("핵심관심 - delete...");
	}
	
}
