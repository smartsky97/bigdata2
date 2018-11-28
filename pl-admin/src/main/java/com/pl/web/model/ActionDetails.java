package com.pl.web.model;
/**
 * 员工工作详情信息类
 * @author root
 *
 */
public class ActionDetails  {
    /*
     * 用户名
     */
	private String mailname;
	/*
	 * 日期
	 */
    private String date;
    /*
     * 工作类型
     */
    private String type;
    /*
     * 持续时间
     */
    private Integer slot;
    
    public ActionDetails(){
    	
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

    public String getType() {
        return type ;
    }

    public void setType(String type) {
        this.type = type ;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}