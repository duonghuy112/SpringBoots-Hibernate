package com.aopdemo.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.config.DemoConfig;
import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class DemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		accountDAO.addAccount();
		System.out.println(accountDAO.getName());
		System.out.println(accountDAO.getPassword());
		
		
		membershipDAO.addMembership();
		membershipDAO.getId();
		membershipDAO.getSale();
		
		context.close();
	}
}
