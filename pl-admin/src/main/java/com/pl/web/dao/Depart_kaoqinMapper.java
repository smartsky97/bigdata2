package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.Depart_kaoqin;
import org.apache.ibatis.annotations.Param;


public interface Depart_kaoqinMapper {
    
	//部门考勤
    public List<Depart_kaoqin> findAll(@Param("index") int fromIndex, @Param("length") int pageSize);
    //得到数据量(分页)
    public int getAllDataSize();
    
    //部门考勤查询
    public List<Depart_kaoqin> searchDekq(@Param("department") String department, @Param("time") String time, @Param("index") int fromIndex, @Param("length") int pageSize);
    
    //查询分页
    public int getSearchSize(@Param("department") String department, @Param("time") String time);
    //查询数据导出
    public List<Depart_kaoqin> getDeKaoqins2CSV(@Param("department") String department, @Param("time") String time);
    
    
}