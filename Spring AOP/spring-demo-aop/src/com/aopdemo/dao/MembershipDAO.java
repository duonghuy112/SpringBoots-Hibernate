package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMembership() {
		System.out.println(getClass() + " - Adding membership");
	}
}
