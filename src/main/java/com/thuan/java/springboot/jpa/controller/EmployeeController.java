package com.thuan.java.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		boolean status = employeeService.deleteById(id);

		return new ResponseEntity<String>(status ? "Deleted" : "Id not exist", HttpStatus.OK);
	}

	@GetMapping()
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping(value = "page")
	public Page<Employee> findByPage(@RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageable = PageRequest.of(page, 2);
		return employeeService.findByPage(pageable);
	}

	@GetMapping(value = "/age/{age}")
	public List<Employee> findByAge(@PathVariable int age) {
		return employeeService.findByAge(age);
	}

	@GetMapping(value = "/name")
	public List<Employee> findByFirstNameAndLastName(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		return employeeService.findByFirstNameAndLastName(firstName, lastName);
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
