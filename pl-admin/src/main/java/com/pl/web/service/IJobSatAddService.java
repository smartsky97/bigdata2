package com.pl.web.service;


import com.pl.web.model.JobSatAdd;

import java.util.List;
/**
 * 员工工作饱和度(加法)Service接口层
 * @author root
 *
 */
public interface IJobSatAddService {

/*................A方法计算结果展示(8:30-17:30)...................*/
	/*
	 * 条件查询的总记录数
	 */
	public int getJobDetails1Size(String department, String mailname, String startime, String endtime);
	/*
	 * 获取总记录数，用于分页
	 */
	public int getSatAddSize();
	/*
	 * 分页查询员工饱和
	 */
	public List<JobSatAdd> list(JobSatAdd jobSatAdd);
	/*
	 * 由名字,开始时间,结束时间 查询.用于Echars展示
	 */
	public List<JobSatAdd> getJobDetails(String mailname, String startime, String endtime);
	/*
	 * 由名字,开始时间,结束时间 查询.用于列表分页 
	 */
	public List<JobSatAdd> getJobDetails1(String department, String mailname, String startime, String endtime, int fromIndex, int pageSize);
	/*
	 * 查询结果导出CSV文件
	 */
	public List<JobSatAdd> getJobSatCSV(String department, String mailname, String startime, String endtime);
	
/*-----------------------------------------------------------------------------------------*/
/*................B方法计算结果展示(全天)..........................*/
	/*
	 * 条件查询的总记录数
	 */
	public int getJobDetails1Size_B(String department, String mailname, String startime, String endtime);
	/*
	 * 获取总记录数，用于分页
	 */
	public int getSatAddSize_B();
	/*
	 * 分页查询员工饱和
	 */
	public List<JobSatAdd> list_B(int fromIndex, int pageSize);
	/*
	 * 由名字,开始时间,结束时间 查询.用于Echars展示
	 */
	public List<JobSatAdd> getJobDetails_B(String mailname, String startime, String endtime);
	/*
	 * 由名字,开始时间,结束时间 查询.用于列表分页 
	 */
	public List<JobSatAdd> getJobDetails1_B(String department, String mailname, String startime, String endtime, int fromIndex, int pageSize);
	
	/*
	 * 查询结果导出CSV文件
	 */
	public List<JobSatAdd> getJobSat_BCSV(String department, String mailname, String startime, String endtime);
}