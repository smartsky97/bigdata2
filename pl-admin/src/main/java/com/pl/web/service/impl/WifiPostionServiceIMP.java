package com.pl.web.service.impl;

import com.pl.web.dao.WifiPostionMapper;
import com.pl.web.model.WifiPosition;
import com.pl.web.service.WifiPostionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * wifi探针mac和位置的对应关系service实现层.
 * @author root
 *
 */
@Service
public class WifiPostionServiceIMP implements WifiPostionService {
	/*
	 * dao层注入
	 */
	@Autowired
	private WifiPostionMapper wifiPostionMapper;
	
	/*
	 * 添加
	 */
	@Override
	public boolean AddWifiPostion(WifiPosition wifiPostion) {
		int count=this.wifiPostionMapper.addWifiPostion(wifiPostion);
		if(count>0){
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 删除
	 */
	@Override
	public boolean DeleteWifiPostion(int id) {
		// TODO Auto-generated method stub
		int count1=this.wifiPostionMapper.deleteWifiPostion(id);
		if(count1>0){
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 更新
	 */
	@Override
	public boolean updateWifiPostion(WifiPosition wifiPostion) {
		int count2=this.wifiPostionMapper.updateWifiPostion(wifiPostion);
		if(count2>0){
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 由id查询
	 */
	@Override
	public WifiPosition getWifiPostionId(int id) {
		
		return this.wifiPostionMapper.getWifiPostionById(id);
	}
	/*
	 * 分页显示
	 */
	@Override
	public List<WifiPosition> list(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.wifiPostionMapper.findAll(fromIndex, pageSize);
	}
	/*
	 * 查询结果分页显示
	 */
	@Override
	public List<WifiPosition> searchWifiPostion(String number, String place,
			String mac, int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.wifiPostionMapper.searchWifiPostion(number, place, mac, fromIndex, pageSize);
	}
	/*
	 * 所有数据记录数(用于分页)
	 */
	@Override
	public int getDataSize() {
		
		return this.wifiPostionMapper.getDataSize();
	}
	/*
	 * 得到查询的所有记录数(用于分页)
	 */
	@Override
	public int searchDataSize(String number, String place, String mac) {
		
		return this.wifiPostionMapper.searchDataSize(number, place, mac);
	}
	
}