package com.pdw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdw.dao.EmployeeDao;
import com.pdw.entity.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	EmployeeDao empDao;
	
	@Override
	public String createEmployee(Employee employee) {
		empDao.save(employee);
		return "Employee has been created";
	}
	
	@Override
	public Employee findEmployeeById(int id) {
		return empDao.findOne(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees=empDao.findAll();
		return employees;
	}

	@Override
	public String deleteEmployee(int eid) {
		boolean result=empDao.exists(eid);
		if(result) {
			empDao.delete(eid);
			return "deleted successfully!";
		}
		else
		return "Employee doesn't exists";
	}
	@Override
	public String updateEmployee(Employee employee) {
		boolean result=empDao.exists(employee.getEid());
		if(result) {
			empDao.save(employee);
			return "Employee Updated successfully!";
		}
		else {
			empDao.save(employee);
		return "New employee is inserted";
		}
	}

	@Override
	public List<Employee> GreaterThan100() {
			return empDao.GreaterThan100();
		}

}
