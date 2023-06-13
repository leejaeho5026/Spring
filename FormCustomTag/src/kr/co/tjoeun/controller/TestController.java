package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.tjoeun.beans.UserInfoBean;

@Controller
public class TestController {

	@GetMapping("/test1")
	//@ModelAttribute 생략 
	public String test1(UserInfoBean bean) {
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostcode("1004");
		bean.setUserAddress1("일산");
		bean.setUserAddress2("정발산동");
		
		return "test1";
	}

	//이름 : <form:input  path="userName"/><br>  앞에가 소문자
	@GetMapping("/test2")
	public String test2(UserInfoBean bean) {
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostcode("1004");
		bean.setUserAddress1("일산");
		bean.setUserAddress2("정발산동");
		
		return "test2";
	}

	// bean으로 바꾸기 @ModelAttribute("bean")
	@GetMapping("/test3")
	public String test3(@ModelAttribute("bean")UserInfoBean bean) {
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostcode("1004");
		bean.setUserAddress1("일산");
		bean.setUserAddress2("정발산동");
		
		return "test3";
	}

	// Model 사용 객체를 주입하지 않고 객체를 생성 
	@GetMapping("/test4")
	public String test4(Model model) {
		
		UserInfoBean bean = new UserInfoBean();
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostcode("1004");
		bean.setUserAddress1("일산");
		bean.setUserAddress2("정발산동");
		
		// bean에 저장하기
		model.addAttribute("bean", bean);
		//jsp에서 빼올 때도 bean으로 빼야한다.
		//<form:form modelAttribute="bean" action= "result">
		return "test4";
	}



}
