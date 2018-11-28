package com.pl.web.model;

public class Employee {
    private String mail_name;
    private String cn_name;
    private String department_id;
    private String department;
    
	public Employee() {}
	public Employee(String mail_name, String cn_name, String department_id, String department) {
		this.mail_name = mail_name;
		this.cn_name = cn_name;
		this.department_id = department_id;
		this.department = department;
	}
	public String getMail_name() {
		return mail_name;
	}
	public void setMail_name(String mail_name) {
		this.mail_name = mail_name;
	}
	public String getCn_name() {
		return cn_name;
	}
	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [mail_name=" + mail_name + ", cn_name=" + cn_name + ", department_id=" + department_id
				+ ", department=" + department + "]";
	}
    
}
