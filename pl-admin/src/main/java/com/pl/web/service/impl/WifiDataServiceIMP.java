package com.pl.web.service.impl;

import com.pl.web.dao.WifiDataDao;
import com.pl.web.model.WifiData;
import com.pl.web.service.WifiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WifiDataServiceIMP implements WifiDataService {
	/*
	 * wifi数据service实现层
	 */
	@Autowired
	private WifiDataDao wifiDataDao;
	
	/*
	 * WIFI数据(用于视图展示)
	 * 
	 */
	@Override
	public List<WifiData> searchWifiDataShow(String macCode,
											 String positionName, String userName, String cnName, String startTime,
											 String endTime) {
		return this.wifiDataDao.
				searchWifiDataShow(macCode, positionName, userName,cnName,startTime, endTime);
	}
	
	/*
	 * 数据总记录数
	 */
	@Override
	public int getWifiDataSize() {
		// TODO Auto-generated method stub
		return this.wifiDataDao.getWifiDataSize();
	}
	/*
	 * 分页显示
	 */
	@Override
	public List<WifiData> list(int fromIndex, int pageSize) {
		
		return this.wifiDataDao.findAll(fromIndex, pageSize);
	}
	/*
	 * 查询记录数
	 */
	@Override
	public int searchWifiDataSize(String macCode, String positionName,
			String userName,String cnName,String startTime, String endTime) {
		
		return this.wifiDataDao.searchWifiDataSize(macCode, positionName, userName,cnName,startTime, endTime);
	}
	/*
	 * 查询分页显示
	 */
	@Override
	public List<WifiData> searchWifiData(String macCode, String positionName,
			String userName,String cnName,String startTime, String endTime, int fromIndex,
			int pageSize) {
		
		return this.wifiDataDao.searchWifiData(macCode, positionName, userName,cnName,startTime, endTime, fromIndex, pageSize);
	}

}
