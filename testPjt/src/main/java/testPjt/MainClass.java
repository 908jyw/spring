package testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		// 클래스를 만들어 놓고, new 라는 키워드를 이용해서 생성자를 호출하여, 메모리에 동적으로 로드하여 사
		//TransportationWalk transportationWalk = new TransportationWalk();
		//transportationWalk.move();
		
		
		
		// 스프링에서는	 컨테이너를 이용하여 이미 메모리에 로드된 빈(객체)을 사용 -> 컨테이너 역할을 하는 applicationContext.xml(스프링 설정 파일)
		// 컨테이너를 가져온것
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 컨테이너에 있는 빈을 가져옴
		TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class);
		transportationWalk.move();
		
		ctx.close();
		
	}

}
