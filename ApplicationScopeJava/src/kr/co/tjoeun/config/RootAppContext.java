package kr.co.tjoeun.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

// 상속이 없다 : project 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {
	
	@Autowired
	TestBean1 applicationBean1;
	
	@Resource(name="applicationBean2")
	TestBean2 applicationBean2;

	//by Type
	@Bean
	@ApplicationScope
	public TestBean1 applicationBean1() {
		return new TestBean1();
	}

	//by Name
	@Bean("applicationBean2")
	@ApplicationScope
	public TestBean2 applicationBean2() {
		return new TestBean2();
	}





}
