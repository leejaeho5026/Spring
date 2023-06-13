package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		//public String test1(HttpSession session){
		
		// HttpSession 객체 생성하기
		HttpSession session = request.getSession();
		// session 영역에 data 저장하기
		session.setAttribute("data1", "스프링웹");
		
		return "test1";
		
	}

	@GetMapping("/test2_redirect")
	public String test2(HttpServletRequest request) {
		//public String test1(HttpSession session){
		
		// HttpSession 객체 생성하기
		HttpSession session = request.getSession();
		// session 영역에 data 저장하기
		session.setAttribute("data1", "MVC패턴");
		
		return "redirect:/result1";
		
	}
	@GetMapping("/test3_forward")
	public String test3(HttpServletRequest request) {
		//public String test1(HttpSession session){
		
		// HttpSession 객체 생성하기
		HttpSession session = request.getSession();
		// session 영역에 data 저장하기
		session.setAttribute("data1", "Model2방식");
		
		return "forward:/result1";
		
	}
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		//public String result1(HttpSession session) {
		
		// HttpSession 객체 생성하기
    	 HttpSession session = request.getSession();
		// session 영역에 data 저장하기
		String data1 = (String) session.getAttribute("data1");
		System.out.printf("data1 : %s\n", data1);
		return "result1";
		
	}

	@GetMapping("/test4")
	public String test4(HttpSession session) {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("자바웹");
		bean1.setData2("HTML/CSS");
		
		session.setAttribute("bean1", bean1);
	
		return"test4";
	}

	@GetMapping("/result4")
	public String result4(HttpSession session) {
	// 화면에 출력 안 할려면 이건 필요없다.
   // TestBean1 bean1 = (TestBean1)session.getAttribute("bean1");
   //	System.out.printf("bean1.data1 :%s\n ", bean1.getData1());
   //	System.out.printf("bean1.data2 :%s\n ", bean1.getData2());
		return "result4";
			
				
	}

	
	@GetMapping("/test5")
	public String test5(HttpSession session) {
		
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTML/CSS/JSON");
		
		//객체를 session scope에 올리기
		session.setAttribute("bean1", bean1);
	
		return"test5";
	}

	@GetMapping("/result5")
	// session.setAttribute("bean1" 이렇게 올렸으니 bean1로 똑같이 받아야한다.
	public String result5(@SessionAttribute("bean1") TestBean1 bean) { // 마지막 bean로 .get해야한다.
	// 화면에 출력 안 할려면 이건 필요없다.

	//	System.out.printf("bean.data1 : %s\n ", bean.getData1());
	//	System.out.printf("bean.data2 : %s\n ", bean.getData2());
		return "result5";
			
				
	}	
	
	@GetMapping("/test6")
	public String test6(HttpSession session, TestBean1 bean1) {
		
	//	TestBean1 bean1 = new TestBean1(); 위에 TestBean1 bean1넣으면 안 해도 된다.
	//  ModelAttribute가 생략이어 있는 것
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTML/CSS/JSON");
		
		//객체를 session scope에 올리기
		session.setAttribute("bean1", bean1);
	
		return"test6";
	}

	@GetMapping("/result6")
	// session.setAttribute("bean1" 이렇게 올렸으니 bean1로 똑같이 받아야한다.
	// session.getAttribute("bean1")를 자동으로 한다.
	public String result6(@SessionAttribute("bean1") TestBean1 bean) { // 마지막 bean로 .get해야한다.
	// 화면에 출력 안 할려면 이건 필요없다.

		System.out.printf("bean.data1 : %s\n ", bean.getData1());
		System.out.printf("bean.data2 : %s\n ", bean.getData2());
		return "result6";
			
				
	}	
	
	
	
	
	
	
	
	
	
	
	
}
