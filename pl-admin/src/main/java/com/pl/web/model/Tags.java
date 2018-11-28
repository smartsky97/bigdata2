package com.pl.web.model;
/**
 * 标签Bean类
 * @author root
 *
 */
public class Tags {
	/*
	 * 标签主Id
	 */
    private String id;
    /*
     * 标签副Id
     */
    private String pid;
    /*
     * 标签简称
     */
    private String tagmc;
    /*
     * 标签名称
     */
    private String tagname;
    /*
     * 标签状态
     */
    private String status;

    public Tags(){
    	
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id ;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTagmc() {
        return tagmc;
    }

    public void setTagmc(String tagmc) {
        this.tagmc = tagmc;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status ;
    }
}