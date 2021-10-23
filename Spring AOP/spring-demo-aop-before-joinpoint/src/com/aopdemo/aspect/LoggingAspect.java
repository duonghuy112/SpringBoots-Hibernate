package com.aopdemo.aspect;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.bean.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	@Before("com.aopdemo.aspect.Luv2CodeAspect.forDAONoGetterSetter()")
	public void BeforeAccountAdvide(JoinPoint joinPoint) {
		System.out.println(" Executing @Before Advide");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " +methodSignature);
		
		Arrays.stream(joinPoint.getArgs()).map(o -> (Account) o).collect(Collectors.toList()).forEach(System.out::println);
	}
}
