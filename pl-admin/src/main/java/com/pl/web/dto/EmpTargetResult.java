package com.pl.web.dto;
/**
 * 最终指标展现数据
 * @author root
 *
 */
public class EmpTargetResult {
	//静态数据
	private EmpBasicInfo empBasicInfo;
	//动态指标数据
	private EmpTargetDynamic empTargetDynamic;
	
	public EmpBasicInfo getEmpBasicInfo() {
		return empBasicInfo;
	}
	
	public void setEmpBasicInfo(EmpBasicInfo empBasicInfo) {
		this.empBasicInfo = empBasicInfo;
	}
	
	public EmpTargetDynamic getEmpTargetDynamic() {
		return empTargetDynamic;
	}
	
	public void setEmpTargetDynamic(EmpTargetDynamic empTargetDynamic) {
		this.empTargetDynamic = empTargetDynamic;
	}
	
	
}
