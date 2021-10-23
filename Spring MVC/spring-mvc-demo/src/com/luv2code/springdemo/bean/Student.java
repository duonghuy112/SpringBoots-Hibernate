package com.luv2code.springdemo.bean;

import java.util.Arrays;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private String language;
	private List<String> os;
	
	private List<String> languageOptions;
	
	public Student() {
		languageOptions = Arrays.asList("Java", "C/C++", "C#", "Python", "Ruby", "JavaScript");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getLanguageOptions() {
		return languageOptions;
	}

	public List<String> getOs() {
		return os;
	}

	public void setOs(List<String> os) {
		this.os = os;
	}
}
