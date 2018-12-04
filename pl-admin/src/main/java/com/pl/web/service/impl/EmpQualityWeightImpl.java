package com.pl.web.service.impl;

import com.pl.web.dao.IEmpQualityWeightMapper;
import com.pl.web.dto.EmpQualitySaturability;
import com.pl.web.dto.EmpTartgetQuality;
import com.pl.web.model.EmpQualityWeight;
import com.pl.web.service.IEmpQualityWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpQualityWeightImpl implements IEmpQualityWeightService {
	
	@Autowired
	private IEmpQualityWeightMapper empQualityWeightDAO;
	
	@Override
	public int insert(EmpQualityWeight empQualityWeight) {
		return this.empQualityWeightDAO.insert(empQualityWeight);
	}

	@Override
	public List<EmpTartgetQuality> selectData(String mailName , String compute_date) {
		return empQualityWeightDAO.selectData( mailName, compute_date);
	}

	

	@Override
	public List<EmpQualityWeight> list() {
		return empQualityWeightDAO.list();
	}

	@Override
	public List<EmpQualitySaturability> selectSaturab(String mailName , String startime, String endTime) {
		return empQualityWeightDAO.selectSaturab( mailName, startime,endTime );
	}

	

	@Override
	public int getSerachDataSize() {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.getSerachDataSize();
	}

	@Override
	public List<EmpQualityWeight> pageShow(String departmentId, String startime, String endTime,Long userid) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.pageShow(departmentId,startime, endTime,userid);
	}

	@Override
	public int resultCount(String departmentId, String starTime, String endTime) {
		return empQualityWeightDAO.resultCount(departmentId, starTime, endTime);
	}

	@Override
	public EmpQualityWeight getById(int id) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.getById(id);
	}

	@Override
	public int update(EmpQualityWeight empQualityWeight) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.update(empQualityWeight);
	}

	@Override
	public List<EmpTartgetQuality> selectDaByDept(String mailName, String departmentId, String compute_date) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.selectDaByDept(mailName, departmentId, compute_date);
	}

	@Override
	public List<EmpQualitySaturability> selectSaturabByDept(String mailName, String departmentId, String starTime,
			String endTime) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.selectSaturabByDept(mailName, departmentId, starTime , endTime);
	}

	@Override
	public List<EmpTartgetQuality> selectDaByDeptAvg(String mailName, String departmentId, String compute_date) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.selectDaByDeptAvg(mailName, departmentId, compute_date);
	}

	@Override
	public List<EmpQualitySaturability> selectSaturabByDeptAvg(String mailName, String departmentId, String starTime,
			String endTime) {
		// TODO Auto-generated method stub
		return empQualityWeightDAO.selectSaturabByDeptAvg(mailName, departmentId, starTime , endTime);
	}
}
