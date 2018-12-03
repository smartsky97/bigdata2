package com.pl.web.service;


import com.pl.web.model.Url;

import java.util.List;

public interface UrlService {
	//分页显示URL列表
    public List<Url> getUrls(Url url);
    //URL1列表
    public List<Url> getUrls1();
    //保存URL
    public void saveUrl(Url url);
    //删除URL
    public void deleteUrl(String urlName);
    //通过URL名称查询
    public Url getUrlByName(String urlName);
    //更新URL
    public void updateUrl(Url url);
	//删除URL1
    public void deleteUrl1(Url url);
	//获得URL总数(用于分页)
    public int getUrlSize();
	//查询URL
    public List<Url> SearchURL(String urlName, String urlType);
    //验证添加的url是否已经存在
    public int compareURL(String urlName);
}
