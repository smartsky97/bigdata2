package com.pl.web.dao;

import com.pl.web.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getEmps(String department_id);
}
