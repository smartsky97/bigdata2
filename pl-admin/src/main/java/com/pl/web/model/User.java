package com.pl.web.model;

import java.io.Serializable;

/**
 * 用户管理Bean类
 * @author root
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//ID
	private int id; 
	//登录用户名
    private String name;  
    //登录密码
    private String pwd; 
    //用户级别
    private Integer level;
    //用户角色
    private String roleName;
    
    public User(){
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", level=" + level + ", roleName=" + roleName + "]";
	}  
	
}
