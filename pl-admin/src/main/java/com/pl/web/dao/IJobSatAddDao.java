package com.pl.web.dao;

import com.pl.web.model.JobSatAdd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作饱和度(加法)dao层接口类.
 * @author lihao
 *
 */
public interface IJobSatAddDao {
   
	/**
	 * A方案计算饱和度(8:30-17:30)
	 */
    // 分页查询工作饱和度列表
	public List<JobSatAdd> findAll(JobSatAdd jobSatAdd);

	public List<JobSatAdd> findAll_b(JobSatAdd jobSatAdd);

	/*
	 *通过,姓名,开始日期,结束日期,详细查询(Echars展示)
	 */
	public List<JobSatAdd> getJobDetails(@Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	
	/*
	 * 查询总记录数用于分页
	 */
	public int getSatAddSize();
	/*
	 * 条件查询总记录数
	 */
	public int getJobDetails1Size(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	/*
	 * 由名字,开始时间,结束时间 查询.用于列表分页查询
	 */
	public List<JobSatAdd> getJobDetails1(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime,
                                          @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 查询结果导出CSV文件
	 */
	public List<JobSatAdd> getJobSatCSV(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);

/*---------------------------------------------------------------------------------------------*/	
	/**
	 * B方案计算结果展示(全天)
	 */
	
	/*
	 *  分页查询工作饱和度列表
	 */
		public List<JobSatAdd> findAll_B(@Param("index") int fromIndex, @Param("length") int pageSize);
		
		/*
		 *通过,姓名,开始日期,结束日期,详细查询(Echars展示)
		 */
		public List<JobSatAdd> getJobDetails_B(@Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
		
		/*
		 * 查询总记录数用于分页
		 */
		public int getSatAddSize_B();
		/*
		 * 条件查询总记录数
		 */
		public int getJobDetails1Size_B(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
		/*
		 * 由名字,开始时间,结束时间 查询.用于列表分页查询
		 */
		public List<JobSatAdd> getJobDetails1_B(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime,
                                                @Param("index") int fromIndex, @Param("length") int pageSize);
		/*
		 * 查询结果导出Excel文件
		 */
		public List<JobSatAdd> geJobSatAdd_B2CSV(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
}