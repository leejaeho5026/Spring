package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	// 주소표시줄에 /test2?number1=111&number2=222 이렇게 나오면 
	// number1=111, number2=222이 두 변수가 메모리에 올라감
	// test1.jsp에서 EL로 이 변수값을 받을 수 있음 number1 : ${param.number1 },number2 : ${param.number2 }
	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}

	// 주소표시줄에 /test2?number1=111&number2=222 이렇게 나오면 
	// 내장객체인 HttpServletRequest를 사용해서 이를 메모리에 올릴 수 있음
	// setAttribute() 메소드를 사용해서 메모리에 올라간
	// data를 test2.jsp에서 ${requestScope.number1},${requestScope.number2}로 받을 수 있음
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		request.setAttribute("number1", 111);
		request.setAttribute("number2", 222);
		
		return "test2";
	}

	// Model로 받기
	@GetMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("number1", 111);
		model.addAttribute("number2",222);
		return "test3";
	}
	
	//ModelAndView 객체를 주입 받는 메소드
	//modelAndView 객체를 return 함
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("number1",1234);
		mv.addObject("number2",5678);
		mv.setViewName("test4");
		
		return mv;
	}
}
