package com.pl.web.service.impl;

import com.pl.web.dao.LabelTargetDAO;
import com.pl.web.model.LabelTarget;
import com.pl.web.service.ILabelTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LabelTargetServiceIMP implements ILabelTargetService {
    
	@Autowired
	private LabelTargetDAO labelTargetDAO;
	
	@Override
	public List<LabelTarget> queryAll() {
		return labelTargetDAO.queryAll();
	}
	
}
