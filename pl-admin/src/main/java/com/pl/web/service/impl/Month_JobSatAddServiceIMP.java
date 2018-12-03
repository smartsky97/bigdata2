package com.pl.web.service.impl;
/**
 * 月度工作饱和度(加法_8:30-17:30)展示
 */

import com.pl.web.dao.Month_saturation_collection_aMapper;
import com.pl.web.model.JobSatAdd;
import com.pl.web.model.Month_saturation_collection_a;
import com.pl.web.service.MonthJobSatAddService_A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Month_JobSatAddServiceIMP implements MonthJobSatAddService_A {
	@Autowired
	private Month_saturation_collection_aMapper month_saturation_collection_aMapper;
	@Override
	public int getMonthJobDetails1Size(String department, String mailname,
			String startime, String endtime) {
		
		return this.month_saturation_collection_aMapper.getMonthAddSearchDataSize
				(department, mailname, startime, endtime);
	}

	@Override
	public int getMonthSatAddSize() {
		// TODO Auto-generated method stub
		return this.month_saturation_collection_aMapper.getMonthAddSize();
	}

	@Override
	public List<Month_saturation_collection_a> Month_list(JobSatAdd jobSatAdd) {
		
		return this.month_saturation_collection_aMapper.findAll(jobSatAdd);
	}

	@Override
	public List<Month_saturation_collection_a> getMonthJobDetails(
			String mailname, String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.month_saturation_collection_aMapper.getMonthJobDetails(mailname, startime, endtime);
	}

	@Override
	public List<Month_saturation_collection_a> getMonthJobDetailSearch(
			String department, String mailname, String startime,
			String endtime, int fromIndex, int pageSize) {
		return this.month_saturation_collection_aMapper.getMonthAddDatas(department, mailname, startime, endtime, fromIndex, pageSize);
	}

	@Override
	public List<Month_saturation_collection_a> getMonthJobSatCSV(
			String department, String mailname, String startime, String endtime) {
		
		return this.month_saturation_collection_aMapper.getMonthJobSatCSV
				(department, mailname, startime, endtime);
	}

}
