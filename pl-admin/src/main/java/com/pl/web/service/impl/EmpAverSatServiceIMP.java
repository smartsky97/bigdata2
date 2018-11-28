package com.pl.web.service.impl;

import com.pl.web.dao.EmpAverSatDao;
import com.pl.web.dto.EmpAverSat;
import com.pl.web.service.EmpAverSatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpAverSatServiceIMP implements EmpAverSatService {
	
	@Autowired
	private EmpAverSatDao empAverSatDao;

/*................A方法计算结果展示(8:30-17:30)...................*/
	
	@Override
	public List<EmpAverSat> getEmpAverSats(String mailname, String startime,
										   String endtime) {
		
		return this.empAverSatDao.getEmpAverSats(mailname, startime, endtime);
	}

	@Override
	public List<EmpAverSat> searchEmpAverSats(String department,String mailname, String startime,
			String endtime) {
		// TODO Auto-generated method stub
		return this.empAverSatDao.searchEmpAverSats(department,mailname, startime, endtime);
	}


/*................B方法计算结果展示(全天)..........................*/

	@Override
	public List<EmpAverSat> getEmpAverSats_B(String mailname, String startime,
			String endtime) {
		// TODO Auto-generated method stub
		return this.empAverSatDao.getEmpAverSats_B(mailname, startime, endtime);
	}

	@Override
	public List<EmpAverSat> searchEmpAverSats_B(String department,
			String mailname, String startime, String endtime) {
		// TODO Auto-generated method stub
		return this.empAverSatDao.SearchEmpAverSats_B(department, mailname, startime, endtime);
	}

	
	

}
