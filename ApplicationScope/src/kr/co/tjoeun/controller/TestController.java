package kr.co.tjoeun.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {

	// 처음에 servletcontext객체 생성해서 application에 넣기  = new ServletContext(); 생략ㅎㅏㄴ 것
	@Autowired
	ServletContext application;
	
	// @Autowired 안 했을 때 사용 하는 방법
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		ServletContext application = request.getServletContext();
		application.setAttribute("name", "더조은학원");
		return "test1";
	}
	
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		String name = (String)application.getAttribute("name");
		// 코드창에 나올 때 하는 거
		System.out.printf("name : %s\n", name);
		
		return "result1";
	}

	// @Autowired 사용했을 때, ServletContext application = request.getServletContext(); 안 써도 됨
	@GetMapping("/test2")
	public String test2() {
		
		application.setAttribute("name", "더조은학원");
		return "test2";
	}
	
	
	@GetMapping("/result2")
	public String result2() {
		
		String name = (String)application.getAttribute("name");
		// 코드창에 나올 때 하는 거
		System.out.printf("name : %s\n", name);
		
		return "result2";
	}

	// bean 클래스 생성해서
	@GetMapping("/test3")
	public String test3() {
		
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("더조은아카데미");
		bean1.setData2("IT학원");
		
		application.setAttribute("bean1", bean1);
		
		return "test2";
	}
	
	
	@GetMapping("/result3")
	public String result3() {
		
		TestBean1 bean1 = (TestBean1)application.getAttribute("bean1");
		
		
		// 코드창에 나올 때 하는 거
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result3";
	}


	
	
	
	
	
}
