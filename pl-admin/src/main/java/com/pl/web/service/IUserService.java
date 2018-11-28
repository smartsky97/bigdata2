package com.pl.web.service;


import com.pl.web.model.User;

import java.util.List;

/**
 * 用户管理Service接口层
 * @author lihao
 *
 */
public interface IUserService {
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
    public int updateUser(User user); 
    /*
     * 删除用户
     */
    public int delete(int id);
    /*
     * 用户登录
     */
    public User login(User user);
    /*
     * 查询用户列表
     */
    List<User> list();
    
    //权限管理
  	public int updatePermission(int id, int level);
}
