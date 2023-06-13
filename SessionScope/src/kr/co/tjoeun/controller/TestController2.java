package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

@Controller
@SessionAttributes({"sessionBean1","sessionBean2"}) // 1번
public class TestController2 {
	// 2번
	// @ModelAttribute를 활용해서 객체를 생성하고 반환하는 메소스 생성
	// return new TestBean1()에서 반환하는 객체의 주소를
	// @ModelAttribute("sessionBean1")에 지정한
	// "sessionBean1"라는 이름으로 session영역에 저장
	@ModelAttribute("sessionBean1")
	public TestBean1 sessionBean1() {
		return new TestBean1();
		
	}
	
	//TestBean2를 생성해서 했다.
	@ModelAttribute("sessionBean2")
	public TestBean2 sessionBean2() {
		return new TestBean2();
		
	}
	
	
	
	@GetMapping("/test7") //3번
	public String test7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		return "test7";
	}
	
	@GetMapping("/result7") 
	public String result7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		
		System.out.printf("sessionBean1.data1 :%s\n", sessionBean1.getData1() );
		System.out.printf("sessionBean1.data1 :%s\n", sessionBean1.getData2() );
		
		sessionBean1.getData1();
		sessionBean1.getData2();
		
		return "result7";
	}
	
	
	
	
	//출력방식 3가지 보기 request.Scope
	@GetMapping("/test8") //3번
	public String test8(@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		sessionBean2.setData3("화면구현2");
		sessionBean2.setData4("UI테스트2");
		return "test8";
	}
	
	@GetMapping("/result8")
	public String result8(@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		
		System.out.printf("sessionBean2.data3 :%s\n", sessionBean2.getData3() );
		System.out.printf("sessionBean2.data4 :%s\n", sessionBean2.getData4() );
		
		sessionBean2.getData3();
		sessionBean2.getData4();
		
		return "result8";
	}
	
	
	
	@GetMapping("/test9") //3번
	public String test9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
						@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		sessionBean2.setData3("화면구현2");
		sessionBean2.setData4("UI테스트2");	
		return "test9";
	}
	
	@GetMapping("/result9")
	public String result9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
						  @ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		System.out.printf("sessionBean1.data1 :%s\n", sessionBean1.getData1() );
		System.out.printf("sessionBean1.data2 :%s\n", sessionBean1.getData2() );
		System.out.printf("sessionBean2.data3 :%s\n", sessionBean2.getData3() );
		System.out.printf("sessionBean2.data4 :%s\n", sessionBean2.getData4() );
		
		sessionBean1.getData1();
		sessionBean1.getData2();
		sessionBean2.getData3();
		sessionBean2.getData4();
		
		return "result9";
	}
	
	
	
	//  @SessionAttributes({"sessionBean1","sessionBean2"}) // 1번 => SessionScope 영역에 변수 생성
	
	// 	@ModelAttribute("sessionBean1")
	// public TestBean1 sessionBean1() {    sessionBean1변수에 TestBean1객체를 생성해서 넣어준다.
	//	return new TestBean1();
	
	
	/*@GetMapping("/test7") //3번 .set으로  sessionBean1변수 안에 TestBean1객체에 data1,2에 내용을 넣고
	public String test7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		return "test7";
	}
	
	@GetMapping("/result7") //4번 요청해서 .get으로 추출
	public String result7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		
		System.out.printf("sessionBean1.data1 :%s\n", sessionBean1.getData1() );
		System.out.printf("sessionBean1.data1 :%s\n", sessionBean1.getData2() );
		
		sessionBean1.getData1();
		sessionBean1.getData2();
		
		return "result7";
	}*/
	
	
	
	
	}
	
	
	
	

