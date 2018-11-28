package com.pl.web.service.impl;

import com.pl.web.dao.EmpsKaoQinMapper;
import com.pl.web.model.EmpsKaoQin;
import com.pl.web.service.EmpsKaoQinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpsKaoQinServiceIMP implements EmpsKaoQinService {
	
	@Autowired
	private EmpsKaoQinMapper empsKaoQinMapper;
	@Override
	public List<EmpsKaoQin> findAll(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.empsKaoQinMapper.findAll(fromIndex, pageSize);
	}

	@Override
	public int getAllDataSize() {
		// TODO Auto-generated method stub
		return this.empsKaoQinMapper.getAllDataSize();
	}

	@Override
	public List<EmpsKaoQin> searchEmpKaoQin(String department, String mailname,
			String time, int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.empsKaoQinMapper.searchEmpKaoQin(department, mailname, time, fromIndex, pageSize);
	}
	
	@Override
	public int getSearchSize(String department, String mailname, String time) {
		// TODO Auto-generated method stub
		return this.empsKaoQinMapper.getSearchSize(department, mailname, time);
	}

	@Override
	public List<EmpsKaoQin> getEmpsKaoQin2CSV(String department,String mailname, String time) {
		// TODO Auto-generated method stub
		return this.empsKaoQinMapper.getEmpsKaoQins2CSV(department, mailname, time);
	}

}
