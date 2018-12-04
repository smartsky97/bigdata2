package com.pl.web.service;

import com.pl.web.model.WifiData;

import java.util.List;


/**
 * WIFI数据展示Service
 * @author lh
 *
 */
public interface WifiDataService {
	
	/*
	 * WIFI数据查询(用于展示)
	 */
	public List<WifiData> searchWifiDataShow(String macCode, String positionName, String userName, String cnName, String startTime, String endTime);

	/*
	 * 查询总记录数,用于分页
	 */
	public int getWifiDataSize();
	
	/*
	 * 分页查询
	 */
	List<WifiData> list(int fromIndex, int pageSize);
	
	/*
	 * 查询结果的记录数(用于分页显示)
	 */
	public int searchWifiDataSize(String macCode, String positionName, String userName, String cnName, String startTime, String endTime);
	/*
	 * 带有分页的查询
	 */
	public List<WifiData> searchWifiData(String macCode, String positionName, String userName, String cnName, String startTime, String endTime,Long userid);
}
