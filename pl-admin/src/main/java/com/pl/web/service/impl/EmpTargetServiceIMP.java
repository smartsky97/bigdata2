package com.pl.web.service.impl;

import com.pl.web.dao.EmpTargetDAO;
import com.pl.web.model.EmpTarget;
import com.pl.web.service.IEmpTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpTargetServiceIMP implements IEmpTargetService {
    @Autowired
	private EmpTargetDAO empTargetDAO;

	@Override
	public List<EmpTarget> queryById(String tag_id) {
		return empTargetDAO.queryById(tag_id);
	}
	
	

}
