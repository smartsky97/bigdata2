package com.pl.web.service.impl;

import com.pl.web.dao.ILableTargetDao;
import com.pl.web.model.Emp_Lable_target;
import com.pl.web.service.ILablesTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签计算结果指标Service层实现类
 * @author root
 *
 */
@Service
public class LablesTargetServiceIMP implements ILablesTargetService {

	@Autowired
	private ILableTargetDao iLableTargetDao;
	
	/**
	 * 删除标签计算结果指标
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteLableTargetById(int id) {
		
		int id1=this.iLableTargetDao.deleteLableTargetById(id);
		if(id1>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 添加标签计算结果指标
	 * @param labletarget
	 * @return
	 */

	@Override
	public boolean add(Emp_Lable_target labletarget) {
		// TODO Auto-generated method stub
		int lable=this.iLableTargetDao.add(labletarget);
				if(lable>0){
					return true;
				}else{
					return false;
				}
	}
	
	/**
	 * 根据标签ID查询所有此ID的计算指标
	 * @param id
	 * @return
	 */

	@Override
	public List<Emp_Lable_target> getLablesTargetById(int id) {
		return this.iLableTargetDao.getLablesTargetById(id);
	}

	/**
	 * 根据指标ID查询这个指标
	 * @param id
	 * @return
	 */
	@Override
	public Emp_Lable_target selectLableTargetById(int id) {
		
		return this.iLableTargetDao.selectLableTargetById(id);
	}

	/**
	 * 更新标签计算结果指标
	 * @param elt
	 * @return
	 */
	@Override
	public boolean updateLableTarget(Emp_Lable_target elt) {
		// TODO Auto-generated method stub
		int elt1=this.iLableTargetDao.updateLableTarget(elt);
		if(elt1>0){
			return true;
		}else{
			return false;
		}
	}

}
