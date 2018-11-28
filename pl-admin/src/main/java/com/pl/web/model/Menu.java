package com.pl.web.model;

import java.io.Serializable;

/**
 * 菜单管理
 * @author Administrator
 *
 */
public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name ;
	
	private String url ;
	
	private String shap ;
	
	private Integer code ;
	
	private String attr ;
	
	public Menu(){
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShap() {
		return shap;
	}

	public void setShap(String shap) {
		this.shap = shap;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


	public String getAttr() {
		return attr;
	}


	public void setAttr(String attr) {
		this.attr = attr;
	}


	@Override
	public String toString() {
		return "Menu [name=" + name + ", url=" + url + ", shap=" + shap
				+ ", code=" + code + ", attr=" + attr + "]";
	}

	


	
}
