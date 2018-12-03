package com.pl.web.service;

import com.pl.web.model.WifiPosition;

import java.util.List;


public interface WifiPostionService {
	/*
	 * 查询列表
	 */
	public List<WifiPosition> list(WifiPosition wifiPosition);
	/*
	 * 添加数据
	 */
	public boolean AddWifiPostion(WifiPosition wifiPostion);
	/*
	 * 删除数据
	 */
	public boolean DeleteWifiPostion(int id);
	/*
	 * 更新数据
	 */
	public boolean updateWifiPostion(WifiPosition wifiPostion);
	/*
	 * 通过id查询
	 */
	public WifiPosition getWifiPostionId(int id);
	/*
	 * 搜索查询
	 */
	public List<WifiPosition> searchWifiPostion(String number, String place, String mac, int fromIndex, int pageSize);
	/*
	 * 全部数据记录数(用于分页)
	 */
	public int getDataSize();
	/*
	 * 搜索查询结果的记录数(用于分页)
	 */
	public int searchDataSize(String number, String place, String mac);
}
