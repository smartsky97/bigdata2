package com.pl.web.dto;
/**
 * 单个用户标签的集合
 * @author root
 *
 */
public class EmpLabelResult {
	//用户名
	private String userName;
	//部门名
	private String departmentName;
	//标签名
	private String labelName;
	//计算日期
	private String computeDate;
	

	@Override
	public String toString() {
		return "EmpLabelResult [userName=" + userName + ", departmentName=" + departmentName + ", labelName="
				+ labelName + ", computeDate=" + computeDate + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getComputeDate() {
		return computeDate;
	}
	public void setComputeDate(String computeDate) {
		this.computeDate = computeDate;
	}
}
