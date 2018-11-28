package com.pl.web.service;

import com.pl.web.dto.EmpLabelResult;
import com.pl.web.model.EmpLabel;

import java.util.List;


public interface IEmpLabelService {
	int insert(EmpLabel empLabel);
	List<EmpLabelResult> selectByUserId(String departmentId, String cnName);
}
