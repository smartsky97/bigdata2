package com.pl.web.service;

import com.pl.web.model.Depart_kaoqin;

import java.util.List;



//部门考勤
public interface DeptKaoQinServicce {
	
	public List<Depart_kaoqin> findAll(int fromIndex, int pageSize);
	
	public int getAllDataSize();
	
	public List<Depart_kaoqin> searchDekp(String department, String time, int fromIndex, int pageSize);
	
	public int getSerarchSize(String department, String time);
	//导出到Excel文件.
	public List<Depart_kaoqin> getDepart_kaoqin2CSv(String department, String time);
}
