package com.pl.web.model;
/**
 * 访问Url管理Bean类
 * @author root
 *
 */
public class Url {
	/*
	 * Url名称
	 */
    private String urlName;
    /*
     * Url类型
     */
    private int urlType;
    /*
     * url对应类型中文名
     * 
     */
    private String urlType_name;
	
    public Url() {
		
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public int getUrlType() {
		return urlType;
	}
	public void setUrlType(int urlType) {
		this.urlType = urlType;
	}
	public String getUrlType_name() {
		return urlType_name;
	}
	public void setUrlType_name(String urlType_name) {
		this.urlType_name = urlType_name;
	}
	@Override
	public String toString() {
		return "Url [urlName=" + urlName + ", urlType=" + urlType
				+ ", urlType_name=" + urlType_name + "]";
	}
	
    
}
