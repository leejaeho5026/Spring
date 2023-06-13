package kr.co.tjoeun.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test(HttpServletRequest request) {
		
		request.setAttribute("num1", 123);
				
		return "test1";
	}

	@GetMapping("/test2")
	public String test2(Model model) {
		
		model.addAttribute("num1",123);
		
		return "test2";
	}

	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		
		mv.addObject("num1",123);
		mv.setViewName("test3");
		
		return mv;
	}

	@GetMapping("/test4")
	public String test4(@RequestParam Map<String,String> map) {
		String num1 = map.get("num1");
		
		
		
		return "test4";
	}
	
	@GetMapping("/test5")
	public String test5() {
		
		
		return "test5";
	}


}
