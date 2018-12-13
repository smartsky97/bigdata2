package com.pl.web.service;

import com.pl.web.model.UserMac;

import java.util.List;


public interface UserMacService {
	/*
	 * 查询列表
	 */
	public List<UserMac> list(UserMac userMac);
	/*
	 * 添加数据
	 */
	public boolean AddUserMac(UserMac userMac);
	/*
	 * 删除
	 */
	public boolean DeleteUserMac(int id);
	/*
	 * 更新
	 */
	public boolean updateUserMac(UserMac userMac);
	/*
	 * 通过id查询
	 */
	public UserMac getUserMacById(int id);
	/*
	 * 搜索查询
	 */
	public List<UserMac> searchUserMac(String userName, String cnName, String mac, int fromIndex, int pageSize);
	
	/*
	 * 查询总记录数,用于分页
	 */
	public int getAllDataSize();
	
	/*
	 * 条件查询总记录数,用于分页
	 */
	public int searchDataSize(String userName, String cnName, String mac);
	
	/*
	 * 更新/添加前的验证是否有重复数据.
	 */
	public int Compare(String mac);
	public int Compare2(String mac,int id);
}
