package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.DataBean1;
import kr.co.tjoeun.beans.DataBean2;
import kr.co.tjoeun.beans.DataBean3;

@Controller
public class TestController {

	// DataBean1: 커맨드 객체
	// 커맨드 객체는 HttpServletRequest 객체에 자동으로 담겨 저장되므로
	// 지정한 이름의 View(test1.jsp)로 전달됨 =><h3> number1 : ${requestScope.DataBean1(클래스이름으로).number1 }</h3> jsp에서 받는다.
	// 이때, HttpServletRequest객체에 자동으로 저장되는 이름은 클래스의 이름으로 됨 (첫 글자는 소문자로 해야함)
	// =>	<h3> number1 : ${requestScope.dataBean1.number1 }</h3>
	// (@ModelAttribute DataBean1 bean1) => parameter로 선언된 객체(DataBean1)를 HttpServletRequest객체에 담아서 jsp로 전달
	@PostMapping("/test1")
	public String test1(@ModelAttribute DataBean1 bean1) {
		System.out.printf("number1 : %s\n", bean1.getNumber1());
		System.out.printf("number2 : %s\n", bean1.getNumber2());
		
		return "test1";
	}

	// HttpServletRequest 객체에 자동으로 저장되는 이름을 클래스이름으로 안 하고
	// 다른이름으로 할 때 @ModelAttribute("bean2") 뒤에 ("bean2")추가
	// El에서 받는 클래스명을 바꾸고 싶을 때
	// 	<h3> number3 : ${requestScope.bean2.number3 }</h3> jsp에서 이렇게 받아야함
	@PostMapping("/test2")
	public String test1(@ModelAttribute("bean2") DataBean2 bean2) { //@ModelAttribute("bean2") 뒤에 ("bean2")추가
		

		System.out.printf("number3 : %s\n", bean2.getNumber3());
		System.out.printf("number4 : %s\n", bean2.getNumber4());
		
		return "test2";
	}

	// @ModelAttribute 어노테이션 생략하기
	// 생략을 하면 이름을 못 바꿔서 그대로 받아야함 => <h3> number5 : ${requestScope.dataBean3.number5 }</h3>
	@PostMapping("/test3")
	public String test3(DataBean3 bean3) {
		

		System.out.printf("number5 : %s\n", bean3.getNumber5());
		System.out.printf("number6 : %s\n", bean3.getNumber6());
		
		return "test3";
	}
}
