package com.pl.web.model;
/**
 * 关键词管理Bean类
 * @author root
 *
 */
public class KeyWords {
	
	/*
	 * 用户Id
	 */
	private int id; 
	
	/*
	 * 公司部门
	 */
	private String mailname;
	/*
	 * 员工姓名
	 */
	private String cname;
	/*
	 * 任务名称
	 */
	private String taskname;
	/*
	 * 关键词
	 */
	private String ikword;
	/*
	 * 开始时间
	 */
	private String startime;
	/*
	 * 结束时间
	 */
	private String endtime;
	/*
	 * 默认构造方法
	 */
	public KeyWords (){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMailname() {
		return mailname;
	}
	public void setMailname(String mailname) {
		this.mailname = mailname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getIkword() {
		return ikword;
	}
	public void setIkword(String ikword) {
		this.ikword = ikword;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	@Override
	public String toString() {
		return "KeyWords [id=" + id + ", mailname=" + mailname + ", cname="
				+ cname + ", taskname=" + taskname + ", ikword=" + ikword
				+ ", startime=" + startime + ", endtime=" + endtime + "]";
	}
	
}
