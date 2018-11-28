package com.pl.web.service.impl;

import com.pl.web.dao.EmpQualityResultDAO;
import com.pl.web.model.EmpQualityResult;
import com.pl.web.model.QualityResultPage;
import com.pl.web.service.IEmpQualityResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpQualityResultImpl implements IEmpQualityResultService {
	
	@Autowired
	private EmpQualityResultDAO empQualityResultDAO;
	
	@Override
	public int insert(EmpQualityResult empQualityResult) {
		return empQualityResultDAO.insert(empQualityResult);
	}

	@Override
	public List<EmpQualityResult> selectAll() {
		return empQualityResultDAO.selectAll();
	}

	@Override
	public int updateResult(EmpQualityResult empQualityResult) {
		return empQualityResultDAO.updateResult(empQualityResult);
	}

	@Override
	public List<QualityResultPage> select(String computeDate, String department_id, Integer index, Integer length) {
		// TODO Auto-generated method stub
		return empQualityResultDAO.select(computeDate,department_id,index,length);
	}

	@Override
	public int resultCount(String computeDate, String department_id, Integer index, Integer length) {
		// TODO Auto-generated method stub
		return empQualityResultDAO.resultCount(computeDate,department_id,index,length);
	}
}
