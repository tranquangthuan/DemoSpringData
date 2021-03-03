package com.thuan.java.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuan.java.springboot.jpa.entity.Employee;
import com.thuan.java.springboot.jpa.model.EmployeeDepartment;
import com.thuan.java.springboot.jpa.model.EmployeeFullName;
import com.thuan.java.springboot.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee insert(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}

	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}

	public List<Employee> findByAge(int age) {
		return employeeRepository.findByAge(age);
	}

	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Object[]> getEmpFullName() {
		List<Object[]> list = employeeRepository.getEmpFullName();

		return list;
	}

	public List<EmployeeFullName> getEmpFullNameModel() {
		List<EmployeeFullName> list = employeeRepository.getEmpFullNameModel();

		return list;
	}
	
	public List<EmployeeDepartment> getEmpFullDeptMent() {
		return employeeRepository.getEmpFullDepartment();
	}

}
