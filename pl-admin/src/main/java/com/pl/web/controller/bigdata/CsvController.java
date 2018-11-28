package com.pl.web.controller.bigdata;

import com.pl.web.dto.JobDataAll;
import com.pl.web.model.*;
import com.pl.web.service.impl.*;
import com.pl.web.util.ExcelDataExport;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CsvController {
	 
	//饱和度加法   
	@Autowired
	private JobSatAddServiceIMP jobSatAddServiceIMP;
	//饱和度减法
	@Autowired
	private JobSatDownServiceIMP jobSatDownServiceIMP;
	//部门考勤
	@Autowired
	private DeptKaoQinServicceIMP deptKaoQinServicceIMP;
	//员工考勤
	@Autowired
	private EmpsKaoQinServiceIMP empsKaoQinServiceIMP;
	//月度工作饱和度("8:30-17:50")
	@Autowired
	private Month_JobSatAddServiceIMP month_JobSatAddServiceIMP;
	
	@Autowired
	private JobDataBeanServiceIMP jobDataBeanServiceIMP;
	 /*
	  * 加法A导出Excel文件
	  */
		@RequestMapping(value="JobAddForCsv")
		public void JobSatAddForCsv(HttpServletRequest request,  
			    HttpServletResponse response) throws Exception{
			String department = request.getParameter("department");
			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println("员工姓名-----"+mailname);
		    String fileName="";
 	         List<JobSatAdd> listJobAdd=this.jobSatAddServiceIMP.getJobSatCSV(department, mailname, startime, endtime);
			    fileName = "工作饱和度加法A(8:30-17:30)"+startime+"~"+endtime;	
			       HSSFWorkbook wb = ExcelDataExport.exportAdd(listJobAdd, fileName);
			       response.setContentType("application/vnd.ms-excel");    
			       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
			       OutputStream ouputStream = response.getOutputStream();    
			       wb.write(ouputStream);  
			       ouputStream.flush();    
			       ouputStream.close();  
		}
		
		/*
	  	 * 加法B导出Excel文件
	  	 */
		@RequestMapping(value="JobAdd_BForCsv")
		public void JobSadAdd_BForCsv(HttpServletRequest request,  
			    HttpServletResponse response) throws Exception{
			String department = request.getParameter("department");
			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println("员工姓名-----"+mailname);
		    String fileName="";
 	         List<JobSatAdd> jobSatAdds=this.jobSatAddServiceIMP.getJobSat_BCSV(department, mailname, startime, endtime); 
 	         	fileName = "工作饱和度加法B(全天)"+startime+"~"+endtime;
			       HSSFWorkbook wb = ExcelDataExport.exportAdd(jobSatAdds, fileName);
			       response.setContentType("application/vnd.ms-excel");    
			       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
			       OutputStream ouputStream = response.getOutputStream();    
			       wb.write(ouputStream);  
			       ouputStream.flush();    
			       ouputStream.close();  
		}
		
		/*
		 * 减法A导出Excel文件
		 */
		@RequestMapping(value="JobDownForCsv")
		public void JobSadDownForCsv(HttpServletRequest request,  
			    HttpServletResponse response) throws Exception{
			String department = request.getParameter("department");
			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println("员工姓名-----"+mailname);
		    String fileName="";
 	         List<JobSatDown> jobDowns=this.jobSatDownServiceIMP.getJobDownCSV(department, mailname, startime, endtime);
			    fileName = "工作饱和度减法A(8:30~17:30)"+startime+"~"+endtime;
			       HSSFWorkbook wb = ExcelDataExport.exportDown(jobDowns, fileName);
			       response.setContentType("application/vnd.ms-excel");    
			       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
			       OutputStream ouputStream = response.getOutputStream();    
			       wb.write(ouputStream);  
			       ouputStream.flush();    
			       ouputStream.close();  
		}
		
		/*
		 * 减法B导出Excel文件
		 */
		@RequestMapping(value="JobDown_BForCsv")
		public void JobSadDown_BForCsv(HttpServletRequest request,  
			    HttpServletResponse response) throws Exception{
			String department = request.getParameter("department");
			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println("员工姓名-----"+mailname);
		    String fileName="";
 	         List<JobSatDown> jobDowns=this.jobSatDownServiceIMP.getJobDown_BCSV(department, mailname, startime, endtime);
			    fileName = "工作饱和度减法B(全天)"+startime+"~"+endtime;
			       HSSFWorkbook wb = ExcelDataExport.exportDown(jobDowns, fileName);
			       response.setContentType("application/vnd.ms-excel");    
			       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
			       OutputStream ouputStream = response.getOutputStream();    
			       wb.write(ouputStream);  
			       ouputStream.flush();    
			       ouputStream.close();  
		}
		/*
		 * 部门考勤数据导出Excel
		 */
	@RequestMapping("DeptsKaoQin2CSV")
	public void DeptsKaoQin2CSV(HttpServletRequest request,HttpServletResponse response)throws Exception{
			
			String department = request.getParameter("department");
			String time = request.getParameter("date");
			String fileName ="";
			List<Depart_kaoqin> depart_kaoqins =this.deptKaoQinServicceIMP.getDepart_kaoqin2CSv(department, time);
			fileName ="部门考勤"+"~"+time;
			HSSFWorkbook wb =ExcelDataExport.expotDeptsKaoQin(depart_kaoqins, fileName);
			   response.setContentType("application/vnd.ms-excel");    
		       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
		       OutputStream ouputStream = response.getOutputStream();    
		       wb.write(ouputStream);  
		       ouputStream.flush();    
		       ouputStream.close();
		}
	/*
	 * 员工考勤数据导出Excel
	 */
	@RequestMapping("EmpKaoQin2CSV")
	public void EmpsKaoQin2CSV(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		String department = request.getParameter("department");
		System.out.println("部门+++:"+department);
		String mailname = request.getParameter("mailname");
		System.out.println("姓名+++:"+mailname);
		String time = request.getParameter("date");
		String fileName ="";
		List<EmpsKaoQin> empsKaoQins =this.empsKaoQinServiceIMP.getEmpsKaoQin2CSV(department, mailname, time);
		fileName = "员工考勤"+"_"+department+"~"+time;
		HSSFWorkbook wb =ExcelDataExport.exportEmpsKaoQin(empsKaoQins, fileName);
		response.setContentType("application/vnd.ms-excel");    
	       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
	       OutputStream ouputStream = response.getOutputStream();    
	       wb.write(ouputStream);  
	       ouputStream.flush();    
	       ouputStream.close();
	}
	
	/*
  	 * 月度计算加法A导出Excel文件
  	 */
	@RequestMapping(value="MonthJobAddForCsv")
	public void MonthJobSatAddForCsv(HttpServletRequest request,  
		    HttpServletResponse response) throws Exception{
		String department = request.getParameter("department");
		System.out.println("部门----"+department);
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		String mailname =request.getParameter("mailname");
		System.out.println("员工姓名-----"+mailname);
	    String fileName="";
	    List<Month_saturation_collection_a> MonthListJobAdd=this.month_JobSatAddServiceIMP.getMonthJobSatCSV(department, mailname, startime, endtime);
		    fileName = "月度计算工作饱和度加法A(8:30-17:30)"+startime+"~"+endtime;	
		       HSSFWorkbook wb = ExcelDataExport.exportMonthAdd(MonthListJobAdd, fileName);
		       response.setContentType("application/vnd.ms-excel");    
		       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
		       OutputStream ouputStream = response.getOutputStream();    
		       wb.write(ouputStream);  
		       ouputStream.flush();    
		       ouputStream.close(); 
	}
	/**
	 * 集团详细指标数据导出.
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="JobDataBean")
	public void JobDataBeanForCsv(HttpServletRequest request,  
		    HttpServletResponse response) throws Exception{
		String department = request.getParameter("department");
		String date = request.getParameter("date");
		String mailname = request.getParameter("mailname");
	    String fileName="";
	    List<JobDataAll> jobDataAlls =new ArrayList<JobDataAll>();
	    List<JobDataBeansSix> chidao =jobDataBeanServiceIMP.ChiDaoTimeLength(department, mailname, date);
	    List<JobDataBeansSix> fileAppend =jobDataBeanServiceIMP.FileAppendTimes(department, mailname, date);
	    List<JobDataBeansSix> norWork =jobDataBeanServiceIMP.NotWorkRatio(department, mailname, date);
	    for(int i=0;i<chidao.size();i++){
	    	JobDataAll data =new JobDataAll();
	    	JobDataBeansSix jobs= fileAppend.get(i);
	    	JobDataBeansSix job =chidao.get(i);
	    	JobDataBeansSix jobWork =norWork.get(i);
	    	data.setCn_name(job.getMailname());
	    	data.setMonth(job.getDate());
	    	data.setChidaoTimes(job.getValue1());
	    	data.setZaoTuiTimes(job.getValue2());
	    	data.setEmailTimes(job.getValue3());
	    	data.setLyncTimes(job.getValue4());
	    	data.setIpPhoneTimes(job.getValue5());
	    	data.setNo_worklv(job.getValue6());
	    	data.setChidaoLength(jobs.getValue1());
			data.setZaotuiLength(jobs.getValue2());
			data.setKaoqinTimes(jobs.getValue3());
			data.setIpPhoneLength(jobs.getValue4());
			data.setMouse_click(jobs.getValue5());
			data.setKey_press(jobs.getValue6());
			data.setKaoqinLength(jobWork.getValue1());
			data.setKaoqinlv(jobWork.getValue2());
			data.setSaturabilityA(jobWork.getValue3());
			data.setMeetingTime(jobWork.getValue4());
			data.setFileAppend(jobWork.getValue5());
			jobDataAlls.add(data);
	    }
		    fileName = "集团工作指标数据"+"~"+department+"~"+date;	
		       HSSFWorkbook wb = ExcelDataExport.exportJiTuanData(jobDataAlls,fileName);
		       response.setContentType("application/vnd.ms-excel");    
		       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
		       OutputStream ouputStream = response.getOutputStream();    
		       wb.write(ouputStream);  
		       ouputStream.flush();    
		       ouputStream.close(); 
	}
	/**
	 * 月度集团详细指标数据平均值导出
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="AverJobDataBean")
	public void AverJobDataBeanForCsv(HttpServletRequest request,  
		    HttpServletResponse response) throws Exception{
		String date = request.getParameter("date");
	    String fileName="";
	    List<JobDataAll> jobDataAlls =new ArrayList<JobDataAll>();
	    List<JobDataBeansSix> chidao =jobDataBeanServiceIMP.AverChiDaoTimeLength(date);
	    List<JobDataBeansSix> fileAppend =jobDataBeanServiceIMP.AverFileAppendTimes(date);
	    List<JobDataBeansSix> norWork =jobDataBeanServiceIMP.AverNotWorkRatio(date);
	    for(int i=0;i<chidao.size();i++){
	    	JobDataAll data =new JobDataAll();
	    	JobDataBeansSix jobs= fileAppend.get(i);
	    	JobDataBeansSix job =chidao.get(i);
	    	JobDataBeansSix jobWork =norWork.get(i);
	    	data.setCn_name(job.getMailname());
	    	data.setMonth(job.getDate());
	    	data.setChidaoTimes(job.getValue1());
	    	data.setZaoTuiTimes(job.getValue2());
	    	data.setEmailTimes(job.getValue3());
	    	data.setLyncTimes(job.getValue4());
	    	data.setIpPhoneTimes(job.getValue5());
	    	data.setNo_worklv(job.getValue6());
	    	data.setChidaoLength(jobs.getValue1());
			data.setZaotuiLength(jobs.getValue2());
			data.setKaoqinTimes(jobs.getValue3());
			data.setIpPhoneLength(jobs.getValue4());
			data.setMouse_click(jobs.getValue5());
			data.setKey_press(jobs.getValue6());
			data.setKaoqinLength(jobWork.getValue1());
			data.setKaoqinlv(jobWork.getValue2());
			data.setSaturabilityA(jobWork.getValue3());
			data.setMeetingTime(jobWork.getValue4());
			data.setFileAppend(jobWork.getValue5());
			jobDataAlls.add(data);
	    }
		    fileName = "月度集团工作指标数据(平均值)"+"~"+date;	
		       HSSFWorkbook wb = ExcelDataExport.exportJiTuanData(jobDataAlls,fileName);
		       response.setContentType("application/vnd.ms-excel");    
		       response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1")+".xls");
		       OutputStream ouputStream = response.getOutputStream();    
		       wb.write(ouputStream);  
		       ouputStream.flush();    
		       ouputStream.close(); 
	}
}
		
		
