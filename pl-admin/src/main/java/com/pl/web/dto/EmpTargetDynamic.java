package com.pl.web.dto;

/**
 * 用户画像结果类
 * 
 * @author root
 *
 */
public class EmpTargetDynamic {

	// 动态指标数据
	// 指标id
	private String tagId;
	// 指标中文名
	private String tagName;
	// 指标父id
	private String tagPid;
	// 父指标中文名
	private String parentTagName;

	// 指标值
	private String tagValue;
	// 单位
	private String units;
	// 计算时间
	private String computeDate;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getParentTagName() {
		return parentTagName;
	}

	public void setParentTagName(String parentTagName) {
		this.parentTagName = parentTagName;
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

	public String getTagPid() {
		return tagPid;
	}

	public void setTagPid(String tagPid) {
		this.tagPid = tagPid;
	}

	@Override
	public String toString() {
		return "EmpTargetDynamic [tagId=" + tagId + ", tagName=" + tagName + ", tagPid=" + tagPid + ", parentTagName="
				+ parentTagName + ", tagValue=" + tagValue + ", units=" + units + ", computeDate=" + computeDate + "]";
	}

	

	
}
