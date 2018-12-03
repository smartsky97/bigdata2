package com.pl.web.dao;

import com.pl.web.model.WifiPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * Wifi数据采集设备mac和物理位置对应表管理
 */
public interface WifiPostionMapper {
	/*
	 * 查询列表
	 */
	public List<WifiPosition> findAll(WifiPosition wifiPosition);
	/*
	 * 删除
	 */
	public int deleteWifiPostion(int id);
	/*
	 * 添加
	 */
	public int addWifiPostion(WifiPosition wifiPostion);
	/*
	 * 更新
	 */
	public int updateWifiPostion(WifiPosition wifiPostion);
	/*
	 * 通过Id查询
	 */
	public WifiPosition getWifiPostionById(int id);
	/*
	 * 搜索查询
	 */
	public List<WifiPosition> searchWifiPostion(@Param("number") String number, @Param("place") String place, @Param("mac") String mac, @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 查询总记录数,用于分页
	 */
	public int getDataSize();
	/*
	 * 查询总记录数,用于分页
	 */
	public int searchDataSize(@Param("number") String number, @Param("place") String place, @Param("mac") String mac);
}