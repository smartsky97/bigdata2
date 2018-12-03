package com.pl.web.service;

import com.pl.web.model.DateTime;

import java.util.List;

/*
 * 日期管理类
 */
public interface DateTimeService {

	public boolean AddDateTime(DateTime dateTime);
	
	public boolean DeleteDateTime(int id);
	
	public boolean UpdateDateTime(DateTime dateTime);
	
	public DateTime getDateTimeByID(int id);
	
	public List<DateTime> listDateTimes(String date, String descb, int fromIndex, int pageSize);
	
	public int getAllDataSize();
	
	public int getSearchDataSize(String date, String descb);
	
	public List<DateTime> dataList(DateTime dateTime);
}
