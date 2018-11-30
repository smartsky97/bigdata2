package com.pl.web.service;

import com.pl.web.dto.EmpTargetResult;
import com.pl.web.model.Tags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签管理Service接口层
 * @author root
 *
 */
public interface ITagsService {
	/*
	 * 获取指标总记录数
	 * 
	 */
	public int getTagsSize();
	/*
	 * 查询标签
	 */
	public Tags selectTag(Tags tags);
	/*
	 * 插入标签
	 */
	public int insertTag(Tags tags);
	/*
	 * 更新标签
	 */
	public int updateTags(Tags tags);
	/*
	 * 删除标签
	 */
	public int deleteTagById(String id);
	/*
	 * 分页查询标签列表
	 */
	List<Tags> list();
	/*
	 * 更新标签
	 */
	int updateTags(String id);
	/*
	 * 标签展示
	 */
	public List<EmpTargetResult> show(String departmentId, String cnName,
									  String startTime);
	
	public List<EmpTargetResult> pageShow(@Param("departmentId") String departmentId, @Param("cnName") String cnName, @Param("startTime") String startime,
                                          @Param("index") Integer index, @Param("length") Integer length);
	
	public int resultCount(@Param("departmentId") String departmentId, @Param("cnName") String cnName, @Param("startTime") String starTime);
	/*
	 * 更新标签1
	 */
	public int update(Tags tags);
}
