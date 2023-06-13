package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {

	/*
	 * xml 설정방식으로 할 때
	 * scope="request" 인 경우에는
	 * @Lazy 을 사용해야 요청이 들어올 때만 bean 객체가 주입됨
	 */
	
	
	// @RequestScope: Bean이 주입되는 시기 -> 새로운 요청이 발생할 때
	
	// @Bean
	// @RequestScope	
	// TestBean1를 반환하는 메소드
	// public TestBean1 testBean1() {
	//	return new TestBean1();
	
	@Autowired
	@Lazy // 늦게 주입하라
	TestBean1 testBean1;  //변수 선언 new TestBean1(); 할 필요 없다 => @Autowired사용하면
	
	//@Bean("testBean2")
	//@RequestScope
	//public TestBean2 testBean2() {
	//	return new TestBean2();
		
	@Resource(name = "testBean2") //새로운 요청(request)가 발생될 때 주입된다.
	@Lazy
	TestBean2 testBean2;
	
	@Autowired
	@Lazy
	TestBean3 testBean3;
	
	@Resource(name="testBean4")
	@Lazy
	TestBean4 testBean4;
	
	@GetMapping("/testBean1")
	public String testBean1() {
		testBean1.setData1("자바웹");
		testBean1.setData2("프레임워크");		
		
		testBean2.setData3("파이썬");
		testBean2.setData4("C언어");		
		
		testBean3.setData5("서블릿");
		testBean3.setData6("jsp");
		
		testBean4.setData7("프론트");
		testBean4.setData8("백엔드");			
		
		// forwarding : 새로운 요청이 발생하지 않음 => jsp에서 확인이 안됨 @Autowired가 실행이 안 되기 때문에
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		
		model.addAttribute("testBean1", testBean1);
	 //	model.addAttribute("testBean2", testBean2);
		model.addAttribute("testBean3", testBean3);		
		model.addAttribute("testBean4", testBean4);	
		
	System.out.printf("testBean1.data1 : %s\n", testBean1.getData1());
	System.out.printf("testBean1.data2 : %s\n", testBean1.getData2());	
	
	System.out.printf("testBean2.data3 : %s\n", testBean2.getData3());
	System.out.printf("testBean2.data4 : %s\n", testBean2.getData4());	
	
	System.out.printf("testBean3.data5 : %s\n", testBean3.getData5());
	System.out.printf("testBean3.data6 : %s\n", testBean3.getData6());				
		
	System.out.printf("testBean4.data7 : %s\n", testBean4.getData7());
	System.out.printf("testBean4.data8 : %s\n", testBean4.getData8());	
	
	return "result1";
	}










}
