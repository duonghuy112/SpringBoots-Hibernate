package com.aopdemo.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(void add*())")
	public void BeforeAccountAdvide() {
		System.out.println(" Executing @Before Advide");
	}
}
