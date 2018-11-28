package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.UserMac;
import org.apache.ibatis.annotations.Param;


public interface UserMacMapper {
	/*
	 * 查询用户
	 */
	public List<UserMac> searchUserMac(@Param("userName") String userName, @Param("cnName") String cnName, @Param("mac") String mac, @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 添加用户
	 */
	public int addUserMac(UserMac userMac);
	/*
	 * 更新用户
	 */
	public int updateUserMac(UserMac userMac);
	/*
	 * 删除用户
	 */
	public int deleteUserMac(int id);
	/*
	 * 查询所有用户Mac
	 */
	public List<UserMac> fiandAll(@Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 通过Id查询
	 */
	public UserMac getUserMacById(int id);
	/*
	 * 查询总记录数,用于分页
	 */
	public int getAllDataSize();
	/*
	 * 条件查询总记录数,用于分页
	 */
	public int searchDataSize(@Param("userName") String userName, @Param("cnName") String cnName, @Param("mac") String mac);
	/*
	 * 添加/更新前查询是否存在.
	 */
	public int Compare(@Param("mac") String mac);
	
}