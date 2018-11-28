package com.pl.web.service.impl;

import com.pl.web.dao.Depart_kaoqinMapper;
import com.pl.web.model.Depart_kaoqin;
import com.pl.web.service.DeptKaoQinServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptKaoQinServicceIMP implements DeptKaoQinServicce {
	
	@Autowired
	private Depart_kaoqinMapper depart_kaoqinMapper;
	
	@Override
	public List<Depart_kaoqin> findAll(int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.depart_kaoqinMapper.findAll(fromIndex, pageSize);
	}

	@Override
	public int getAllDataSize() {
		// TODO Auto-generated method stub
		return this.depart_kaoqinMapper.getAllDataSize();
	}

	@Override
	public List<Depart_kaoqin> searchDekp(String department, String time,
			int fromIndex, int pageSize) {
		// TODO Auto-generated method stub
		return this.depart_kaoqinMapper.searchDekq(department, time, fromIndex, pageSize);
	}

	@Override
	public int getSerarchSize(String department, String time) {
		// TODO Auto-generated method stub
		return this.depart_kaoqinMapper.getSearchSize(department, time);
	}

	@Override
	public List<Depart_kaoqin> getDepart_kaoqin2CSv(String department,
			String time) {
		// TODO Auto-generated method stub
		return this.depart_kaoqinMapper.getDeKaoqins2CSV(department, time);
	}

}
