package com.pl.web.dto;

/**
 * 工作量饱和度数据类
 * 
 * @author songwb
 *
 */
public class EmpQualitySaturability {

	/**
	 * 部门id
	 */
	private String deptId;
	/**
	 * 中文名
	 */
	private String chinaName;
	/**
	 * 用户名
	 */
	private String mailName;
	/**
	 * 加法饱和度
	 */
	private String saturabilityAdd;
	/**
	 * 减法饱和度
	 */
	private String saturabilitySub;
	/**
	 * 计算时间
	 */
	private String computeDate;

	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getSaturabilityAdd() {
		return saturabilityAdd;
	}

	public void setSaturabilityAdd(String saturabilityAdd) {
		this.saturabilityAdd = saturabilityAdd;
	}

	public String getSaturabilitySub() {
		return saturabilitySub;
	}

	public void setSaturabilitySub(String saturabilitySub) {
		this.saturabilitySub = saturabilitySub;
	}

	public String getComputeDate() {
		return computeDate;
	}

	public void setComputeDate(String computeDate) {
		this.computeDate = computeDate;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getChinaName() {
		return chinaName;
	}

	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}

	@Override
	public String toString() {
		return "EmpQualitySaturability [deptId=" + deptId + ", chinaName=" + chinaName + ", mailName=" + mailName
				+ ", saturabilityAdd=" + saturabilityAdd + ", saturabilitySub=" + saturabilitySub + ", computeDate="
				+ computeDate + "]";
	}
	
	
}
