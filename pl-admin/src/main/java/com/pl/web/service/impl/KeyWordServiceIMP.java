package com.pl.web.service.impl;

import com.pl.web.dao.KeyWordDao;
import com.pl.web.model.KeyWords;
import com.pl.web.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 关键词管理Service实现层
 * @author root
 *
 */
@Service
public class KeyWordServiceIMP implements KeyWordService {
	
	@Autowired
	private KeyWordDao keyWordDao;
	
	/*
	 * 查询关键词列表
	 */
	@Override
	public List<KeyWords> list(int fromIndex, int pageSize) {
		
		return this.keyWordDao.findAll(fromIndex, pageSize);
	}

	@Override
	public boolean Add(KeyWords keyWords) {
		int count = this.keyWordDao.addKeyWord(keyWords);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean Delete(int id) {
		int count=this.keyWordDao.deleteKeyWord(id);
		if(count>0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateKeyWord(KeyWords keyWords) {
		int count=this.keyWordDao.updateKeyWord(keyWords);
		if(count>0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public KeyWords getKeyWordsById(int id) {
		
		return this.keyWordDao.getKeyWordById(id);
	}

	@Override
	public List<KeyWords> searchKeyWords(String mailname, String cname,
			String startime, String endtime, String taskname, int fromIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		return this.keyWordDao.searchKeyWords(mailname, cname, 
				startime, endtime, taskname, fromIndex, pageSize);
	}

	@Override
	public int getKeyWordsDataSize() {
		
		return this.keyWordDao.getKeyWordsDataSize();
	}

	@Override
	public int getSearchKeyWordsDataSize(String mailname, String cname,
			String startime, String endtime, String taskname) {
		// TODO Auto-generated method stub
		return this.keyWordDao.getSearchKeyWordsDataSize(mailname, cname,
				startime, endtime, taskname);
	}	

}
