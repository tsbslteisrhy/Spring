package kr.co.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/hello")
	public String hello(){
		return "/hello";
	}
}
