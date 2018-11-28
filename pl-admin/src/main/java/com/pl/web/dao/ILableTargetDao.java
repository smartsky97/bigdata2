package com.pl.web.dao;

import com.pl.web.model.Emp_Lable_target;

import java.util.List;

/**
 * 标签计算结果指标Dao层接口类
 * @author luoly
 *
 */
public interface ILableTargetDao {
	//删除计算指标
	public int deleteLableTargetById(int id);
	//添加计算指标
	public int add(Emp_Lable_target labletarget);
	//根据标签ID查询所有此ID的计算指标
	public List<Emp_Lable_target> getLablesTargetById(int id);
	//根据指标ID查询这个指标
	public Emp_Lable_target selectLableTargetById(int id);
	//更新计算指标
	public int updateLableTarget(Emp_Lable_target elt);
}
