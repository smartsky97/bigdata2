/**
 * 
 */
package com.pl.web.task;

import com.pl.web.dto.DeptsApproval;
import com.pl.web.util.Common;
import com.pl.web.util.DbUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



/**
 * @author Hongten
 * @created 2014-5-18
 */
public class SaveData2DB {

	@SuppressWarnings({ "rawtypes" })
	public void save(String date) throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
		DeptsApproval deptsApproval = null;
		List<DeptsApproval> list = xlsMain.readXls(date);

		for (int i = 0; i < list.size(); i++) {
			deptsApproval = list.get(i);
			List l = DbUtil.selectOne(Common.SELECT_Department_SQL + "'%" + deptsApproval.getDepartment() + "%'", deptsApproval);
			if (!l.contains(1)) {
				DbUtil.insert(Common.INSERT_Department_SQL, deptsApproval);
			} else {
				System.out.println("The Record was Exist : Department. = "+ deptsApproval.getDepartment() + " , ApprovalTimes = " + deptsApproval.getApprovalTimes() + ", ApprovalEfficiency = " 
						+ deptsApproval.getApprovalEfficiency()+",Date="+deptsApproval.getDate()+ ", and has been throw away!");
			}
		}
	}
}
