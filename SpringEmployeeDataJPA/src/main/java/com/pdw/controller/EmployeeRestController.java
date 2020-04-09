package com.pdw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.pdw.service.EmployeeService;
import com.pdw.entity.*;
import com.pdw.exceptions.BasicIdException;

@RestController
@RequestMapping("/bank")
@CrossOrigin("http://localhost:2222")
public class EmployeeRestController {
			    @Autowired
			    EmployeeService employeeService;

			    @RequestMapping(value = "/findEmployeeWithId{id}",method = RequestMethod.GET,headers="Accept=application/json")
				public Employee findEmployeeByIdCounty(@PathVariable int id) throws BasicIdException{
					Employee c =null;
					try {
						c = employeeService.findEmployeeById(id);
						System.out.println("country"+c);
					}catch(Exception e) {
						throw new BasicIdException("No employee with this ID");
					}
					return c;
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
			    
			   @DeleteMapping("/deleteEmployee/{eid}")
			   public String deleteEmployee(@PathVariable("eid") int eid) {
			       employeeService.deleteEmployee(eid);
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
			   
			   // Exception Handling in controller level
			   @ResponseStatus(value=HttpStatus.NOT_FOUND,
					   reason="employee id not found")
			   @ExceptionHandler({Exception.class})
			   public void handleException(){
				   
			   }
			      
		}

