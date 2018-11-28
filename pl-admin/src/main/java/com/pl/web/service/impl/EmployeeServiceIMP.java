package com.pl.web.service.impl;

import com.pl.web.dao.EmployeeDao;
import com.pl.web.model.Employee;
import com.pl.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMP implements EmployeeService {
	@Autowired
    private EmployeeDao employeeDao;
	@Override
	public List<Employee> getEmps(String department_id) {
		// TODO Auto-generated method stub
		return this.employeeDao.getEmps(department_id);
	}

}
