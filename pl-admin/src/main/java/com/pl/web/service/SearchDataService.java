package com.pl.web.service;

import com.pl.web.model.JobTime;
import com.pl.web.model.SerachData;

import java.util.List;


public interface SearchDataService {
	public int getSerachDataSize();
	public List<SerachData> list();
	public List<JobTime> sum(String startTime, String endTime);
}
