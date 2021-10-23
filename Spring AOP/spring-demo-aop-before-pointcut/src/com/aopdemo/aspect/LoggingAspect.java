package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	public void doForDAO() {
	}
	
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	public void set() {
	}
	
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	public void get() {
	}
	
	@Pointcut("doForDAO() && !(set() || get())")
	public void forDAONoGetterSetter() {
	}
	
	@Before("forDAONoGetterSetter()")
	public void BeforeAccountAdvide() {
		System.out.println(" Executing @Before Advide");
	}
}
