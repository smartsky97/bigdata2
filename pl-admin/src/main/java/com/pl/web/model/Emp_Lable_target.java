package com.pl.web.model;
/**
 * 标签计算结果指标管理Bean类
 * @author root
 *
 */
public class Emp_Lable_target {

	private int id;
	
	private int label_id;
	
	private String tag_id;
	
	private String compare_operation;
	
	private String target_value;
	
	private String unit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLabel_id() {
		return label_id;
	}

	public void setLabel_id(int label_id) {
		this.label_id = label_id;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	

	public String getCompare_operation() {
		return compare_operation;
	}

	public void setCompare_operation(String compare_operation) {
		this.compare_operation = compare_operation;
	}

	public String getTarget_value() {
		return target_value;
	}

	public void setTarget_value(String target_value) {
		this.target_value = target_value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
