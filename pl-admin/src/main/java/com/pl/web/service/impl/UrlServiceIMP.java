package com.pl.web.service.impl;

import com.pl.web.dao.UrlDao;
import com.pl.web.model.Url;
import com.pl.web.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Url管理ServiceIMP层
 * @author root
 *
 */
@Service
public class UrlServiceIMP implements UrlService {
	/*
	 * dao层注入
	 */
	@Autowired
    private UrlDao urlDao;
	/*
	 * 获取Url列表
	 */
	@Override
	public List<Url> getUrls(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.urlDao.getUrls(fromIndex,pageSize);
	}
	@Override
	public int getUrlSize(){
		return urlDao.getUrlSize();
	}
	/*
	 * 添加Url
	 */
	@Override
	public void saveUrl(Url url) {
		// TODO Auto-generated method stub
		urlDao.saveUrl(url);
	}
	/*
	 * 删除Url
	 */
	@Override
	public void deleteUrl(String urlName) {
		// TODO Auto-generated method stub
		urlDao.deleteUrl(urlName);
	}
	
	@Override
	public Url getUrlByName(String urlName) {
		// TODO Auto-generated method stub
		return urlDao.getUrlByName(urlName);
	}
	@Override
	public void updateUrl(Url url){
		urlDao.updateUrl(url);
	}

	@Override
	public List<Url> getUrls1() {
		// TODO Auto-generated method stub
		return urlDao.getUrls1();
	}
    @Override
	public void deleteUrl1(Url url) {
		// TODO Auto-generated method stub
		urlDao.deleteUrl1(url);
		
	}
    //查询URL
	@Override
	public List<Url> SearchURL(String urlName, String urlType) {
		// TODO Auto-generated method stub
		return this.urlDao.searchUrl(urlName, urlType);
	}
	@Override
	public int compareURL(String urlName) {
		// TODO Auto-generated method stub
		return this.urlDao.compareUrl(urlName);
	}
	
	
}
