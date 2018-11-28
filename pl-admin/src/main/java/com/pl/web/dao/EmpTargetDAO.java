package com.pl.web.dao;

import com.pl.web.model.EmpTarget;

import java.util.List;


/**
 * �û�ָ���DAO
 * @author root
 *
 */
public interface EmpTargetDAO {
	List<EmpTarget> queryById(String tag_id);
}
