package com.luv2code.springboot10employeelist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private String firstName;
	private String lastName;
	private String email;
}
