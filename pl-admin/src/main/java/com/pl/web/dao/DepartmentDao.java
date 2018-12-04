package com.pl.web.dao;

import com.pl.web.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepartmentDao {
    public List<Department> getDepartments(@Param("userid")Long userid);
}
