package com.pl.web.service.impl;

import com.pl.web.dao.EmpLabelDAO;
import com.pl.web.dto.EmpLabelResult;
import com.pl.web.model.EmpLabel;
import com.pl.web.service.IEmpLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpLabelServiceIMP implements IEmpLabelService {

	@Autowired
	private EmpLabelDAO empLabelDAO;
	
	@Override
	public int insert(EmpLabel empLabel) {
		return empLabelDAO.insert(empLabel);
	}

	@Override
	public List<EmpLabelResult> selectByUserId(String departmentId, String cnName) {
		return empLabelDAO.selectByUserId(departmentId, cnName);
	}

}
