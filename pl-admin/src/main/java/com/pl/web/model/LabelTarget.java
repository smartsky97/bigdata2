package com.pl.web.model;

/**
 * ��ǩ��ָ���Ӧ��
 * 
 * @author root
 *
 */
public class LabelTarget {
	private int id;
	private int labelId;
	private String tagId;
	private String compareOperation;
	private String targetValue;
	private String unit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getCompareOperation() {
		return compareOperation;
	}
	public void setCompareOperation(String compareOperation) {
		this.compareOperation = compareOperation;
	}
	public String getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "LabelTarget [id=" + id + ", labelId=" + labelId + ", tagId=" + tagId + ", compareOperation="
				+ compareOperation + ", targetValue=" + targetValue + ", unit=" + unit + "]";
	}

	
}
