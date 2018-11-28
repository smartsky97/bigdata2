package com.pl.web.dto;

/**
 * 部门审批工作量/效率
 * @author root
 *
 */
public class DeptsApproval {
	
	/*
	 * id
	 */
	private Integer id ;
	/*
	 * 部门
	 */
	private String department;
	/*
	 * 审批次数
	 */
	private Integer approvalTimes;
	/*
	 * 审批效率
	 */
	private Double approvalEfficiency;
	/*
	 * 年/月
	 */
	private String date;
	
	public DeptsApproval(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getApprovalTimes() {
		return approvalTimes;
	}

	public void setApprovalTimes(Integer approvalTimes) {
		this.approvalTimes = approvalTimes;
	}

	public Double getApprovalEfficiency() {
		return approvalEfficiency;
	}

	public void setApprovalEfficiency(Double approvalEfficiency) {
		this.approvalEfficiency = approvalEfficiency;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DeptsApproval [id=" + id + ", department=" + department
				+ ", approvalTimes=" + approvalTimes + ", approvalEfficiency="
				+ approvalEfficiency + ", date=" + date + "]";
	}
	
}
