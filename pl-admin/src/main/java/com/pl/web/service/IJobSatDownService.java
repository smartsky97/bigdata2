package com.pl.web.service;

import com.pl.web.model.JobSatDown;

import java.util.List;

/**
 * 员工工作饱和度(减法)Service接口层.
 * @author root
 *
 */
public interface IJobSatDownService {
	
/*................A方法计算结果展示(8:30-17:30)...................*/	
	/*
	 * 条件查询总记录数用于分页
	 */
	int getJobDetails1Size(String department, String mailname, String startime, String endtime);
	/*
	 *总记录数，用于分页 
	 */
	int getSatDownSize();
	/*
	 * 员工饱和度列表
	 */
	List<JobSatDown> list(int fromIndex, int pageSize);

	/*
	 * 通过没名字,开始日期,结束日期 查询详细信息.用于画像
	 */
	List<JobSatDown> getJobDetails(String mailname, String startime, String endtime);
	/*
	 * 通过没名字,开始日期,结束日期 查询详细信息.用于条件查询分页
	 */
	List<JobSatDown> getJobDetails1(String department, String mailname, String startime, String endtime, int fromIndex, int pageSize);
	/*
	 * 查询数据导出Excel
	 */
	List<JobSatDown> getJobDownCSV(String department, String mailname, String startime, String endtime);
/*................B方法计算结果展示(全天)..........................*/
	
	/*
	 * 条件查询总记录数用于分页
	 */
	int getJobDetails1Size_B(String department, String mailname, String startime, String endtime);
	/*
	 *总记录数，用于分页 
	 */
	int getSatDownSize_B();
	/*
	 * 员工饱和度列表
	 */
	List<JobSatDown> list_B(int fromIndex, int pageSize);

	/*
	 * 通过没名字,开始日期,结束日期 查询详细信息.用于画像
	 */
	List<JobSatDown> getJobDetails_B(String mailname, String startime, String endtime);
	/*
	 * 通过没名字,开始日期,结束日期 查询详细信息.用于条件查询分页
	 */
	List<JobSatDown> getJobDetails1_B(String department, String mailname, String startime, String endtime, int fromIndex, int pageSize);
	/*
	 * 查询数据导出Excel
	 */
	List<JobSatDown> getJobDown_BCSV(String department, String mailname, String startime, String endtime);

}
