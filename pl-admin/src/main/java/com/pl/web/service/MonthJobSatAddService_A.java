package com.pl.web.service;

import com.pl.web.model.Month_saturation_collection_a;

import java.util.List;


public interface MonthJobSatAddService_A {
	
	/*
	 * 条件查询的总记录数
	 */
	public int getMonthJobDetails1Size(String department, String mailname, String startime, String endtime);
	/*
	 * 获取总记录数，用于分页
	 */
	public int getMonthSatAddSize();
	/*
	 * 分页查询员工饱和
	 */
	public List<Month_saturation_collection_a> Month_list(int fromIndex, int pageSize);
	/*
	 * 由名字,开始时间,结束时间 查询.用于Echars展示
	 */
	public List<Month_saturation_collection_a> getMonthJobDetails(String mailname, String startime, String endtime);
	/*
	 * 由名字,开始时间,结束时间 查询.用于列表分页 
	 */
	public List<Month_saturation_collection_a> getMonthJobDetailSearch(String department, String mailname, String startime, String endtime, int fromIndex, int pageSize);
	/*
	 * 查询结果导出CSV文件
	 */
	public List<Month_saturation_collection_a> getMonthJobSatCSV(String department, String mailname, String startime, String endtime);
	
}
