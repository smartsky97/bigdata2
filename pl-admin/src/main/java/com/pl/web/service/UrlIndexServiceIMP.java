package com.pl.web.service;

import com.pl.web.dao.UrlIndexDao;
import com.pl.web.model.UrlIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlIndexServiceIMP implements UrlIndexService{
	@Autowired
    private UrlIndexDao urlIndexDao;
	public List<UrlIndex> getUrlindexs() {
		// TODO Auto-generated method stub
		return urlIndexDao.getUrlindexs();
	}

}
