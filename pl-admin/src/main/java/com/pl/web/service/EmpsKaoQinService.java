package com.pl.web.service;

import com.pl.web.model.EmpsKaoQin;

import java.util.List;


public interface EmpsKaoQinService {
	
	public List<EmpsKaoQin> findAll(int fromIndex, int pageSize);
	
	public int getAllDataSize();
	
	public List<EmpsKaoQin> searchEmpKaoQin(String department, String mailname, String time, int fromIndex, int pageSize);
	
	public int getSearchSize(String department, String mailname, String time);
	//查询结果导出Excel文件
	public List<EmpsKaoQin> getEmpsKaoQin2CSV(String department, String mailname, String time);
}
