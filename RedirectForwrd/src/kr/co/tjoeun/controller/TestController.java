package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1() {
		
		return "redirect:/sub1"; //브라우저서버에서 서버로 요청 
	}
	@GetMapping("/sub1")
	public String sub1() {
		
		return "sub1";
	}

	@GetMapping("/test2")
	public String test2() {
		
		return "forward:/sub2"; //브라우저를 안 거치고 바로 가기 때문에 주소창은 안 바뀐다.
	}

	@GetMapping("/sub2")
	public String sub2() {
		
		return "sub2";
	}
}
