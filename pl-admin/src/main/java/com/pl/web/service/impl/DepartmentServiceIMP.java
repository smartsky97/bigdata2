package com.pl.web.service.impl;

import com.pl.web.dao.DepartmentDao;
import com.pl.web.model.Department;
import com.pl.web.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceIMP implements DepartmentService {
	@Autowired
    private DepartmentDao departmentDao;
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return this.departmentDao.getDepartments();
	}

}
