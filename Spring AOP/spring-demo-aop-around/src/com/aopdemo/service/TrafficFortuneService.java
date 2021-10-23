package com.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "traffic";
	}
	
	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("EXP");
		}
		return "traffic";
	}
}
