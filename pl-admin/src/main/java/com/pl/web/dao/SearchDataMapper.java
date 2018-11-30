package com.pl.web.dao;

import com.pl.web.model.JobTime;
import com.pl.web.model.SerachData;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SearchDataMapper {

	int getSerachDataSize();

	List<SerachData> list();

	List<JobTime> sumte(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
