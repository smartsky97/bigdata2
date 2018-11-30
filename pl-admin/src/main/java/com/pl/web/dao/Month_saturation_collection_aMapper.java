package com.pl.web.dao;

import com.pl.web.model.Month_saturation_collection_a;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface Month_saturation_collection_aMapper {
	/**
	 * A方案计算饱和度(8:30-17:30)
	 */
    // 分页查询工作饱和度列表
	public List<Month_saturation_collection_a> findAll();
	
	/*
	 *通过,姓名,开始日期,结束日期,详细查询(Echars展示)
	 */
	public List<Month_saturation_collection_a> getMonthJobDetails(@Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	
	/*
	 * 查询总记录数用于分页
	 */
	public int getMonthAddSize();
	/*
	 * 条件查询总记录数
	 */
	public int getMonthAddSearchDataSize(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);
	/*
	 * 由名字,开始时间,结束时间 查询.用于列表分页查询
	 */
	public List<Month_saturation_collection_a> getMonthAddDatas(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime,
																@Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 查询结果导出CSV文件
	 */
	public List<Month_saturation_collection_a> getMonthJobSatCSV(@Param("department") String department, @Param("mailname") String mailname, @Param("startime") String startime, @Param("endtime") String endtime);

}