package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PerfomAnalysAspect {

	@Before("com.aopdemo.aspect.Luv2CodeAspect.forDAONoGetterSetter()")
	public void BeforeAccountAdvide() {
		System.out.println(" Executing @Before Advide on Perform");
	}
}
