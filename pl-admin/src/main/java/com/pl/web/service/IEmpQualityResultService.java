package com.pl.web.service;

import com.pl.web.model.EmpQualityResult;
import com.pl.web.model.QualityResultPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IEmpQualityResultService {
	/**
	 * 插入工作量表
	 * @param empQualityResult
	 * @return
	 */
	int insert(EmpQualityResult empQualityResult);
	/**
	 * 查询工作量表的分页数据
	 * @return
	 */
	List<QualityResultPage> select(@Param("computeDate") String computeDate, @Param("department_id") String department_id);
	
	/**
	 * 查询工作量表的所有数据
	 * @return
	 */
	List<EmpQualityResult> selectAll();
	
	/**
	 * 更新工作量表的数据
	 */
	int updateResult(EmpQualityResult empQualityResult);
	
	int resultCount(@Param("computeDate") String computeDate, @Param("department_id") String department_id);
}
