package com.pl.web.model;

public class UrlIndex {
    private String urlType;
    private String urlType_name;
	public String getUrlType() {
		return urlType;
	}
	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}
	public String getUrlType_name() {
		return urlType_name;
	}
	public void setUrlType_name(String urlType_name) {
		this.urlType_name = urlType_name;
	}
	public UrlIndex() {
		// TODO Auto-generated constructor stub
	}
	public UrlIndex(String urlType, String urlType_name) {
		this.urlType = urlType;
		this.urlType_name = urlType_name;
	}
	@Override
	public String toString() {
		return "UrlIndex [urlType=" + urlType + ", urlType_name="
				+ urlType_name + "]";
	}
    
}
