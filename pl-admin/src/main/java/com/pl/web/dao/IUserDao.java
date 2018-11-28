package com.pl.web.dao;

import com.pl.web.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao层接口,不必要写实现类,在mybatis的对应*.xml里自动实现.
 * 用户管理Dao层接口
 * @author root
 *
 */
public interface IUserDao {
	/*
	 * 查询用户
	 */
	public User selectUser(User user);
	/*
	 * 添加用户
	 */
	public int add(User user);
	/*
	 * 更新用户
	 */
	public int update(User user);
	/*
	 * 删除用户
	 */
	public int delete(int id);
	/*
	 * 用户登陆
	 */
	public User login(User user);
	/*
	 * 查询所有用户
	 */
	public List<User> fiandAll();
	/*
	 * 通过Id查询用户
	 */
	public User getUserByid(String id2);
	
	//权限管理
	public int updatePermission(@Param("id") int id, @Param("level") int level);

}
