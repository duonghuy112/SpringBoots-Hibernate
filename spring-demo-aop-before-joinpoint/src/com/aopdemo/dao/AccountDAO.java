package com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aopdemo.bean.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addAccount(Account account) {
		System.out.println("AcountDAO - " +account);
		System.out.println(getClass() + " - Adding account");
	}
}
