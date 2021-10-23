package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	private int id;
	private String sale;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public void addMembership() {
		System.out.println(getClass() + " - Adding membership");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " - Sleepping membership");
	}
}
