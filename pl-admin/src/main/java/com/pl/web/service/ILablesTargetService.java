package com.pl.web.service;

import com.pl.web.model.Emp_Lable_target;

import java.util.List;

/**
 * 标签计算结果指标Service层接口类
 * @author root
 *
 */
public interface ILablesTargetService {
	/**
	 * 删除标签计算结果指标
	 * @param id
	 * @return
	 */
	public boolean deleteLableTargetById(int id);
	/**
	 * 添加标签计算结果指标
	 * @param labletarget
	 * @return
	 */
	public boolean add(Emp_Lable_target labletarget);
	/**
	 * 根据标签ID查询所有此ID的计算指标
	 * @param id
	 * @return
	 */
	public List<Emp_Lable_target> getLablesTargetById(int id);
	/**
	 * 根据指标ID查询这个指标
	 * @param id
	 * @return
	 */
	public Emp_Lable_target selectLableTargetById(int id);
	/**
	 * 更新标签计算结果指标
	 * @param elt
	 * @return
	 */
	public boolean updateLableTarget(Emp_Lable_target elt);
}
