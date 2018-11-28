package com.pl.web.model;
/**
 * �û���ָ��ֵ��Ӧ��
 * @author root
 *
 */
public class EmpTarget {
	private int id;
	private String mailName;
	private String tagId;
	private String tagValue;
	private String units;
	private String computeDate;
	
	@Override
	public String toString() {
		return "EmpTarget [id=" + id + ", mailName=" + mailName + ", tagId=" + tagId + ", tagValue=" + tagValue
				+ ", units=" + units + ", computeDate=" + computeDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMailName() {
		return mailName;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getTagValue() {
		return tagValue;
	}
	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getComputeDate() {
		return computeDate;
	}
	public void setComputeDate(String computeDate) {
		this.computeDate = computeDate;
	}
	
	
	
}
