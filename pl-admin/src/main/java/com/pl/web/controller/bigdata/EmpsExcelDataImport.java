package com.pl.web.controller.bigdata;

import com.pl.web.dto.EmpsApproval;
import com.pl.web.task.ReadExcel;
import com.pl.web.util.Common;
import com.pl.web.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class EmpsExcelDataImport extends HttpServlet{

	/**
	 * 员工审批流程数据导入Mysql.
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		String message ="";
		String date = request.getParameter("month");
		System.out.println("日期---------:"+date);
		ReadExcel xlsMain = new ReadExcel();
		EmpsApproval empsApproval = null;
		List<EmpsApproval> list = xlsMain.readXlsEmps(date);
		int i;
		for ( i = 0; i < list.size(); i++) {
			empsApproval = list.get(i);
			try {
					DbUtil.insertEmps2Mysql(Common.INSERT_Employee_SQL, empsApproval);
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
		}
		if (i!=list.size()) {
			message ="Import Data Failed!";
		} else {
			message ="Import Data Success!";
			File file = new File(Common.EXCEL_PATH_Emp);
				if(file.isFile() && file.exists()){
					file.delete();
				}
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
			doGet(request, response);
	}
}
