package com.pl.web.dao;

import com.pl.web.model.Url;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UrlDao {
    //保存URL
	public void saveUrl(Url url);
    //分页显示URL列表
	public List<Url> getUrls(Url url);
	//删除URL
	public void deleteUrl(@Param("urlName") String urlName);
	//查询URL通过URL名称
	public Url getUrlByName(@Param("urlName") String urlName);
	// 更新URL
	public void updateUrl(Url url);
	//获取URL对象列表
	public List<Url> getUrls1();
	//删除URL
	public void deleteUrl1(Url url);
	//获取URL的数量(用于分页)
	public int getUrlSize();
	//查询URL
	public List<Url> searchUrl(@Param("urlName") String urlName, @Param("urlType") String urlType);
	//验证如果已经存在的URL不再添加
	public int compareUrl(@Param("urlName") String urlName);
	
}
