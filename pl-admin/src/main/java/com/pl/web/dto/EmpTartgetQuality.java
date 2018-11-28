package com.pl.web.dto;

/**
 * 员工量相关指标
 * 
 * @author songwb
 *
 */
public class EmpTartgetQuality {
	/**
	 * 部门id
	 */
	private String deptId;
	/**
	 * 用户名
	 */
	private String mailName;
	/**
	 * 中文名
	 */
	private String chinaName;
	/**
	 * 指标拼音
	 */
	private String tagMc;
	
	public String getTagMc() {
		return tagMc;
	}

	public void setTagMc(String tagMc) {
		this.tagMc = tagMc;
	}

	/**
	 * 指标名称
	 */
	private String tagName;
	/**
	 * 指标值
	 */
	private String tagValue;
	/**
	 * 计算时间
	 */
	private String computeDate;
	
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getChinaName() {
		return chinaName;
	}

	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}

	public String getComputeDate() {
		return computeDate;
	}

	public void setComputeDate(String computeDate) {
		this.computeDate = computeDate;
	}

	@Override
	public String toString() {
		return "EmpTartgetQuality [deptId=" + deptId + ", mailName=" + mailName + ", chinaName=" + chinaName
				+ ", tagMc=" + tagMc + ", tagName=" + tagName + ", tagValue=" + tagValue + ", computeDate="
				+ computeDate + "]";
	}
}
