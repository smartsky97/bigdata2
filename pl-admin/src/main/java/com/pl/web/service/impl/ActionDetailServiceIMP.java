package com.pl.web.service.impl;

import com.pl.web.dao.IActionDetailsDao;
import com.pl.web.model.ActionDetails;
import com.pl.web.service.IActionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户工作详情ServiceIMP层.
 * @author lh
 * 
 *
 */
@Service
public class ActionDetailServiceIMP implements IActionDetailsService {
	/*
	 * 用户工作详情dao层注入.
	 */
	@Autowired
	private IActionDetailsDao iActionDetailsDao;
	/*
	 * 工作详情查询(用户名,时间)
	 */
	@Override
	public List<ActionDetails> getDetails(String mailname, String date) {
		// TODO Auto-generated method stub
		return this.iActionDetailsDao.geDetails(mailname, date);
	}

}
