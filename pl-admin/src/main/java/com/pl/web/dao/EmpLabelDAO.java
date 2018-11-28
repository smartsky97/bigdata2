package com.pl.web.dao;

import java.util.List;

import com.pl.web.dto.EmpLabelResult;
import com.pl.web.model.EmpLabel;
import org.apache.ibatis.annotations.Param;


public interface EmpLabelDAO {
	int insert(EmpLabel empLabel);
	List<EmpLabelResult> selectByUserId(@Param("departmentId") String departmentId, @Param("cnName") String cnName);
}
