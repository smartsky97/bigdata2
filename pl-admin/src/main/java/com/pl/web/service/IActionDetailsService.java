package com.pl.web.service;

import com.pl.web.model.ActionDetails;

import java.util.List;

/**
 * 员工工作详细信息Service接口层
 * @author root
 *
 */
public interface IActionDetailsService {
	/*
	 * 查询详细信息
	 */
	public List<ActionDetails> getDetails(String mailname, String date);

}
