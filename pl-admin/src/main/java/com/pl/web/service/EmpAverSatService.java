package com.pl.web.service;

import com.pl.web.dto.EmpAverSat;

import java.util.List;


public interface EmpAverSatService {
	
	//A方案计算结果
	public List<EmpAverSat> getEmpAverSats(String mailname, String startime, String endtime);
	public List<EmpAverSat> searchEmpAverSats(String department, String mailname, String startime, String endtime);
	
	//B方案计算结果
	public List<EmpAverSat> getEmpAverSats_B(String mailname, String startime, String endtime);
	public List<EmpAverSat> searchEmpAverSats_B(String department, String mailname, String startime, String endtime);
}