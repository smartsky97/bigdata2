package com.pl.web.service.impl;

import com.pl.web.dao.DateTimeDao;
import com.pl.web.model.DateTime;
import com.pl.web.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 日期管理实现类
 */
@Service
public class DateTimeServiceIMP implements DateTimeService {
	@Autowired
	private DateTimeDao dateTimeDao;

	@Override
	public boolean AddDateTime(DateTime dateTime) {
		int count =this.dateTimeDao.AddDateTime(dateTime);
		if (count>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean DeleteDateTime(int id) {
		int count1 = this.dateTimeDao.DeleteDateTime(id);
		if (count1>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean UpdateDateTime(DateTime dateTime) {
		int count2 =this.dateTimeDao.UpdateDateTime(dateTime);
		if (count2>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public DateTime getDateTimeByID(int id) {
		// TODO Auto-generated method stub
		return this.dateTimeDao.getDateTimeById(id);
	}

	@Override
	public int getAllDataSize() {
		
		return this.dateTimeDao.getAllDataSize();
	}

	@Override
	public List<DateTime> dataList(DateTime dateTime) {
		return this.dateTimeDao.findAll(dateTime);
	}

	@Override
	public List<DateTime> listDateTimes(String date, String descb,
			int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.dateTimeDao.searchDateTimes(date, descb, fromIndex, pageSize);
	}

	@Override
	public int getSearchDataSize(String date, String descb) {
		// TODO Auto-generated method stub
		return this.dateTimeDao.getSearchDataSize(date, descb);
	}

	
	

}
