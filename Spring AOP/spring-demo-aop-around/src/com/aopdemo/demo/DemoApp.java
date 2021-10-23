package com.aopdemo.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.config.DemoConfig;
import com.aopdemo.service.TrafficFortuneService;

public class DemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main");
		System.out.println("In main : " + trafficFortuneService.getFortune(true));
		System.out.println("Done");
		
		context.close();
	}

}
