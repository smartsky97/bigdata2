package com.pl.web.service.impl;

import com.pl.web.dao.IJobSatAddDao;
import com.pl.web.model.JobSatAdd;
import com.pl.web.service.IJobSatAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工工作饱和度(加法)ServiceIMP
 * @author root
 *
 */
@Service
public class JobSatAddServiceIMP implements IJobSatAddService {

	
/*................A方法计算结果展示(8:30-17:30)...................*/	
	/*
	 * 员工饱和度(加法)Dao层注入.
	 */
	@Autowired
	private IJobSatAddDao iJobSatAddDao;
	/*
	 * 员工饱和度列表
	 * 
	 */
	@Override
	public List<JobSatAdd> list(JobSatAdd jobSatAdd) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.findAll(jobSatAdd);
	}

	public List<JobSatAdd> list_b(JobSatAdd jobSatAdd) {
		return  this.iJobSatAddDao.findAll_b(jobSatAdd);
	}
	/*
	 * 查询用户饱和度(名字,开始日期,结束日期)
	 */
	@Override
	public List<JobSatAdd> getJobDetails(String mailname, String startime,
			String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobDetails(mailname, startime, endtime);
	}
	@Override
	public int getSatAddSize() {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getSatAddSize();
	}
	@Override
	public int getJobDetails1Size(String department,String mailname, String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobDetails1Size(department,mailname,startime,endtime);
	}
	@Override
	public List<JobSatAdd> getJobDetails1(String department,String mailname, String startime, String endtime, 
			int fromIndex,int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobDetails1(department,mailname,startime,endtime,fromIndex,pageSize);
	}
	
	@Override
	public List<JobSatAdd> getJobSatCSV(String department, String mailname,
			String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobSatCSV(department, mailname, startime, endtime);
	}

/*................B方法计算结果展示(全天)..........................*/
	
	@Override
	public int getJobDetails1Size_B(String department, String mailname,
			String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobDetails1Size_B(department, mailname, startime, endtime);
	}
	@Override
	public int getSatAddSize_B() {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getSatAddSize_B();
	}
	@Override
	public List<JobSatAdd> list_B(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.findAll_B(fromIndex, pageSize);
	}
	@Override
	public List<JobSatAdd> getJobDetails_B(String mailname, String startime,
			String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobDetails_B(mailname, startime, endtime);
	}
	@Override
	public List<JobSatAdd> getJobDetails1_B(String department, String mailname,
			String startime, String endtime, int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.getJobDetails1_B(department, mailname, startime, endtime, fromIndex, pageSize);
	}
	@Override
	public List<JobSatAdd> getJobSat_BCSV(String department, String mailname,
			String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.iJobSatAddDao.geJobSatAdd_B2CSV(department, mailname, startime, endtime);
	}
	
	
}
