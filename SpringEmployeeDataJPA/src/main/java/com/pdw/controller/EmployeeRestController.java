package com.pdw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pdw.service.EmployeeService;
import com.pdw.entity.*;

@RestController
@RequestMapping("/bank")
@CrossOrigin("http://localhost:2222")
public class EmployeeRestController {
			    @Autowired
			    EmployeeService employeeService;

			    @GetMapping("/findEmployeeById/{eid}")
			    public Employee findEmployeeById(@PathVariable("eid") int id) {
			        Employee employee = employeeService.findEmployeeById(id);
			        if (employee == null) {
			        System.out.println("employee not found for id=" + id);
			        }
			         return employeeService.findEmployeeById(id);
			    }


			   @PostMapping("/createEmployee")
			    public String createEmployee(@RequestBody Employee employee) {
			    employeeService.createEmployee(employee);
			    	 return "employee created with id : "+employee.getEid();
			     }
			       
			   
			   @PutMapping("/updateEmployee")
			   public String updateEmployee(@RequestBody Employee employee) {
			       employeeService.updateEmployee(employee);
			       return "Employee has been updated";
			   }
			    
			   @DeleteMapping("/deleteEmployee/{id}")
			   public String deleteEmployee(@PathVariable("id") int id) {
			       employeeService.deleteEmployee(id);
				return "Deleted";}
			       
			   @GetMapping("/findAllEmployees")
			   public List<Employee>findAllEmployees(){
				   List<Employee>employees=employeeService.findAllEmployees();
				   return employees;
				   
			   }
			   
			   @GetMapping("/Greaterthan100")
			  public List<Employee>GreaterThan100() {
				   List<Employee>employees=employeeService.GreaterThan100();
				   return employees;  
			   }
			   
			   @GetMapping("/findByename")
			   public List<Employee>findByename(@PathVariable("ename")String name){
				   List<Employee>employee=employeeService.findByename(name);
				   return employee;
				   
			   }
			      
		}

