package com.pl.web.service.impl;

import com.pl.web.dao.ITagsMapper;
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
	private ITagsMapper iTagsMapper;
	
	/*
	 * 查询标签
	 */
	@Override
	public Tags selectTag(Tags tags) {
		// TODO Auto-generated method stub
		return this.iTagsMapper.selectTag(tags);
	}
	/*
	 * 插入标签
	 */
	@Override
	public int insertTag(Tags tags) {
		// TODO Auto-generated method stub
		return this.iTagsMapper.add(tags);
	}

	@Override
	public List<Tags> list() {
		// TODO Auto-generated method stub
		return iTagsMapper.fiandAll() ;
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
		int count=this.iTagsMapper.delete(id);
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
		int count=this.iTagsMapper.updateTag(tags);
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
		int count=this.iTagsMapper.updateTagStatus(list);
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
		int count=this.iTagsMapper.add(tags);
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
		return this.iTagsMapper.getTagsById(id);
	}
	/*
	 * 标签展示
	 */
	@Override
	public List<EmpTargetResult> show(String departmentId, String cnName,
									  String startTime) {
		return iTagsMapper.show(departmentId, cnName, startTime);
	}

	@Override
	public List<EmpTargetResult> pageShow(String departmentId, String cnName, String startime,
			Integer index, Integer length) {
		return iTagsMapper.pageShow(departmentId, cnName, startime, index, length);
	}

	@Override
	public int resultCount(String departmentId, String cnName, String startTime) {
		return iTagsMapper.resultCount(departmentId, cnName, startTime);
	}
	@Override
	public int getTagsSize() {
		// TODO Auto-generated method stub
		return this.iTagsMapper.getTagsSize();
	}
	@Override
	public int update(Tags tags) {
		int count = this.iTagsMapper.update(tags);
		if (count > 0) {
			return 1;
		} else {
			return 0;
		}
		
	}

	
	

}
