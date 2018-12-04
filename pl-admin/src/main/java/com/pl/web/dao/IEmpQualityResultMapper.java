package com.pl.web.dao;

import com.pl.web.model.EmpQualityResult;
import com.pl.web.model.QualityResultPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 工作量结果DAO
 * @author songwb
 *
 */
public interface IEmpQualityResultMapper {
	/**
	 * 插入工作量表
	 * @param empQualityResult
	 * @return
	 */
	int insert(EmpQualityResult empQualityResult);
	/**
	 * 查询工作量表的所有数据
	 * @return
	 */
	List<EmpQualityResult> selectAll();
	
	/**
	 * 查询工作量表的所有数据,带有分页效果的
	 * @return
	 */
	List<QualityResultPage> select(@Param("computeDate") String computeDate, @Param("department_id") String department_id,
								   @Param("userid") Long userid);
	

	int resultCount(@Param("computeDate") String computeDate, @Param("department_id") String department_id);
	
	/**
	 * 更新工作量表的数据
	 */
	int updateResult(EmpQualityResult empQualityResult);
	
	
}
