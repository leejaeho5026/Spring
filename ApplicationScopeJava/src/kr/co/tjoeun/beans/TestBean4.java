package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

//RootAppContext에서 설정 안 하고 여기서 직접 바로설정
//byName => value=""로 설정 @Bean (name="")이랑 같은 역활
// 직접 할 경우에 servletAppContext에 scan으로 지정해야한다. 설정해야한다.
@Component(value="applicationBean4")
@ApplicationScope
public class TestBean4 {

	private String data7;
	private String data8;
	
	public String getData7() {
		return data7;
	}
	public void setData7(String data7) {
		this.data7 = data7;
	}
	public String getData8() {
		return data8;
	}
	public void setData8(String data8) {
		this.data8 = data8;
	}
	

	
}
