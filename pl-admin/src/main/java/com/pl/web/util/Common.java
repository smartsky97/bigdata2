/**
 * 
 */
package com.pl.web.util;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class Common {

	// connect the database
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_NAME = "hyn_profile";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "hyn12345";
	public static final String IP = "192.168.0.79";
	public static final String PORT = "3306";
	public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME;
	// common
	public static final String EXCEL_PATH_Dept = "/mnt/share/department.xls";
	public static final String EXCEL_PATH_Emp = "/mnt/share/employee.xls";
	// sql
	public static final String INSERT_Department_SQL = "insert into department_approval(department, approval_times, approval_efficiency, date) values(?, ?, ?, ?)";
	public static final String SELECT_STUDENT_ALL_SQL = "select id,no,name,age,score from student_info";
	public static final String SELECT_Department_SQL = "select * from department_approval where department like ";
	public static final String INSERT_Employee_SQL ="insert into employee_approval(approval_times,approval_efficiency,mail_name,date) values(?, ?, ?, ?)";
	public static final String SELECT_Employee_SQL ="select * from employee_approval where mail_name like ";
}
