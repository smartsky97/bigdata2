package com.pl.web.service.impl;

import com.pl.web.dao.JobDataBeansDao;
import com.pl.web.model.JobDataBeansSix;
import com.pl.web.service.JobDataBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDataBeanServiceIMP implements JobDataBeanService {

	@Autowired
	private JobDataBeansDao jobDataBeansDao;

	@Override
	public List<JobDataBeansSix> ChiDaoTimeLength(String department,
												  String mailname, String date) {
		
		return jobDataBeansDao.ChiDaoTimeLength(department, mailname, date);
	}

	@Override
	public List<JobDataBeansSix> FileAppendTimes(String department,
			String mailname, String date) {
		// TODO Auto-generated method stub
		return jobDataBeansDao.FileAppendTimes(department, mailname, date);
	}

	@Override
	public List<JobDataBeansSix> NotWorkRatio(String department,
			String mailname, String date) {
		// TODO Auto-generated method stub
		return jobDataBeansDao.NotWorkRatio(department, mailname, date);
	}

	@Override
	public List<JobDataBeansSix> AverChiDaoTimeLength(String date) {
		// TODO Auto-generated method stub
		return jobDataBeansDao.AverChiDaoTimeLengTh(date);
	}

	@Override
	public List<JobDataBeansSix> AverFileAppendTimes(String date) {
		// TODO Auto-generated method stub
		return jobDataBeansDao.AverFileAppendTimes(date);
	}

	@Override
	public List<JobDataBeansSix> AverNotWorkRatio(String date) {
		// TODO Auto-generated method stub
		return jobDataBeansDao.AverNotWorkRatio(date);
	}
}
