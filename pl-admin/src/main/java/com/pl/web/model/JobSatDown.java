package com.pl.web.model;
/**
 * 员工工作饱和度(减法)
 * @author lh
 *
 */
public class JobSatDown  {
	/*
	 * 工作饱和度那
	 */
	private String saturability;
	/*
	 * 员工名称
	 */
	private String mailname;
	/*
	 * 日期
	 */
	private String date;

	public JobSatDown(){
		
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

	public String getSaturability() {
		return saturability;
	}

	public void setSaturability(String saturability) {
		this.saturability = saturability;
	}
}