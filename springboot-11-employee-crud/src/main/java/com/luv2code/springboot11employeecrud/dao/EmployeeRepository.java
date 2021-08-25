package com.luv2code.springboot11employeecrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luv2code.springboot11employeecrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findAllByOrderByLastName();
	
	@Query("from Employee where firstName like %?1% or lastName like %?2%")
	List<Employee> findAllByName(String firstName, String lastName);
}
