package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.EmpsKaoQin;
import org.apache.ibatis.annotations.Param;

/**
 * 花样年集团员工考勤展示.
 * @author lihao
 *
 */
public interface EmpsKaoQinMapper {
   
	public List<EmpsKaoQin> findAll(@Param("index") int fromIndex, @Param("length") int pageSize);
	
	public int getAllDataSize();
	
	public List<EmpsKaoQin> searchEmpKaoQin(@Param("department") String department, @Param("mailname") String mailname, @Param("time") String time, @Param("index") int fromIndex, @Param("length") int pageSize);
	
	public int getSearchSize(@Param("department") String department, @Param("mailname") String mailname, @Param("time") String time);
	//导出CSV
	public List<EmpsKaoQin> getEmpsKaoQins2CSV(@Param("department") String department, @Param("mailname") String mailname, @Param("time") String time);
}