package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;
import chap07.ImpeCalculator;

public class MainXmlPojo {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx 
		    = new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
		//Calculator impeCal = ctx.getBean("impeCal", Calculator.class);
		// Bean named 'impeCal' is expected to be of type 'chap07.ImpeCalculator' 
		// but was actually of type 'jdk.proxy2.$Proxy3' <- 스프링 런타임에 생성한 프록시 객체의 클래스 이름 Calculator 인터페이스를 상속 받음
		Calculator impeCal = ctx.getBean("impeCal", ImpeCalculator.class);
	    long fiveFact1 = impeCal.factorial(5); //impeCal 프록시 객체
	    System.out.println("impeCal.factorial(5) = " + fiveFact1);
	    
	    Calculator recCal = ctx.getBean("recCal", Calculator.class);
	    long fiveFact2 = recCal.factorial(5); //recCal 프록시 객체
	    System.out.println("recCal.factorial(5) = " + fiveFact2);
	}

}
