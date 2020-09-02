package kr.co.ch06;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ��¥ : 2020/09/02
 * �̸� : ��ȿ��
 * ���� : ������ JDBC SELECT �ǽ��ϱ�
 */
public class JDBCSelectTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		UserDAO dao = (UserDAO) ctx.getBean("userDAO");
		
		UserVO vo = dao.selectUser("J101");
		System.out.println("���̵�: "+vo.getUid());
		System.out.println("�̸�: "+vo.getName());
		System.out.println("�޴���: "+vo.getHp());
		System.out.println("����: "+vo.getAge());
		
		List<UserVO> users = dao.selectUsers();
		
		for(UserVO user : users) {
			System.out.println("===================");
			System.out.println("���̵�: "+user.getUid());
			System.out.println("�̸�: "+user.getName());
			System.out.println("�޴���: "+user.getHp());
			System.out.println("����: "+user.getAge());
			System.out.println("-------------------");
		}
		
		System.out.println("���α׷� ����...");
	}
}
