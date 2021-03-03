package com.thuan.java.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuan.java.springboot.jpa.entity.Employee;
import com.thuan.java.springboot.jpa.model.EmployeeDepartment;
import com.thuan.java.springboot.jpa.model.EmployeeFullName;
import com.thuan.java.springboot.jpa.service.EmployeeService;

@RestController
@RequestMapping(value = "/v1/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public Employee insert(@RequestBody Employee employee) {
		return employeeService.insert(employee);
	}

	@DeleteMapping
	public String delete(@RequestBody Employee employee) {
		employeeService.delete(employee);
		return "delete success";
	}

	@DeleteMapping(value = "/{id}")
	public String deleteById(@PathVariable long id) {
		employeeService.deleteById(id);

		return "delete success id = " + id;
	}

	@GetMapping(value = "/age/{age}")
	public List<Employee> findByAge(@PathVariable int age) {
		return employeeService.findByAge(age);
	}

	@GetMapping(value = "/name")
	public List<Employee> findByFirstNameAndLastName(@RequestBody Employee employee) {
		return employeeService.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
	}

	@PutMapping
	public Employee update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}

	@GetMapping(value = "/fullname")
	public List<Object[]> getFullName() {
		return employeeService.getEmpFullName();
	}

	@GetMapping(value = "/fullnamemodel")
	public List<EmployeeFullName> getFullNameModel() {
		return employeeService.getEmpFullNameModel();
	}

	@GetMapping(value = "/dept")
	public List<EmployeeDepartment> getEmpNameAndDept() {
		return employeeService.getEmpFullDeptMent();
	}

}
