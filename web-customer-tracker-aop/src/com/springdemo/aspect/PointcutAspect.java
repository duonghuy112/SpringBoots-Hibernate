package com.springdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutAspect {

	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
	}
	
	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	public void forServicePackage() {
	}
	
	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFolw() {
	}
}
