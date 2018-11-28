package com.pl.web.model;

public class SerachData {
    private Integer id;
    private String employee_account;
    private String employee_name;
    private String job_content;
    private String start_time;
    private String end_time;
    private String kword;
    private String department;
    private int kword_count;  
	public SerachData() {}
	public SerachData(Integer id, String employee_account, String employee_name, String job_content, String start_time,
			String end_time, String department, int kword_count) {
		this.id = id;
		this.employee_account = employee_account;
		this.employee_name = employee_name;
		this.job_content = job_content;
		this.start_time = start_time;
		this.end_time = end_time;
		this.department = department;
		this.kword_count = kword_count;
	}
	
	
	
	public SerachData(Integer id, String employee_account, 
			String employee_name, String job_content, String start_time,
			String end_time, String kword, String department, int kword_count) {
		super();
		this.id = id;
		this.employee_account = employee_account;
		this.employee_name = employee_name;
		this.job_content = job_content;
		this.start_time = start_time;
		this.end_time = end_time;
		this.kword = kword;
		this.department = department;
		this.kword_count = kword_count;
	}
	
	public String getKword() {
		return kword;
	}
	public void setKword(String kword) {
		this.kword = kword;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployee_account() {
		return employee_account;
	}
	public void setEmployee_account(String employee_account) {
		this.employee_account = employee_account;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getJob_content() {
		return job_content;
	}
	public void setJob_content(String job_content) {
		this.job_content = job_content;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getKword_count() {
		return kword_count;
	}
	public void setKword_count(int kword_count) {
		this.kword_count = kword_count;
	}
	@Override
	public String toString() {
		return "SerachData [id=" + id + ", employee_account=" + employee_account + ", employee_name=" + employee_name
				+ ", job_content=" + job_content + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", department=" + department + ", kword_count=" + kword_count + "]";
	}
    
}
