package com.pl.web.dao;

import com.pl.web.model.DateTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DateTimeDao {
	/*
	 * 查询
	 */
	public List<DateTime> searchDateTimes(@Param("date") String date, @Param("descb") String descb, @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 添加
	 */
	public int AddDateTime(DateTime dateTime);
	/*
	 * 更新
	 */
	public int UpdateDateTime(DateTime dateTime);
	/*
	 * 删除
	 */
	public int DeleteDateTime(int id);
	/*
	 * 分页显示
	 */
	public List<DateTime> findAll(DateTime dateTime);
	
	/*
	 * 查询总记录数,用于分页
	 */
	public int getAllDataSize();
	/*
	 * 通过Id查询
	 */
	public DateTime getDateTimeById(int id);
	
	/*
	 * 条件查询结果总数(用于分页)
	 */
	public int getSearchDataSize(@Param("date") String date, @Param("descb") String descb);
}

