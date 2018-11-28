package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.JobSatDown;
import org.apache.ibatis.annotations.Param;

/**
 * 工作饱和度(减法)Dao层接口类
 * @author root
 *
 */
public interface IJobSatDownDao {

/*................A方法计算结果展示(8:30-17:30)...................*/
	/*
	 * 工作饱和度列表(减法).
	 */
	public List<JobSatDown> findAll(@Param("index") int fromIndex, @Param("length") int pageSize);
	
	/*
	 * 通过姓名,开始时间,结束时间,查询饱和度(Echars展示搜索).
	 */
	public List<JobSatDown> getJobDetails(@Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	/*
	 *总记录数，用于分页 
	 */
	public int getSatDownSize();
	/*
	 * 通过名字,开始日期,结束日期 查询详细信息.用于条件查询(分页显示)
	 */
	public List<JobSatDown> getJobDetails1(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime,
                                           @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 条件查询总记录数用于分页
	 */
	public int getJobDetails1Size(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	
	/*
	 * 饱和度减法数据导出Excel
	 */
	public  List<JobSatDown> getJobDownCSV(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);

/*................B方法计算结果展示(全天)..........................*/
	
	/*
	 * 工作饱和度列表(减法)
	 */
	public List<JobSatDown> findAll_B(@Param("index") int fromIndex, @Param("length") int pageSize);
	
	/*
	 * 通过姓名,开始时间,结束时间,查询饱和度(Echars展示搜索)
	 */
	public List<JobSatDown> getJobDetails_B(@Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	/*
	 *总记录数，用于分页 
	 */
	public int getSatDownSize_B();
	/*
	 * 通过名字,开始日期,结束日期 查询详细信息.用于条件查询(分页显示)
	 */
	public List<JobSatDown> getJobDetails1_B(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime,
                                             @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 条件查询总记录数用于分页
	 */
	public int getJobDetails1Size_B(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	
	/*
	 * 饱和度减法数据导出Excel
	 */
	public  List<JobSatDown> getJobDown_BCSV(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);

	
}