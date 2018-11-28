package com.pl.web.model;
/**
 * 工作量计算结果
 * @author songwb1
 *
 */
public class EmpQualityResult {
	/**
	 * 結果表的id
	 */
	private Integer id;
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
		return "EmpQualityResult [id=" + id + ", mailName=" + mailName + ", qualityResult=" + qualityResult
				+ ", computeDate=" + computeDate + "]";
	}

	public EmpQualityResult() {
		super();
	}
	
	
	
	public EmpQualityResult(String mailName, Double qualityResult, String computeDate) {
		super();
		this.mailName = mailName;
		this.qualityResult = qualityResult;
		this.computeDate = computeDate;
	}

	public EmpQualityResult(Integer id, String mailName, Double qualityResult, String computeDate) {
		super();
		this.id = id;
		this.mailName = mailName;
		this.qualityResult = qualityResult;
		this.computeDate = computeDate;
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
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
