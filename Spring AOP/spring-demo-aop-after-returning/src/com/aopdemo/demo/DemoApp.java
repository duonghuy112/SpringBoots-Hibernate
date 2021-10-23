package com.aopdemo.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.config.DemoConfig;
import com.aopdemo.dao.AccountDAO;

public class DemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		accountDAO.find().forEach(System.out::println);
		
		context.close();
	}
}
