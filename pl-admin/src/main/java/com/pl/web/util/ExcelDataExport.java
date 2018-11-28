package com.pl.web.util;

import java.util.ArrayList;
import java.util.List;

import com.pl.web.dto.JobDataAll;
import com.pl.web.model.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/*
 * 页面查询数据导出Excel文件.
 */
public class ExcelDataExport {

	/*
	 * 饱和度加法导出Excel
	 */
	public static HSSFWorkbook exportAdd(List<JobSatAdd> jobAdds,
			String fileName) {
		List<String> excelHeader = new ArrayList<String>();
		if (fileName.contains("工作饱和度")) {
			excelHeader.add("员工");
			excelHeader.add("饱和度(%)");
			excelHeader.add("日期");
			// "员工","饱和度(%)","日期";
		} else {
			excelHeader.add("员工");
			excelHeader.add("饱和度(%)");
			excelHeader.add("日期");
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		// 创建表头
		for (int i = 0; i < excelHeader.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(excelHeader.get(i)));
			sheet.autoSizeColumn(i);
		}
		if (fileName.contains("工作饱和度")) {
			for (int i = 0; i < jobAdds.size(); i++) {
				row = sheet.createRow(i + 1);
				JobSatAdd jobAdd = jobAdds.get(i);
				row.createCell(0).setCellValue(jobAdd.getMailname());
				row.createCell(1).setCellValue(jobAdd.getSaturability());
				row.createCell(2).setCellValue(jobAdd.getDate());
			}
		} else {
			for (int i = 0; i < jobAdds.size(); i++) {
				row = sheet.createRow(i + 1);
				JobSatAdd jobDown = jobAdds.get(i);
				row.createCell(0).setCellValue(jobDown.getMailname());
				row.createCell(1).setCellValue(jobDown.getSaturability());
				row.createCell(2).setCellValue(jobDown.getDate());
			}
		}
		return wb;
	}

	// 饱和度减法 Excel
	public static HSSFWorkbook exportDown(List<JobSatDown> jobDowns,
			String fileName) {
		List<String> excelHeader = new ArrayList<String>();
		if (fileName.contains("工作饱和度")) {
			excelHeader.add("员工");
			excelHeader.add("饱和度(%)");
			excelHeader.add("日期");
			// "员工","饱和度(%)","日期";
		} else if ("部门考勤".equals(fileName)) {
			excelHeader.add("部门");
			excelHeader.add("考勤率");
			excelHeader.add("考勤天数");
			excelHeader.add("日期");
			// "部门","考勤率","考勤天数","日期";
		} else if ("员工考勤".equals(fileName)) {
			excelHeader.add("姓名");
			excelHeader.add("考勤率");
			excelHeader.add("考勤天数");
			excelHeader.add("部门");
			excelHeader.add("日期");
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		// 创建表头
		for (int i = 0; i < excelHeader.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(excelHeader.get(i)));
			sheet.autoSizeColumn(i);
		}
		if (fileName.contains("工作饱和度")) {
			for (int i = 0; i < jobDowns.size(); i++) {
				row = sheet.createRow(i + 1);
				JobSatDown jobDown = jobDowns.get(i);
				row.createCell(0).setCellValue(jobDown.getMailname());
				row.createCell(1).setCellValue(jobDown.getSaturability());
				row.createCell(2).setCellValue(jobDown.getDate());
			}
		} else {
			for (int i = 0; i < jobDowns.size(); i++) {
				row = sheet.createRow(i + 1);
				JobSatDown jobDown = jobDowns.get(i);
				row.createCell(0).setCellValue(jobDown.getMailname());
				row.createCell(1).setCellValue(jobDown.getSaturability());
				row.createCell(2).setCellValue(jobDown.getDate());
			}
		}
		return wb;
	}

	// 部门考勤
	public static HSSFWorkbook expotDeptsKaoQin(
			List<Depart_kaoqin> depart_kaoqins, String fileName) {
		List<String> excelHeader = new ArrayList<String>();
		if ("部门考勤".equals(fileName)) {
			excelHeader.add("部门");
			excelHeader.add("考勤率");
			excelHeader.add("考勤天数");
			excelHeader.add("日期");
			// "部门","考勤率","考勤天数","日期";
		} else {
			excelHeader.add("部门");
			excelHeader.add("考勤率");
			excelHeader.add("考勤天数");
			excelHeader.add("日期");
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		// 创建表头
		for (int i = 0; i < excelHeader.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(excelHeader.get(i)));
			sheet.autoSizeColumn(i);
		}
		if (fileName.contains("部门考勤")) {
			for (int i = 0; i < depart_kaoqins.size(); i++) {
				row = sheet.createRow(i + 1);
				Depart_kaoqin depart_kaoqin = depart_kaoqins.get(i);
				row.createCell(0).setCellValue(depart_kaoqin.getDepartment());
				row.createCell(1).setCellValue(
						depart_kaoqin.getDepartAttendance());
				row.createCell(2).setCellValue(
						depart_kaoqin.getAttendanceDays());
				row.createCell(3).setCellValue(depart_kaoqin.getDate());
			}
		} else {
			for (int i = 0; i < depart_kaoqins.size(); i++) {
				row = sheet.createRow(i + 1);
				Depart_kaoqin depart_kaoqin = depart_kaoqins.get(i);
				row.createCell(0).setCellValue(depart_kaoqin.getDepartment());
				row.createCell(1).setCellValue(
						depart_kaoqin.getDepartAttendance());
				row.createCell(2).setCellValue(
						depart_kaoqin.getAttendanceDays());
				row.createCell(3).setCellValue(depart_kaoqin.getDate());
			}
		}
		return wb;
	}

