package com.pl.web.service.impl;

import com.pl.web.dao.ITarIndexDao;
import com.pl.web.model.Tar_index;
import com.pl.web.service.ITarIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 标签指标Service层实现类
 * @author root
 *
 */
@Service
public class TarIndexServiceIMP implements ITarIndexService {

	@Autowired
	private ITarIndexDao iTarIndexDao;
	
	/**
	 * 根据标签的ID查询此标签剩下的所有标签计算种类
	 * @param label_id
	 * @return List<Tar_index>
	 */
	@Override
	public List<Tar_index> findAll(int label_id) {
		// TODO Auto-generated method stub
		return this.iTarIndexDao.findAll(label_id);
	}

}
