package com.thuan.java.springboot.jpa.model;

public class EmployeeDepartment {

	private String fullName;

	private Integer age;

	private String deptName;

	public EmployeeDepartment(String fullName, Integer age, String deptName) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.deptName = deptName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
