package com.boot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.web.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value = "select*from emp where name=? ", nativeQuery = true)
	List<Employee> findByName(String query);

}
