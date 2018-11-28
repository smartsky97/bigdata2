package com.pl.web.service;

import java.util.List;

import com.pl.web.dto.EmpQualitySaturability;
import com.pl.web.dto.EmpTartgetQuality;
import com.pl.web.model.EmpQualityWeight;
import org.apache.ibatis.annotations.Param;


public interface IEmpQualityWeightService {
	
	
	public  int getSerachDataSize();
   /**	
	 * 插入权重数据到数据库
	 * @param empQualityWeight
	 * @return
	 */
	int insert(EmpQualityWeight empQualityWeight);
	
	int update(EmpQualityWeight empQualityWeight);
	/**
	 * 获取量相关的指标数据
	 */
	List<EmpTartgetQuality> selectData(@Param("mailName") String mailName, @Param("compute_date") String compute_date) ;

	/**
	 * 获取量部门相关的指标数据
	 */
	List<EmpTartgetQuality> selectDaByDept(@Param("mailName") String mailName, @Param("departmentId") String departmentId,
                                           @Param("compute_date") String compute_date);
	
	
	
	
	/**
	 * 获取量相关的饱和度信息
	 * 
	 */
	List<EmpQualitySaturability> selectSaturab(@Param("mailName") String mailName,
											   @Param("startime") String startime, @Param("endTime") String endTime);
	
	public List<EmpQualityWeight> list();
	
	
	public List<EmpQualityWeight> pageShow(@Param("dept_id") String dept_id, @Param("startTime") String startime,
                                           @Param("endTime") String endTime, @Param("index") Integer index, @Param("length") Integer length);
	
	public int resultCount(@Param("departmentId") String departmentId, @Param("startTime") String starTime,
                           @Param("endTime") String endTime);
	
	public EmpQualityWeight getById(int id);

	public List<EmpQualitySaturability> selectSaturabByDept(@Param("mailName") String mailName,
                                                            @Param("departmentId") String departmentId, @Param("startTime") String starTime,
                                                            @Param("endTime") String endTime);
	
	public List<EmpQualitySaturability> selectSaturabByDeptAvg(@Param("mailName") String mailName,
                                                               @Param("departmentId") String departmentId, @Param("startTime") String starTime,
                                                               @Param("endTime") String endTime);

	/**
	 * 获取量部门相关的指标数据
	 */
	List<EmpTartgetQuality> selectDaByDeptAvg(@Param("mailName") String mailName, @Param("departmentId") String departmentId,
                                              @Param("compute_date") String compute_date);
}
