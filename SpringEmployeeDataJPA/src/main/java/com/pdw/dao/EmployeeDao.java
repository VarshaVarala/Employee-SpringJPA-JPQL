package com.pdw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdw.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
	
	@Query("select * from Employee where ename=?1")
	List<Employee>findByename(@Param("c") String name);
	
	@Query("select ename,esal from Employee where esal>100")
	List<Employee>GreaterThan100();

}
