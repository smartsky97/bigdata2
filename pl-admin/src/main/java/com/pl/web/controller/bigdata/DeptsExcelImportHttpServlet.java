package com.pl.web.controller.bigdata;

import com.pl.web.dto.DeptsApproval;
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


/**
 * Excel数据读取存入Mysql数据库.
 * 部门工作流程效率/流程量统计数据.
 * @author root
 *
 */
public class DeptsExcelImportHttpServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		String message ="";
		String date = request.getParameter("month");
		System.out.println("日期---------:"+date);
		ReadExcel xlsMain = new ReadExcel();
		DeptsApproval deptsApproval = null;
		List<DeptsApproval> list = xlsMain.readXls(date);
		int i ;
		for (i=0;i < list.size(); i++) {
			deptsApproval = list.get(i);
			try {
					DbUtil.insert(Common.INSERT_Department_SQL, deptsApproval);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if (i!=list.size()) {
			message="Import Excel Data Failed !";
		} else {
			message="Import Excel Data Success!";
			File file =new File(Common.EXCEL_PATH_Dept);
			if(file.isFile() && file.exists()){
				file.delete();
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
		
		/*SaveData2DB saveData2DB =new SaveData2DB();
		try {
			saveData2DB.save(date);
			message ="导入数据成功";
			System.out.println("成功导入数据完毕!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message ="导入数据失败";
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		try {
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request, response);
	}

}
