package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.JobDataBeansSix;
import org.apache.ibatis.annotations.Param;


/**
 * 集团数据Bean类(迟到,早退,...)
 * @author root
 *
 */
public interface JobDataBeansDao {
	
	
	//1迟到时长
	public List<JobDataBeansSix> ChiDaoTimeLength(@Param("department") String department, @Param("mailname") String mailname, @Param("date") String date);

	public List<JobDataBeansSix> FileAppendTimes(@Param("department") String department, @Param("mailname") String mailname, @Param("date") String date);
	//16非工作占比
	public List<JobDataBeansSix> NotWorkRatio(@Param("department") String department, @Param("mailname") String mailname, @Param("date") String date);
	//17闲置时间占比(1-(饱和度+非工作占比))
	//18饱和度
	
	//数据指标平均值
	
	//1迟到时长
	public List<JobDataBeansSix> AverChiDaoTimeLengTh(@Param("date") String date);
	
	public List<JobDataBeansSix> AverFileAppendTimes(@Param("date") String date);
	//16非工作占比
	public List<JobDataBeansSix> AverNotWorkRatio(@Param("date") String date);
	//17闲置时间占比(1-(饱和度+非工作占比))
	//18饱和度
}
