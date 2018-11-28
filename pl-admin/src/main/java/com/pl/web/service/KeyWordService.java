package com.pl.web.service;

import com.pl.web.model.KeyWords;

import java.util.List;


/**
 * 关键词管理Service层
 * @author root
 *
 */
public interface KeyWordService {
	/*
	 * 查询列表
	 */
	public List<KeyWords> list(int fromIndex, int pageSize);
	/*
	 * 添加关键词
	 */
	public boolean Add(KeyWords keyWords);
	/*
	 * 删除关键词
	 */
	public boolean Delete(int id);
	/*
	 * 更新关键词
	 */
	public boolean updateKeyWord(KeyWords keyWords);
	/*
	 * 通过id查询
	 */
	public KeyWords getKeyWordsById(int id);
	/*
	 * 搜索查询
	 */
	public List<KeyWords> searchKeyWords(String mailname, String cname, String startime, String endtime, String taskname,
                                         int fromIndex, int pageSize);
	/*
	 * 获取总数据量(用于分页)
	 */
	public int getKeyWordsDataSize();
	/*
	 * 查询出的数据量(用于分页)
	 */
	public int getSearchKeyWordsDataSize(String mailname, String cname, String startime, String endtime, String taskname);
	
}
