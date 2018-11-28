/**
 * 
 */
package com.pl.web.task;

import com.pl.web.dto.DeptsApproval;
import com.pl.web.dto.EmpsApproval;
import com.pl.web.util.Common;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Hongten
 * @created 2014-5-18
 */
public class ReadExcel {
	/**
	 * 读取部门Excel表格数据.
	 * @param date
	 * @return
	 * @throws IOException
	 */
	public List<DeptsApproval> readXls(String date) throws IOException {
		InputStream is = new FileInputStream(Common.EXCEL_PATH_Dept);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		DeptsApproval deptsApproval = null;
		List<DeptsApproval> list = new ArrayList<DeptsApproval>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					deptsApproval = new DeptsApproval();
					HSSFCell department = hssfRow.getCell(1);
					HSSFCell approvalTimes = hssfRow.getCell(2);
					HSSFCell approvalEfficiency = hssfRow.getCell(3);
					deptsApproval.setDepartment(getValue(department));
					deptsApproval.setApprovalTimes(Integer.valueOf(getValue(approvalTimes)));
					deptsApproval.setApprovalEfficiency(Double.valueOf(getValue(approvalEfficiency)));
					deptsApproval.setDate(date);
					list.add(deptsApproval);
				}
			}
		}
		return list;
	}
	
	/**
	 * 读取员工Excel表格数据.
	 * @param date
	 * @return
	 * @throws IOException
	 */
	public List<EmpsApproval> readXlsEmps(String date) throws IOException {
		InputStream is = new FileInputStream(Common.EXCEL_PATH_Emp);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		EmpsApproval empsApproval = null;
		List<EmpsApproval> list1 = new ArrayList<EmpsApproval>();
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					empsApproval = new EmpsApproval();
					HSSFCell employee = hssfRow.getCell(1);
					HSSFCell approvalTimes = hssfRow.getCell(2);
					HSSFCell approvalEfficiency = hssfRow.getCell(3);
					empsApproval.setCnName(getValue(employee));
					empsApproval.setApprovalTimes(Integer.valueOf(getValue(approvalTimes)));
					empsApproval.setApprovalEfficiency(Double.valueOf(getValue(approvalEfficiency)));
					empsApproval.setDate(date);
					list1.add(empsApproval);
				}
			}
		}
		return list1;
	}
	
	
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
	        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	            // 返回布尔类型的值
	            return String.valueOf(hssfCell.getBooleanCellValue());
	        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	            // 返回数值类型的值
	            return String.valueOf(hssfCell.getNumericCellValue());
	        } else {
	            // 返回字符串类型的值
	            return String.valueOf(hssfCell.getStringCellValue());
	        }
	    }
}
