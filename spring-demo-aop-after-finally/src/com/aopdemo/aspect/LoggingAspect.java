package com.aopdemo.aspect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterReturning(pointcut = "com.aopdemo.aspect.Luv2CodeAspect.doFindAccount()", 
					returning = "list")
	public void afterReturningFindAccount(JoinPoint joinPoint, List<Account> list) {
		System.out.println("Executing @After Returning");
		System.out.println("method: " + joinPoint.getSignature().toString());
		
		System.out.println("result: " + list);
		
		convertToUpperCase(list);
		System.out.println("result: " + list);
	}
	
	@AfterThrowing(pointcut = "com.aopdemo.aspect.Luv2CodeAspect.doFindAccount()",
					throwing = "exp")
	public void afterThrowingFindAccount(JoinPoint joinPoint, Throwable exp) {
		System.out.println("Executing @After Throwing");
		System.out.println("after throwing" + exp);
	}
	
	@After("com.aopdemo.aspect.Luv2CodeAspect.doFindAccount()")
	public void afterFinallyFindAccount(JoinPoint joinPoint) {
		System.out.println("Executing @After finally " + joinPoint.getSignature().toString());
	}

	private void convertToUpperCase(List<Account> list) {
		for (Account account : list) {
			account.setUsername(account.getUsername().toUpperCase());
		}
	}
}