	/*
	 * 员工考勤导出Excel
	 */
	public static HSSFWorkbook exportEmpsKaoQin(List<EmpsKaoQin> empsKaoQins,
			String fileName) {
		List<String> excelHeader = new ArrayList<String>();
		if ("员工考勤".equals(fileName)) {
			excelHeader.add("姓名");
			excelHeader.add("部门");
			excelHeader.add("考勤率");
			excelHeader.add("考勤天数");
			excelHeader.add("日期");
			// "部门","考勤率","考勤天数","日期";
		} else {
			excelHeader.add("姓名");
			excelHeader.add("部门");
			excelHeader.add("考勤率");
			excelHeader.add("考勤天数");
			excelHeader.add("日期");
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		// 创建表头
		for (int i = 0; i < excelHeader.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(excelHeader.get(i)));
			sheet.autoSizeColumn(i);
		}
		if (fileName.contains("员工考勤")) {
			for (int i = 0; i < empsKaoQins.size(); i++) {
				row = sheet.createRow(i + 1);
				EmpsKaoQin empsKaoQin = empsKaoQins.get(i);
				row.createCell(0).setCellValue(empsKaoQin.getCnName());
				row.createCell(1).setCellValue(empsKaoQin.getDepartment());
				row.createCell(2).setCellValue(empsKaoQin.getPerAttendance());
				row.createCell(3).setCellValue(empsKaoQin.getAttendanceDays());
				row.createCell(4).setCellValue(empsKaoQin.getDate());
			}
		} else {
			for (int i = 0; i < empsKaoQins.size(); i++) {
				row = sheet.createRow(i + 1);
				EmpsKaoQin empsKaoQin = empsKaoQins.get(i);
				row.createCell(0).setCellValue(empsKaoQin.getCnName());
				row.createCell(1).setCellValue(empsKaoQin.getDepartment());
				row.createCell(2).setCellValue(empsKaoQin.getPerAttendance());
				row.createCell(3).setCellValue(empsKaoQin.getAttendanceDays());
				row.createCell(4).setCellValue(empsKaoQin.getDate());
			}
		}
		return wb;
	}

	public static HSSFWorkbook exportMonthAdd(
            List<Month_saturation_collection_a> monthListJobAdd, String fileName) {
		List<String> excelHeader = new ArrayList<String>();
		if (fileName.contains("月度计算工作饱和度加法")) {
			excelHeader.add("员工");
			excelHeader.add("饱和度(%)");
			excelHeader.add("日期");
			// "员工","饱和度(%)","日期";
		} else {
			excelHeader.add("员工");
			excelHeader.add("饱和度(%)");
			excelHeader.add("日期");
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		// 创建表头
		for (int i = 0; i < excelHeader.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(excelHeader.get(i)));
			sheet.autoSizeColumn(i);
		}
		if (fileName.contains("工作饱和度")) {
			for (int i = 0; i < monthListJobAdd.size(); i++) {
				row = sheet.createRow(i + 1);
				Month_saturation_collection_a jobAdd = monthListJobAdd.get(i);
				row.createCell(0).setCellValue(jobAdd.getMailname());
				row.createCell(1).setCellValue(jobAdd.getSaturability());
				row.createCell(2).setCellValue(jobAdd.getDate());
			}
		} else {
			for (int i = 0; i < monthListJobAdd.size(); i++) {
				row = sheet.createRow(i + 1);
				Month_saturation_collection_a jobDown = monthListJobAdd.get(i);
				row.createCell(0).setCellValue(jobDown.getMailname());
				row.createCell(1).setCellValue(jobDown.getSaturability());
				row.createCell(2).setCellValue(jobDown.getDate());
			}
		}
		return wb;
	}

