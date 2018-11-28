package com.pl.web.model;

public class DateTime {
	
	//ID
	private int id;
	//日期
	private String date;
	//对日期的描述
	private String descb;
	//默认的构造方法
	public DateTime(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescb() {
		return descb;
	}
	public void setDescb(String descb) {
		this.descb = descb;
	}
	@Override
	public String toString() {
		return "DateTime [id=" + id + ", date=" + date + ", descb=" + descb
				+ "]";
	}
}
