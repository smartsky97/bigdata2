package com.pl.web.service.impl;

import com.pl.web.dao.IUserDao;
import com.pl.web.model.User;
import com.pl.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户管理ServiceIMP层
 * @author root
 *
 */
@Service
public class UserServiceIMP implements IUserService {
	/*
	 * dao层注入
	 */
	@Autowired
	private IUserDao iUserDao;
	
	/*
	 * 用户登录
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return this.iUserDao.login(user);
	}
	/*
	 * 用户列表
	 */
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return iUserDao.fiandAll();
	}
	/*
	 * 查询用户
	 */
	@Override
	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return this.iUserDao.selectUser(user);
	}
	/*
	 * 添加用户
	 */
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return this.iUserDao.add(user);
	}
	/*
	 * 更新用户
	 */
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return this.iUserDao.update(user);
	}
	/*
	 * 删除用户
	 */
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return this.iUserDao.delete(id);
	}
	/*
	 * 删除
	 */
	public boolean del(int id) {
		int count=this.iUserDao.delete(id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 更新
	 */
	public boolean update(User user) {
		int count=this.iUserDao.update(user);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 增加
	 */
	public boolean adduser(User user) {
		int count=this.iUserDao.add(user);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 通过id查询用户
	 */
	public User getUserById(String id2) {
		// TODO Auto-generated method stub
		return this.iUserDao.getUserByid(id2);
	}
	
	public boolean Login(User user){
		user = this.iUserDao.login(user);
		if (user ==null ||"".equals(user)) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public int updatePermission(int id, int level) {
		
		return this.iUserDao.updatePermission(id, level);
	}

}
