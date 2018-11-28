package com.pl.web.service;

import com.pl.web.model.Tar_index;

import java.util.List;

/**
 * 标签指标Service层接口类
 * @author root
 *
 */
public interface ITarIndexService {
/**
 * 根据标签的ID查询此标签剩下的所有标签计算种类
 * @param label_id
 * @return List<Tar_index>
 */
	public List<Tar_index> findAll(int label_id);
}
