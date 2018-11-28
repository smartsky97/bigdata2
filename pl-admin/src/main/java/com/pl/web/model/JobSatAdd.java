package com.pl.web.model;

import com.pl.common.base.BaseEntity;

/**
 * 工作饱和度(加法)Bean类
 * @author root
 *
 */
public class JobSatAdd  extends BaseEntity {
	/*
	 * 员工姓名
	 */
	private String mailname;
	/*
	 * 日期
	 */
	private String date;
	/*
	 * 工作饱和度
	 */
	private String saturability;

	private Integer department;

	public JobSatAdd(){
		
	}
	public String getSaturability() {
		return saturability;
	}

	public void setSaturability(String saturability) {
		this.saturability = saturability;
	}

	public String getMailname() {
		return mailname;
	}

	public void setMailname(String mailname) {
		this.mailname = mailname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date ;
	}

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }
}