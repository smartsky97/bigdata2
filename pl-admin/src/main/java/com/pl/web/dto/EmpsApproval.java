package com.pl.web.dto;

/**
 * 员工审批工作量/效率
 * @author root
 *
 */
public class EmpsApproval {
	
	/*
	 * id
	 */
	private Integer id;
	
	/*
	 * 中文名称
	 */
	private String cnName;
	/*
	 * 审批次数
	 */
	private Integer approvalTimes;
	/*
	 * 审批效率
	 */
	private Double approvalEfficiency;

	/*
	 * 年/月份
	 */
	private String date;

	public EmpsApproval(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
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
		return "EmpsApproval [id=" + id + ", cnName=" + cnName
				+ ", approvalTimes=" + approvalTimes + ", approvalEfficiency="
				+ approvalEfficiency + ", date=" + date + "]";
	}
	
	
}
