package kr.co.kmarket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kmarket.persistance.MemberRepo;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ResultVo;

@RestController
public class MemberRestController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/checkUid")
	public ResultVo checkUid(String uid) {
		return service.selectCountUid(uid);
	}
}
