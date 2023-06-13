package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.BeanData;
import kr.co.tjoeun.beans.BeanKeyValue;

@Controller
public class TestController {

	//data1
	@GetMapping("/test1")
	public String test1(BeanData bean, Model model) {
		bean.setData1("더조은학원"); //여기와 일치하는 항목이 페이지 처음 나올 때 선택됨
		bean.setData2("자바웹개발과정"); //여기와 일치하는 항목이 페이지 처음 나올 때 선택됨
		bean.setData3("풀스택개발자과정");//여기와 일치하는 항목이 페이지 처음 나올 때 선택됨
		bean.setData4("Linux");
		
		//jsp에서 data6 나오는 컨트롤러
		String[] checkList = {"C언어과정", "Spring과정"}; // 배열 생성, 체크될 문자열
		bean.setData5(checkList);
		bean.setData6(checkList);
		bean.setData7(checkList);
		bean.setData8(checkList);
		
		// data2
		String[] dataArray1 = {"데이터분석과정", "풀스택개발자과정", "자바웹개발과정"};
		model.addAttribute("dataArray1", dataArray1);
		
		// data6
		String[] dataArray2 = {"데이터분석과정", "풀스택개발자과정","Spring과정", "자바웹개발과정"};
		model.addAttribute("dataArray2", dataArray2);
		
		// data7
		ArrayList<String> dataList3= new ArrayList<String>();
		dataList3.add("데이터분석과정");
		dataList3.add("풀스택개발자과정");
		dataList3.add("자바웹개발과정");
		dataList3.add("C언어과정");
		model.addAttribute("dataList3", dataList3);  // ("")안에는 jsp에서 받을 때 일치할 것 , 뒤에는 ArrayList<Stirng>여기부분과 일치
		
		
		
		
		// data3
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석과정");
		dataList1.add("풀스택개발자과정");
		dataList1.add("자바웹개발과정");
		model.addAttribute("dataList1", dataList1);  // ("")안에는 jsp에서 받을 때 일치할 것 , 뒤에는 ArrayList<Stirng> 여기부분과 일치
		
		// data4
		BeanKeyValue key_bean1 = new BeanKeyValue();
		BeanKeyValue key_bean2 = new BeanKeyValue();
		BeanKeyValue key_bean3 = new BeanKeyValue();
		BeanKeyValue key_bean4 = new BeanKeyValue();
		
		key_bean1.setKey("item1");
		key_bean1.setValue("Java");
		key_bean2.setKey("item2");
		key_bean2.setValue("Python");
		key_bean3.setKey("item3");
		key_bean3.setValue("Linux");

		
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<BeanKeyValue>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		
		model.addAttribute("dataList2",dataList2);
		
		// data8
		ArrayList<BeanKeyValue> dataList4 = new ArrayList<BeanKeyValue>();
		dataList4.add(key_bean1);
		dataList4.add(key_bean2);
		dataList4.add(key_bean3);
		dataList4.add(key_bean4);
		
		key_bean1.setKey("item1");
		key_bean1.setValue("Java");
		key_bean2.setKey("item2");
		key_bean2.setValue("Python");
		key_bean3.setKey("item3");
		key_bean3.setValue("Linux");
		key_bean4.setKey("item4");
		key_bean4.setValue("Spring과정");
		
		model.addAttribute("dataList4",dataList4);

		
		bean.setData9("자바웹개발과정");
		bean.setData10("자바웹개발과정");
		bean.setData11("자바웹개발과정");
		bean.setData12("자바웹개발과정");
		
		//data10, 배열로
		String[] dataArray3 = {"데이터분석과정", "풀스택개발자과정", "자바웹개발과정"};
		model.addAttribute("dataArray3", dataArray3);
		
		//data11, List
		ArrayList<String> dataList5 = new ArrayList<String>();
		dataList1.add("데이터분석과정");
		dataList1.add("풀스택개발자과정");
		dataList1.add("자바웹개발과정");
		model.addAttribute("dataList5", dataList5);
		
		//data12, 새로운 객체 생성 itemLabel(Key), value(value) 설정해야한다.
		ArrayList<BeanKeyValue> dataList6 = new ArrayList<BeanKeyValue>();
		dataList6.add(key_bean1);
		dataList6.add(key_bean2);
		dataList6.add(key_bean3);
		dataList6.add(key_bean4);
		model.addAttribute("dataList6",dataList6);
		
		
		
		
		
		
		return "test1";
	}
	
	
	
}
