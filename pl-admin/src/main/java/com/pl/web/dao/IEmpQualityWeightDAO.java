package com.pl.web.dao;

import java.util.List;

import com.pl.web.dto.EmpQualitySaturability;
import com.pl.web.dto.EmpTartgetQuality;
import com.pl.web.model.EmpQualityWeight;
import org.apache.ibatis.annotations.Param;


/**
 * 员工工作量权重数据库访问接口
 * @author songwb
 *
 */
public interface IEmpQualityWeightDAO {
	/**
	 * 插入权重数据到数据库
	 * @param empQualityWeight
	 * @return
	 */
	int insert(EmpQualityWeight empQualityWeight);
	
	/**
	 * 获取量相关的指标数据
	 * @param compute_date 
	 */
	List<EmpTartgetQuality> selectData(@Param("mailName") String mailName, @Param("compute_date") String compute_date) ;

	/**
	 * 获取量相关的指标数据
	 * @param compute_date 
	 */
	List<EmpTartgetQuality> selectDaByDept(@Param("mailName") String mailName, @Param("departmentId") String departmentId,
                                           @Param("compute_date") String compute_date) ;
	
	
	
	/**
	 * 获取量相关的饱和度信息
	 * @param compute_date 
	 * 
	 */
	List<EmpQualitySaturability> selectSaturab(@Param("mailName") String mailName, @Param("startTime") String startTime, @Param("endTime") String endTime);
	
	/**
	 * 获取量相关的饱和度信息
	 * @param compute_date 
	 * 
	 */
	List<EmpQualitySaturability> selectSaturabByDept(@Param("mailName") String mailName, @Param("departmentId") String departmentId, @Param("startTime") String startTime, @Param("endTime") String endTime);
	
	
	/**
	 * 获取所有值
	 */
	List<EmpQualityWeight> list();


	int getSerachDataSize();

	List<EmpQualityWeight> pageShow(@Param("departmentId") String departmentId,
                                    @Param("startime") String startime, @Param("endTime") String endTime, @Param("index") Integer index,
                                    @Param("length") Integer length);

	int resultCount(@Param("departmentId") String departmentId, @Param("starTime") String starTime, @Param("endTime") String endTime);

	EmpQualityWeight getById(int id);

	int update(EmpQualityWeight empQualityWeight);

	List<EmpTartgetQuality> selectDaByDeptAvg(@Param("mailName") String mailName, @Param("departmentId") String departmentId
            , @Param("compute_date") String compute_date);

	List<EmpQualitySaturability> selectSaturabByDeptAvg(@Param("mailName") String mailName, @Param("departmentId") String departmentId,
                                                        @Param("startTime") String startTime, @Param("endTime") String endTime);
}
