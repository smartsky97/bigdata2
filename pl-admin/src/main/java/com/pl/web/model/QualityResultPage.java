package com.pl.web.model;
/**
 * 工作量计算结果
 * @author songwb1
 *
 */
public class QualityResultPage {
	/**
	 * 結果表的id
	 */
	private Integer id;
	
	/**
	 * 中文名
	 */
	private String cnName ;
	
	/**
	 * 中文名
	 */
	private String department ;
	/**
	 * 账户名
	 */
	private String mailName ;
	/**
	 * 工作量计算结果
	 */
	private Double qualityResult;
	/**
	 * 工作量计算时间
	 */
	private String computeDate;
	
	@Override
	public String toString() {
		return "QualityResultPage [id=" + id + ", cnName=" + cnName + ", department=" + department + ", mailName="
				+ mailName + ", qualityResult=" + qualityResult + ", computeDate=" + computeDate + "]";
	}
	public QualityResultPage() {
		super();
	}
	public QualityResultPage(Integer id, String cnName, String department, String mailName, Double qualityResult,
			String computeDate) {
		super();
		this.id = id;
		this.cnName = cnName;
		this.department = department;
		this.mailName = mailName;
		this.qualityResult = qualityResult;
		this.computeDate = computeDate;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMailName() {
		return mailName;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public Double getQualityResult() {
		return qualityResult;
	}
	public void setQualityResult(Double qualityResult) {
		this.qualityResult = qualityResult;
	}
	public String getComputeDate() {
		return computeDate;
	}
	public void setComputeDate(String computeDate) {
		this.computeDate = computeDate;
	}
	
	
}
