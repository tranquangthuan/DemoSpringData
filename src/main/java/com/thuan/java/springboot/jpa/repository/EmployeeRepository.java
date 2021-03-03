package com.thuan.java.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thuan.java.springboot.jpa.entity.Employee;
import com.thuan.java.springboot.jpa.model.EmployeeDepartment;
import com.thuan.java.springboot.jpa.model.EmployeeFullName;

//@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	List<Employee> findByAge(int age);

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("SELECT e.firstName, e.lastName, e.age FROM Employee e ORDER BY e.age DESC")
	List<Object[]> getEmpFullName();

	@Query("SELECT new com.thuan.java.springboot.jpa.model.EmployeeFullName(CONCAT(e.firstName, ' ', e.lastName), e.age) FROM Employee e ORDER BY e.age DESC")
	List<EmployeeFullName> getEmpFullNameModel();
	
	@Query("SELECT new com.thuan.java.springboot.jpa.model.EmployeeDepartment(CONCAT(e.firstName, ' ', e.lastName), e.age, d.name)"
			+ " FROM Employee e, Department d WHEre e.deptId = d.id "
			+ "ORDER BY e.age DESC")
	List<EmployeeDepartment> getEmpFullDepartment();
}