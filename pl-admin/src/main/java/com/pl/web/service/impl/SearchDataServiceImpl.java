package com.pl.web.service.impl;

import com.pl.web.dao.SearchDataMapper;
import com.pl.web.model.JobTime;
import com.pl.web.model.SerachData;
import com.pl.web.service.SearchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchDataServiceImpl implements SearchDataService {
	@Autowired
    private SearchDataMapper searchDataMapper;
	@Override
	public int getSerachDataSize(){
		return searchDataMapper.getSerachDataSize();
	}
	public List<SerachData> list() {
		return searchDataMapper.list();
	}
	
	public List<JobTime> sum(String startTime, String endTime) {
		return searchDataMapper.sumte(startTime,endTime);
	}
}
