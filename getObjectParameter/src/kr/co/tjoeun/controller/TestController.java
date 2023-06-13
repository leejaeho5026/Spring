package kr.co.tjoeun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ko.co.tjoeun.beans.BeansData;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1Get(@RequestParam Map<String,String> map) {
		String strNum1 = map.get("num1"); //get으로 꺼낼 때 키값이 일치해야한다. 
										  // <a href = "test1?num1=111&num2=222&numbers=333&numbers=444">test1_get</a>
		String strNum2 = map.get("num2");
		String numbers = map.get("numbers");
	
		System.out.printf("num1 : %s\n", strNum1);
		System.out.printf("num2 : %s\n", strNum2);
		// number는 2개인데 이름이 같아서 하나밖에 못 받아왔다.
		System.out.printf("numbers :%s\n ", numbers);
		return "result";
	}


	@GetMapping("/test2")
	public String test2Get(@RequestParam Map<String,String> map,
						   @RequestParam List<String> numbers) {  // 넘어오는 키명은 일치 시켜야된다.
		String num1 = map.get("num1"); 
		String num2 = map.get("num2");
		String numberMap = map.get("numberMap");
	
		System.out.printf("num1 : %s\n", num1);
		System.out.printf("num2 : %s\n", num2);
		//@RequestParam List를 추가해서 number333,444 값을 받아오기 위해 만들었다.
		System.out.printf("number :%s\n ", numberMap);
		
		System.out.println("같은 이름으로 전달된 2개의 data");
		int index = 0;
		for(String strNum : numbers) {
			System.out.printf("nembers[%d] : %s\n" , index, strNum); //strNum은 for String ()에 내용하고 일치하게
			index +=1;
		}
		
		return "result";
	}
	// test3가 오류가 남 하나씩 받을 땐 가능 많아서 오류
	@GetMapping("/test3")
	public String test3Get(@RequestParam Map<String,Integer> map,
						   @RequestParam List<Integer> numbers) {  //List<> Integer로 받기(기본은String인데 형변환)
		int num1 = map.get("num1"); 
		int num2 = map.get("num2");
		int numberMap = map.get("numberMap");
	
		System.out.printf("num1 : %d\n", num1); // integer로 받아서 %d\n으로 바꿔야함
		System.out.printf("num2 : %d\n", num2);
		//@RequestParam List를 추가해서 number333,444 값을 받아오기 위해 만들었다.
		System.out.printf("number :%d\n ", numberMap);
		
		System.out.println("같은 이름으로 전달된 2개의 data");
		int index = 0;
		for(int number : numbers) {
			System.out.printf("nembers[%d] : %d\n" , index, number); //for int ()는 맨 뒤에 : numbers는 @RequestParamList () 명으로
			index +=1;
		}
		
		return "result";
	}


	// test3오류 해결
	@GetMapping("/test4")
	public String test4Get(@RequestParam Map<String,String> map,
						   @RequestParam List<String> numbers) {   // test3가 오류가 남 하나씩 받을 땐 가능 많아서 오류
		String strnum1 = map.get("num1");  // 일단 String으로 받기
	    String strnum2 = map.get("num2");
	    String numberMap = map.get("numbers");
	    
	    int strNum1 = Integer.parseInt(strnum1); // String으로 받은 객체를 Integer.ParseInt로 형변환
	    int strNum2 = Integer.parseInt(strnum2);
	    int number = Integer.parseInt(numberMap);
	
		System.out.printf("strNum1 : %s\n", strNum1); // integer로 받아서 %d\n으로 바꿔야함
		System.out.printf("strNum2 : %s\n", strNum2);
		//@RequestParam List를 추가해서 number333,444 값을 받아오기 위해 만들었다.
		System.out.printf("numbers :%s\n ", number);
		
		System.out.println("같은 이름으로 전달된 2개의 data");
		int index = 0;
		for(String strNumber : numbers) {
			System.out.printf("nembers[%s] : %s\n" , index, strNumber); //for int ()는 맨 뒤에 : numbers는 @RequestParamList () 명으로
			index +=1;
		}
		
		return "result";
	}
	
	// BeansData 클래스 만든 후 객체 만들고(index데이터 보낼 때 ()하고 beans클래스()와 같아야 한다.  Get,set 한 후 
	// 여러개의 클래스 사용 할 수 있다.
	@GetMapping("/test5")
	public String test5Get(@ModelAttribute BeansData bean1,
						   @ModelAttribute BeansData bean2,
						   @ModelAttribute BeansData bean3) {
		System.out.println("== BenasData ==");		
		System.out.printf("bean1.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean1.num2 : %d\n", bean1.getNum2());
		
		// number는 배열로 받기
		int index = 0;
		for(int number : bean1.getNumbers()) {
			System.out.printf("bean1.number[%d] : %d\n",index, number);
			index += 1;
		}
		
		
		System.out.println("== BenasData2 ==");		
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		
		// number는 배열로 받기
		index = 0;
		for(int number : bean1.getNumbers()) {
			System.out.printf("bean2.number[%d] : %d\n",index, number);
			index += 1;
		}
		
		System.out.println("== BenasData3 ==");		
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		
		// number는 배열로 받기
		index = 0;
		for(int number : bean1.getNumbers()) {
			System.out.printf("bean3.number[%d] : %d\n",index, number);
			index += 1;
		}
		
			
		return "result";
	}
	
	
	@GetMapping("/test6")
	public String test6Get( BeansData bean1, //@ModelAttribute 를 생략했다.
						    BeansData bean2,
						    BeansData bean3) {
		System.out.println("== BenasData ==");		
		System.out.printf("bean1.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean1.num2 : %d\n", bean1.getNum2());
		
		// number는 배열로 받기
		int index = 0;
		for(int number : bean1.getNumbers()) {
			System.out.printf("bean1.number[%d] : %d\n",index, number);
			index += 1;
		}
		
		
		System.out.println("== BenasData2 ==");		
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		
		// number는 배열로 받기
		index = 0;
		for(int number : bean1.getNumbers()) {
			System.out.printf("bean2.number[%d] : %d\n",index, number);
			index += 1;
		}
		
		System.out.println("== BenasData3 ==");		
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		
		// number는 배열로 받기
		index = 0;
		for(int number : bean1.getNumbers()) {
			System.out.printf("bean3.number[%d] : %d\n",index, number);
			index += 1;
		}
		
			
		return "result";
	}
	
	
	
	
	
}
