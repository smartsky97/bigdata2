package com.pl.web.service;

import com.pl.web.model.JobDataBeansSix;

import java.util.List;


public interface JobDataBeanService {
	
	//1迟到时长
	public List<JobDataBeansSix> ChiDaoTimeLength(String department, String mailname, String date);
	
	public List<JobDataBeansSix> FileAppendTimes(String department, String mailname, String date);
	//16非工作占比
	public List<JobDataBeansSix> NotWorkRatio(String department, String mailname, String date);
	//17闲置时间占比(1-(饱和度+非工作占比))
	//18饱和度
	
	//1迟到时长
		public List<JobDataBeansSix> AverChiDaoTimeLength(String date);
		
		public List<JobDataBeansSix> AverFileAppendTimes(String date);
		//16非工作占比
		public List<JobDataBeansSix> AverNotWorkRatio(String date);
		//17闲置时间占比(1-(饱和度+非工作占比))
		//18饱和度
}
