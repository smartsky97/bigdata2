package com.pl.web.dao;

import com.pl.web.model.Lables;

import java.util.List;

/**
 * 指标管理Dao层接口.
 * @author root
 *
 */
public interface ILablesDao {
	/*
	 * 查询指标列表
	 */
	public Lables selectLable(Lables lable);
	/*
	 * 插入指标
	 */
	public int insertLable(Lables lable);
	/*
	 * 更新指标
	 */
	public int updateLable(Lables lable);
	/*
	 * 删除指标
	 */
	public int deleteLableById(int id1);
	/*
	 * 查询所有指标
	 */
	public List<Lables> fiandAll();
	/*
	 * 通过Id查询标签
	 */
	public Lables getLablesById(String id);
	
	/*
	 *添加标签 
	 */
	public int add(Lables lables);
	/*
	 * 
	 * 查询总记录数
	 */
	public int getLabelSize();
}