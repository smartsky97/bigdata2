package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.WifiData;
import org.apache.ibatis.annotations.Param;


public interface WifiDataDao {
	
	/*
	 * wifi定位数据多条件查询(视图展示)
	 */
	public List<WifiData> searchWifiDataShow(@Param("macCode") String macCode, @Param("positionName") String positionName, @Param("userName") String userName, @Param("cnName") String cnName, @Param("startTime") String startTime, @Param("endTime") String endTime);
	/*
	 * 查询列表
	 */
	public List<WifiData> findAll(@Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 查询总记录数,用于分页
	 */
	public int getWifiDataSize();
	/*
	 * 条件查询总记录数,用于分页
	 */
	public int searchWifiDataSize(@Param("macCode") String macCode, @Param("positionName") String positionName, @Param("userName") String userName, @Param("cnName") String cnName, @Param("startTime") String startTime, @Param("endTime") String endTime);
	/*
	 * 带有分页的查询
	 */
	public List<WifiData> searchWifiData(@Param("macCode") String macCode, @Param("positionName") String positionName, @Param("userName") String userName, @Param("cnName") String cnName, @Param("startTime") String startTime, @Param("endTime") String endTime,
                                         @Param("index") int fromIndex, @Param("length") int pageSize);
}
