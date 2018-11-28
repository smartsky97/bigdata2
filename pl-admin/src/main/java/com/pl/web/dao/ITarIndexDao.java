package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.Tar_index;

/**
 * 计算指标Dao层接口类
 * @author luoly
 *
 */
public interface ITarIndexDao {
	//根据标签的ID查询此标签剩下的所有标签计算种类
	public List<Tar_index> findAll(int label_id);
}
