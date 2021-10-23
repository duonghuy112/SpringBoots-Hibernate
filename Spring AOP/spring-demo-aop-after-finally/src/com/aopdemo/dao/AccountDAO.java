package com.aopdemo.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aopdemo.bean.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println("AcountDAO - " +account);
		System.out.println(getClass() + " - Adding account");
	}
	
	public List<Account> find() {
		List<Account> list = Arrays.asList(new Account(1, "huy123"), new Account(2, "ngankhung"), new Account(3, "quyenphan"));
		/*
		 * if (list != null) { throw new RuntimeException("EXP"); }
		 */
		return list;
	}
}
