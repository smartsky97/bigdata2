package com.pl.web.service.impl;

import com.pl.web.dao.IJobSatDownDao;
import com.pl.web.model.JobSatDown;
import com.pl.web.service.IJobSatDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作饱和度(减法)ServiceIMP
 * @author lh
 *
 */
@Service
public class JobSatDownServiceIMP implements IJobSatDownService {

/*................A方法计算结果展示(8:30-17:30)...................*/
	
	/*
	 * Dao层注入
	 */
	@Autowired
	private IJobSatDownDao iJobSatDownDao;
	/*
	 * 工作饱和度列表
	 */
	@Override
	public List<JobSatDown> list(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.findAll(fromIndex,pageSize);
	}
	/*
	 * 查询详细工作饱和度(姓名,开始时间,结束时间)
	 */
	@Override
	public List<JobSatDown> getJobDetails(String mailname, String startime,
			String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDetails(mailname, startime, endtime);
	}
	@Override
	public int getSatDownSize() {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getSatDownSize();
	}
	@Override
	public List<JobSatDown> getJobDetails1(String department,String mailname, String startime, String endtime, int fromIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDetails1(department,mailname,startime,endtime,fromIndex,pageSize);
	}
	@Override
	public int getJobDetails1Size(String department, String mailname, String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDetails1Size(department,mailname,startime,endtime);
	}
	@Override
	public List<JobSatDown> getJobDownCSV(String department, String mailname,
			String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDownCSV(department, mailname, startime, endtime);
	}

/*................B方法计算结果展示(全天)...................*/
	
	@Override
	public int getJobDetails1Size_B(String department, String mailname,
			String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDetails1Size_B(department, mailname, startime, endtime);
	}
	@Override
	public int getSatDownSize_B() {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getSatDownSize_B();
	}
	@Override
	public List<JobSatDown> list_B(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.findAll_B(fromIndex, pageSize);
	}
	@Override
	public List<JobSatDown> getJobDetails_B(String mailname, String startime,
			String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDetails_B(mailname, startime, endtime);
	}
	@Override
	public List<JobSatDown> getJobDetails1_B(String department,
			String mailname, String startime, String endtime, int fromIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDetails1_B(department,
			mailname, startime, endtime, fromIndex, pageSize);
	}
	
	@Override
	public List<JobSatDown> getJobDown_BCSV(String department, String mailname,
			String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatDownDao.getJobDown_BCSV(department, mailname, startime, endtime);
	}

}
