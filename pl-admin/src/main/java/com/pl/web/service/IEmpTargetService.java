package com.pl.web.service;

import com.pl.web.model.EmpTarget;

import java.util.List;


public interface IEmpTargetService {
	List<EmpTarget> queryById(String tag_id);
}
