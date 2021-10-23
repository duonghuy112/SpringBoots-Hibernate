package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Luv2CodeAspect {
	
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	public void doForDAO() {
	}
	
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	public void setter() {
	}
	
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	public void getter() {
	}
	
	@Pointcut("doForDAO() && !(setter() || getter())")
	public void forDAONoGetterSetter() {
	}

	@Pointcut("execution(* com.aopdemo.dao.*.find*(..))")
	public void doFindAccount() {
	}
}
