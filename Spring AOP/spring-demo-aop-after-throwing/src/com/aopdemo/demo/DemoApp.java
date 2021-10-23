package com.aopdemo.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.bean.Account;
import com.aopdemo.config.DemoConfig;
import com.aopdemo.dao.AccountDAO;

public class DemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		try {
			List<Account> list = accountDAO.find();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println("Main - catch exception: " + e);
		}
		
		context.close();
	}

}
