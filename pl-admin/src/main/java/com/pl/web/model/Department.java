package com.pl.web.model;

import java.util.List;

public class Department {
    private String id;
    private String department;
    private Long userid;
    private List<Employee> employeeList;
    public Department(){}
	public Department(String id, String department) {
		this.id = id;
		this.department = department;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + "]";
	}
    
}
