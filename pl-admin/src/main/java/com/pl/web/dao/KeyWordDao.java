package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.KeyWords;
import org.apache.ibatis.annotations.Param;


/**
 * 关键词管理Dao层接口
 * @author root
 *
 */
public interface KeyWordDao {
	/*
	 * 查询列表
	 */
	public List<KeyWords> findAll(@Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 删除
	 */
	public int deleteKeyWord(int id);
	/*
	 * 添加
	 */
	public int addKeyWord(KeyWords keyWords);
	/*
	 * 更新
	 */
	public int updateKeyWord(KeyWords keyWords);
	/*
	 * 通过关键词查询
	 */
	public KeyWords getKeyWordById(int id);
	/*
	 * 搜索查询
	 */
	public List<KeyWords> searchKeyWords(@Param("mailname") String mailname, @Param("cname") String cname, @Param("startime") String startime, @Param("endtime") String endtime, @Param("taskname") String taskname,
                                         @Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 获取总数据量(用于分页)
	 */
	public int getKeyWordsDataSize();
	/*
	 * 搜索查询到的记录数(用于分页)
	 */
	public int getSearchKeyWordsDataSize(@Param("mailname") String mailname, @Param("cname") String cname, @Param("startime") String startime, @Param("endtime") String endtime, @Param("taskname") String taskname);
}
