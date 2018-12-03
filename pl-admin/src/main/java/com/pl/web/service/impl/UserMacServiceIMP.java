package com.pl.web.service.impl;

import com.pl.web.dao.UserMacMapper;
import com.pl.web.model.UserMac;
import com.pl.web.service.UserMacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user-mac管理service实现层.
 * @author root
 *
 */
@Service
public class UserMacServiceIMP implements UserMacService {
	/*
	 * 注入
	 */
	@Autowired
	private UserMacMapper userMacMapper;
	/*
	 * 查询列表 
	 */
	@Override
	public List<UserMac> list(UserMac userMac) {
		return this.userMacMapper.fiandAll(userMac);
	}
	/*
	 * 添加
	 */
	@Override
	public boolean AddUserMac(UserMac userMac) {
		int count=this.userMacMapper.addUserMac(userMac);
		if(count>0){
			return true;
		}else{
		
			return false;
		}
	}
	/*
	 * 删除
	 */
	@Override
	public boolean DeleteUserMac(int id) {
		int count1=this.userMacMapper.deleteUserMac(id);
		if(count1>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 更新 
	 */
	@Override
	public boolean updateUserMac(UserMac userMac) {
		int count2=this.userMacMapper.updateUserMac(userMac);
		if(count2>0){
			return true;
		}else{
			return false;
		}
		
	}
	//由id查询
	@Override
	public UserMac getUserMacById(int id) {
		
		return this.userMacMapper.getUserMacById(id);
	}
	//搜索
	@Override
	public List<UserMac> searchUserMac(String userName,String cnName,String mac,int fromIndex, int pageSize) {
		
		return this.userMacMapper.searchUserMac(userName,cnName, mac, fromIndex, pageSize);
	}
	/*
	 *数据总记录数(用于分页)
	 */
	@Override
	public int getAllDataSize() {
		// TODO Auto-generated method stub
		return this.userMacMapper.getAllDataSize();
	}
	/*
	 * 查询的总记录数(用于分页)
	 */
	@Override
	public int searchDataSize(String userName,String cnName,String mac) {
		// TODO Auto-generated method stub
		return this.userMacMapper.searchDataSize(userName,cnName, mac);
	}
	@Override
	public int Compare(String mac) {
		// TODO Auto-generated method stub
		return this.userMacMapper.Compare(mac);
	}

}
