package com.pdw.service;

import java.util.List;
import java.util.Optional;

import com.pdw.entity.Employee;


public interface EmployeeServiceInterface {

	   Employee findEmployeeById(int id);

	    String createEmployee(Employee employee);
	    List<Employee> findAllEmployees();
	    String deleteEmployee(int id);
	    List<Employee> findByename(String ename);
List<Employee>GreaterThan100();
	    String updateEmployee(Employee employee);

	
	
}
