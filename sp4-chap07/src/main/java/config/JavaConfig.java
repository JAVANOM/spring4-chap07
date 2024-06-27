package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.ExeTimeAspect2;
import chap07.Calculator;
import chap07.RecCalculator;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JavaConfig {
    
	// @Aspect 애노테이션을 적용한 클래스를 빈으로 등록
	@Bean
	public ExeTimeAspect2 exeTimeAspect(){
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator recCal() {
		return new RecCalculator();
	}
	
	
}
