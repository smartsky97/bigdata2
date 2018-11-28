package com.pl.web.service.impl;

import com.pl.web.dao.ILablesDao;
import com.pl.web.model.Lables;
import com.pl.web.service.ILablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 指标管理ServiceIMP层
 * @author root
 *
 */
@Service
public class LablesServiceIMP implements ILablesService {
	/*
	 * dao层注入
	 */
	@Autowired
	private ILablesDao iLablesDao;
	/*
	 * 查询指标
	 */
	@Override
	public Lables selectLable(Lables lable) {
		// TODO Auto-generated method stub
		return this.selectLable(lable);
	}
	/*
	 * 插入指标
	 */
	@Override
	public int insertLable(Lables lable) {
		// TODO Auto-generated method stub
		return this.iLablesDao.insertLable(lable);
	}
	/*
	 * 更新指标
	 */
	@Override
	public int updateLable(Lables lable) {
		// TODO Auto-generated method stub
		return this.updateLable(lable);
	}
	/*
	 * 删除指标
	 */
	@Override
	public int deleteLableById(int lable_id) {
		// TODO Auto-generated method stub
		return this.iLablesDao.deleteLableById(lable_id);
	}
	/*
	 * 查询指标列表
	 */
	@Override
	public List<Lables> list(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return iLablesDao.fiandAll(fromIndex,pageSize);
	}
	/*
	 * 删除指标
	 */
	public boolean del(int id1) {
		int count =this.iLablesDao.deleteLableById(id1);
		if(count>0){
			return true;
		}else {
			return false;
		}
		
	}
	/*
	 * 增加指标
	 */
	public boolean addLables(Lables lables) {
		int conut=this.iLablesDao.add(lables);
		if(conut>0){
			return true;
		}else {
			return false;
		}
		
	}
	/*
	 * 更新指标
	 */
	public boolean update(Lables lables) {
		int counts=this.iLablesDao.updateLable(lables);
		if(counts>0){
			return true;
		}else {
			return false;
		}
		
	}
	/*
	 * 通过id获得指标
	 */
	public Lables getLablesById(String id) {
		// TODO Auto-generated method stub
		return this.iLablesDao.getLablesById(id);
	}
	
	@Override
	public int getLabelSize() {
		// TODO Auto-generated method stub
		return iLablesDao.getLabelSize();
	}
	
	

}
