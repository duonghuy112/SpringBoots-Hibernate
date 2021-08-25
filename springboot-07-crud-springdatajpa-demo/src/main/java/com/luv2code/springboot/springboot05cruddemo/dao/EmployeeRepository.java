package com.luv2code.springboot.springboot05cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.springboot05cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
