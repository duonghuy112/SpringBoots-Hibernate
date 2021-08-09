package com.springdemo.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Before("com.springdemo.aspect.PointcutAspect.forAppFolw()")
	public void before(JoinPoint joinPoint) {
		logger.info("=>>> in @Before: calling method: " + joinPoint.getSignature().toString());
		
		Object[] arg = joinPoint.getArgs();
		Arrays.stream(arg).forEach(a -> logger.info("=>>> argument: " + a));
	}
	
	@AfterReturning(pointcut = "com.springdemo.aspect.PointcutAspect.forAppFolw()",
					returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("=>>> in @After Returning: calling method: " + joinPoint.getSignature().toString());
		
		logger.info("=>>> result: " + result);
	}
}
