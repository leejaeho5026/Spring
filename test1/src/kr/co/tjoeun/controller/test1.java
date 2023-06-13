package kr.co.tjoeun.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class test1 {

	@RequestMapping("/test1")
	public String test1(HttpServletRequest request) {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		
		return "test1";
	}

	@GetMapping("/test2/{n1}/{n2}/{n3}/{n4}")
	public String test2(@PathVariable String n1,
						@PathVariable String n2,
						@PathVariable String n3,
						@PathVariable String n4) {
		
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
		System.out.println("n3 : " + n3);
		System.out.println("n4 : " + n4);
		return "test2";
	}


	@GetMapping("/test3")
	public String test3(@RequestParam int num1,
						@RequestParam int num2,
						@RequestParam int nums) {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("nums : " + nums);
		
		return "test3";
	}

	@GetMapping("/test4")
	public String test4(@RequestParam(value="num1") int n1,
						@RequestParam(value="num2") int n2,
						@RequestParam(value="nums") int[] ns) {
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
		System.out.println("ns[0] : " + ns[0]);
		System.out.println("ns[1] : " + ns[1]);
		
		return "test4";
	}
}
