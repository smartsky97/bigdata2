package com.pl.web.dao;

import com.pl.web.model.LabelTarget;

import java.util.List;

/**
 * 查询标签指标Dao层
 * @author root
 *
 */
public interface LabelTargetDAO {
	/*
	 * 查询所有标签指标
	 */
	List<LabelTarget> queryAll();
}
