package com.pl.web.model;

import com.pl.common.base.BaseEntity;

/**
 * 员工--移动电子设备mac地址对应
 * @author root
 *
 */
public class UserMac extends BaseEntity {
    /*
     * id
     */
	private Integer id;
	/*
	 * 用户名称
	 */
    private String userName;
    /*
     * 中文姓名
     */
    private String cnName;
    /*
     * mac地址
     */
    private String mac;
    /*
     * 构造方法
     */
    public UserMac(){
    	
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	@Override
	public String toString() {
		return "UserMac [id=" + id + ", userName=" + userName + ", cnName="
				+ cnName + ", mac=" + mac + "]";
	}
	
    
    
}