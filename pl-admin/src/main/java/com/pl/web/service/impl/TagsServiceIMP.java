package com.pl.web.service.impl;

import com.pl.web.dao.ITagsDao;
import com.pl.web.dto.EmpTargetResult;
import com.pl.web.model.Tags;
import com.pl.web.service.ITagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签管理ServiceIMP层
 * @author root
 *
 */
@Service
public class TagsServiceIMP implements ITagsService {
	/*
	 * dao层注入
	 */
	@Autowired
	private ITagsDao iTagsDao;
	
	/*
	 * 查询标签
	 */
	@Override
	public Tags selectTag(Tags tags) {
		// TODO Auto-generated method stub
		return this.iTagsDao.selectTag(tags);
	}
	/*
	 * 插入标签
	 */
	@Override
	public int insertTag(Tags tags) {
		// TODO Auto-generated method stub
		return this.iTagsDao.add(tags);
	}

	@Override
	public List<Tags> list(int fromIndex,int pageSize) {
		// TODO Auto-generated method stub
		return iTagsDao.fiandAll(fromIndex,pageSize) ;
	}
	
	@Override
	public int updateTags(Tags tags) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTagById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTags(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * 删除标签
	 */
	public boolean del(String id) {
		int count=this.iTagsDao.delete(id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 更新标签
	 */
	public boolean update1(Tags tags) {
		int count=this.iTagsDao.updateTag(tags);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 更新标签状态
	 */
	public boolean updateStatus(List<Tags> list) {
		int count=this.iTagsDao.updateTagStatus(list);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 新增标签
	 */
	public boolean addTags(Tags tags) {
		int count=this.iTagsDao.add(tags);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	/*
	 * 通过id获取标签
	 */
	public Tags getTagsById(String id) {
		// TODO Auto-generated method stub
		return this.iTagsDao.getTagsById(id);
	}
	/*
	 * 标签展示
	 */
	@Override
	public List<EmpTargetResult> show(String departmentId, String cnName,
									  String startTime) {
		return iTagsDao.show(departmentId, cnName, startTime);
	}

	@Override
	public List<EmpTargetResult> pageShow(String departmentId, String cnName, String startime,
			Integer index, Integer length) {
		return iTagsDao.pageShow(departmentId, cnName, startime, index, length);
	}

	@Override
	public int resultCount(String departmentId, String cnName, String startTime) {
		return iTagsDao.resultCount(departmentId, cnName, startTime);
	}
	@Override
	public int getTagsSize() {
		// TODO Auto-generated method stub
		return this.iTagsDao.getTagsSize();
	}
	@Override
	public int update(Tags tags) {
		int count = this.iTagsDao.update(tags);
		if (count > 0) {
			return 1;
		} else {
			return 0;
		}
		
	}

	
	

}