	public static HSSFWorkbook exportJiTuanData(List<JobDataAll> dataAll,
			String fileName) {
		List<String> excelHeader = new ArrayList<String>();
		if (fileName.contains("集团工作指标数据")) {
			excelHeader.add("姓名");
			excelHeader.add("日期");
			excelHeader.add("饱和度加法A(8:30-17:30)");
			excelHeader.add("非工作占比");
			excelHeader.add("迟到次数");
			excelHeader.add("早退次数");
			excelHeader.add("邮件次数");
			excelHeader.add("Lync通信次数");
			excelHeader.add("Ip电话次数");
			excelHeader.add("考勤次数");
			excelHeader.add("考勤率");
			excelHeader.add("考勤时长(单位/H)");
			excelHeader.add("迟到时长(单位/S)");
			excelHeader.add("早退时长(单位/S)");
			excelHeader.add("IP电话时长(单位/S)");
			excelHeader.add("会议时长(单位/H)");
			excelHeader.add("鼠标点击量");
			excelHeader.add("键盘敲击量");
			excelHeader.add("文件量");
			// "员工","饱和度(%)","日期";
		} else {
			excelHeader.add("姓名");
			excelHeader.add("日期");
			excelHeader.add("饱和度加法A(8:30-17:30)");
			excelHeader.add("非工作占比");
			excelHeader.add("迟到次数");
			excelHeader.add("早退次数");
			excelHeader.add("邮件次数");
			excelHeader.add("Lync通信次数");
			excelHeader.add("Ip电话次数");
			excelHeader.add("考勤次数");
			excelHeader.add("考勤率");
			excelHeader.add("考勤时长(单位/H)");
			excelHeader.add("迟到时长(单位/S)");
			excelHeader.add("早退时长(单位/S)");
			excelHeader.add("IP电话时长(单位/S)");
			excelHeader.add("会议时长(单位/H)");
			excelHeader.add("鼠标点击量");
			excelHeader.add("键盘敲击量");
			excelHeader.add("文件量");
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		// 创建表头
		for (int i = 0; i < excelHeader.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(excelHeader.get(i)));
			sheet.autoSizeColumn(i);
		}
		if (fileName.contains("集团工作指标数据")) {
			for (int i = 0; i < dataAll.size(); i++) {
				row = sheet.createRow(i + 1);
				JobDataAll allData = dataAll.get(i);
				row.createCell(0).setCellValue(allData.getCn_name());
				row.createCell(1).setCellValue(allData.getMonth());
				row.createCell(2).setCellValue(allData.getSaturabilityA());
				row.createCell(3).setCellValue(allData.getNo_worklv());
				row.createCell(4).setCellValue(allData.getChidaoTimes());
				row.createCell(5).setCellValue(allData.getZaoTuiTimes());
				row.createCell(6).setCellValue(allData.getEmailTimes());
				row.createCell(7).setCellValue(allData.getLyncTimes());
				row.createCell(8).setCellValue(allData.getIpPhoneTimes());
				row.createCell(9).setCellValue(allData.getKaoqinTimes());
				row.createCell(10).setCellValue(allData.getKaoqinlv());
				row.createCell(11).setCellValue(allData.getKaoqinLength());
				row.createCell(12).setCellValue(allData.getChidaoLength());
				row.createCell(13).setCellValue(allData.getZaotuiLength());
				row.createCell(14).setCellValue(allData.getIpPhoneLength());
				row.createCell(15).setCellValue(allData.getMeetingTime());
				row.createCell(16).setCellValue(allData.getMouse_click());
				row.createCell(17).setCellValue(allData.getKey_press());
				row.createCell(18).setCellValue(allData.getFileAppend());
			}
		} else {
			for (int i = 0; i < dataAll.size(); i++) {
				row = sheet.createRow(i + 1);
				JobDataAll allData = dataAll.get(i);
				row.createCell(0).setCellValue(allData.getCn_name());
				row.createCell(1).setCellValue(allData.getMonth());
				row.createCell(2).setCellValue(allData.getSaturabilityA());
				row.createCell(3).setCellValue(allData.getNo_worklv());
				row.createCell(4).setCellValue(allData.getChidaoTimes());
				row.createCell(5).setCellValue(allData.getZaoTuiTimes());
				row.createCell(6).setCellValue(allData.getEmailTimes());
				row.createCell(7).setCellValue(allData.getLyncTimes());
				row.createCell(8).setCellValue(allData.getIpPhoneTimes());
				row.createCell(9).setCellValue(allData.getKaoqinTimes());
				row.createCell(10).setCellValue(allData.getKaoqinlv());
				row.createCell(11).setCellValue(allData.getKaoqinLength());
				row.createCell(12).setCellValue(allData.getChidaoLength());
				row.createCell(13).setCellValue(allData.getZaotuiLength());
				row.createCell(14).setCellValue(allData.getIpPhoneLength());
				row.createCell(15).setCellValue(allData.getMeetingTime());
				row.createCell(16).setCellValue(allData.getMouse_click());
				row.createCell(17).setCellValue(allData.getKey_press());
				row.createCell(18).setCellValue(allData.getFileAppend());
			}
		}
		return wb;
	}
}
