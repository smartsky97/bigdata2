package com.pl.web.service;

import com.pl.web.model.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getEmps(String department_id);
}
