package com.pl.web.dao;

import com.pl.web.dto.EmpTargetResult;
import com.pl.web.model.Tags;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 标签管理Dao层接口
 * @author root
 *
 */
public interface ITagsDao {
	public int getTagsSize();
	/*
	 * 查询标签
	 */
	public Tags selectTag(Tags tags);
	/*
	 * 添加标签
	 */
	public int add(Tags tags);
	/*
	 * 更新标签
	 */
	public int updateTag(Tags tags);
	/*
	 * 更新标签状态1
	 */
	public int update(Tags tags);
	/*
	 * 更新标签状态
	 */
	public int updateTagStatus(List<Tags> list);
	/*
	 * 删除标签
	 */
	public int delete(String id);
	/*
	 * 查询标签列表
	 */
	public List<Tags> fiandAll(@Param("index") int fromIndex, @Param("length") int pageSize);
	/*
	 * 由Id查询标签
	 */
	public Tags getTagsById(String id);
	/*
	 * 展示标签
	 */
	public List<EmpTargetResult> show(@Param("departmentId") String departmentId, @Param("cnName") String cnName, @Param("startTime") String startime);
	
	public List<EmpTargetResult> pageShow(@Param("departmentId") String departmentId, @Param("cnName") String cnName, @Param("startTime") String startime,
                                          @Param("index") Integer index, @Param("length") Integer length);
	
	public int resultCount(@Param("departmentId") String departmentId, @Param("cnName") String cnName, @Param("startTime") String startTime);
}
