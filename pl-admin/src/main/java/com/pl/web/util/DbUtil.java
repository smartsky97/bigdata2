/**
 * 
 */
package com.pl.web.util;

import com.pl.web.dto.DeptsApproval;
import com.pl.web.dto.EmpsApproval;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Hongten
 * @created 2014-5-18
 */
public class DbUtil {

	/**
	 * 部门Excel数据插入
	 * @param sql
	 */
	public static void insert(String sql, DeptsApproval deptsApproval) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, deptsApproval.getDepartment());
			ps.setString(2, String.valueOf(deptsApproval.getApprovalTimes()));
			ps.setString(3, String.valueOf(deptsApproval.getApprovalEfficiency()));
			ps.setString(4, deptsApproval.getDate());
			boolean flag = ps.execute();
			if(!flag){
				System.out.println("Save data : Department. = " + deptsApproval.getDepartment() + " , ApprovalTimes = " + deptsApproval.getApprovalTimes() + ", ApprovalEfficiency = " 
			+ deptsApproval.getApprovalEfficiency()+",Date="+deptsApproval.getDate()+ " succeed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	/**
	 * 数据插入之前的验证(检验数据是否重复)
	 * @param sql
	 * @param deptsApproval
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List selectOne(String sql, DeptsApproval deptsApproval) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("department").equals(deptsApproval.getDepartment()) || rs.getString("approval_times").equals(deptsApproval.getApprovalTimes())|| 
						rs.getString("approval_efficiency").equals(deptsApproval.getApprovalEfficiency())|| rs.getString("date").equals(deptsApproval.getDate())){
					list.add(1);
				}else{
					list.add(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
	
	/**
	 * 员工Excel数据插入.
	 * @param sql
	 * @param empsApproval
	 * @throws SQLException
	 */
	public static void insertEmps2Mysql(String sql, EmpsApproval empsApproval) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(empsApproval.getApprovalTimes()));
			ps.setString(2, String.valueOf(empsApproval.getApprovalEfficiency()));
			ps.setString(3, empsApproval.getCnName());
			ps.setString(4, empsApproval.getDate());
			boolean flag = ps.execute();
			if(!flag){
				System.out.println("Save data : CnName. = " + empsApproval.getCnName() + " , ApprovalTimes = " + empsApproval.getApprovalTimes() + ", ApprovalEfficiency = " 
			+ empsApproval.getApprovalEfficiency()+",Date="+empsApproval.getDate()+ " succeed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List selectEmpsData(String sql, EmpsApproval empsApproval) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("mail_name").equals(empsApproval.getCnName()) || rs.getString("approval_times").equals(empsApproval.getApprovalTimes())|| 
						rs.getString("approval_efficiency").equals(empsApproval.getApprovalEfficiency())|| rs.getString("date").equals(empsApproval.getDate())){
					list.add(1);
				}else{
					list.add(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
	

}
