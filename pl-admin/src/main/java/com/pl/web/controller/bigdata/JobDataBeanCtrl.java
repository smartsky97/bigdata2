package com.pl.web.controller.bigdata;

import com.pl.common.base.AjaxResult;
import com.pl.common.utils.ExcelUtil;
import com.pl.common.utils.StringUtils;
import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.dto.JobDataAll;
import com.pl.web.model.Employee;
import com.pl.web.model.JobDataBeansSix;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.EmployeeServiceIMP;
import com.pl.web.service.impl.JobDataBeanServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/bigdata/jobdata")
public class JobDataBeanCtrl extends BaseController {
	@Autowired
	private JobDataBeanServiceIMP jobDataBeanServiceIMP;
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	//员工选择
	@Autowired
	private EmployeeServiceIMP employeeServiceIMP;
	//迟到
	@RequestMapping("companyAlldata")
    @ResponseBody
	public TableDataInfo ChiDaoTimes(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String department = request.getParameter("department");
		System.out.println("department---"+department);
		String department_id =request.getParameter("department");
		String date = request.getParameter("date");
		System.out.println("date--"+date);
		if (StringUtils.isEmpty(date)) {
            List<JobDataAll> jobDataAlls =new ArrayList<JobDataAll>();
            TableDataInfo tableDataInfo = getDataTable(jobDataAlls);
            tableDataInfo.setTotal(0);
		    return tableDataInfo;
        }
		String mailname = request.getParameter("mailname");
		System.out.println("mailname---"+mailname);
	    List<JobDataAll> jobDataAlls =new ArrayList<JobDataAll>();
	    List<JobDataBeansSix> chidao =jobDataBeanServiceIMP.ChiDaoTimeLength(department, mailname, date);
	    List<JobDataBeansSix> fileAppend =jobDataBeanServiceIMP.FileAppendTimes(department, mailname, date);
	    List<JobDataBeansSix> norWork =jobDataBeanServiceIMP.NotWorkRatio(department, mailname, date);
	    for(int i=0;i<chidao.size();i++){
	    	JobDataAll data =new JobDataAll();
	    	JobDataBeansSix jobs= fileAppend.get(i);
	    	JobDataBeansSix job =chidao.get(i);
	    	JobDataBeansSix jobWork =norWork.get(i);
	    	data.setCn_name(job.getMailname()==null?"0":job.getMailname());
	    	data.setMonth(date==null?"0":date);
	    	data.setChidaoTimes(job.getValue1()==null?"0":job.getValue1());
	    	data.setZaoTuiTimes(job.getValue2()==null?"0":job.getValue2());
	    	data.setEmailTimes(job.getValue3()==null?"0":job.getValue3());
	    	data.setLyncTimes(job.getValue4()==null?"0":job.getValue4());
	    	data.setIpPhoneTimes(job.getValue5()==null?"0":job.getValue5());
	    	data.setNo_worklv(job.getValue6()==null?"0":job.getValue6());
	    	data.setChidaoLength(jobs.getValue1()==null?"0":jobs.getValue1());
			data.setZaotuiLength(jobs.getValue2()==null?"0":jobs.getValue2());
			data.setKaoqinTimes(jobs.getValue3()==null?"0":jobs.getValue3());
			data.setIpPhoneLength(jobs.getValue4()==null?"0":jobs.getValue4());
			data.setMouse_click(jobs.getValue5()==null?"0":jobs.getValue5());
			data.setKey_press(jobs.getValue6()==null?"0":jobs.getValue6());
			data.setKaoqinLength(jobWork.getValue1()==null?"0":jobWork.getValue1());
			data.setKaoqinlv(jobWork.getValue2()==null?"0":jobWork.getValue2());
			data.setSaturabilityA(jobWork.getValue3()==null?"0":jobWork.getValue3());
			data.setMeetingTime(jobWork.getValue4()==null?"0":jobWork.getValue4());
			data.setFileAppend(jobWork.getValue5()==null?"0":jobWork.getValue5());
			jobDataAlls.add(data);
	    }
	  //根据部门id查询员工.
	  List<Employee> employees = employeeServiceIMP.getEmps(department_id);
        TableDataInfo tableDataInfo = getDataTable(jobDataAlls);
        tableDataInfo.setTotal(jobDataAlls.size());
//	  	mm.put("department",department);
//	  	mm.put("mailname", mailname);
//	  	mm.put("datetime", date);
//		mm.put("depts", departmentServiceIMP.getDepartments());
//		mm.put("list", jobDataAlls);
//	    mm.put("nums", employees);
//		return "JobData/alldata";
        return tableDataInfo;
	}

    @PostMapping("/export")
    @ResponseBody
	public AjaxResult export(HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");
        String department = request.getParameter("department");
        System.out.println("department---"+department);
        String date = request.getParameter("date");
        System.out.println("date--"+date);
        if (StringUtils.isEmpty(date)) {
            return error("请选择日期！");
        }
        String mailname = request.getParameter("mailname");
        System.out.println("mailname---"+mailname);
        List<JobDataAll> jobDataAlls =new ArrayList<JobDataAll>();
        List<JobDataBeansSix> chidao =jobDataBeanServiceIMP.ChiDaoTimeLength(department, mailname, date);
        List<JobDataBeansSix> fileAppend =jobDataBeanServiceIMP.FileAppendTimes(department, mailname, date);
        List<JobDataBeansSix> norWork =jobDataBeanServiceIMP.NotWorkRatio(department, mailname, date);
        for(int i=0;i<chidao.size();i++){
            JobDataAll data =new JobDataAll();
            JobDataBeansSix jobs= fileAppend.get(i);
            JobDataBeansSix job =chidao.get(i);
            JobDataBeansSix jobWork =norWork.get(i);
            data.setCn_name(job.getMailname()==null?"0":job.getMailname());
            data.setMonth(date==null?"0":date);
            data.setChidaoTimes(job.getValue1()==null?"0":job.getValue1());
            data.setZaoTuiTimes(job.getValue2()==null?"0":job.getValue2());
            data.setEmailTimes(job.getValue3()==null?"0":job.getValue3());
            data.setLyncTimes(job.getValue4()==null?"0":job.getValue4());
            data.setIpPhoneTimes(job.getValue5()==null?"0":job.getValue5());
            data.setNo_worklv(job.getValue6()==null?"0":job.getValue6());
            data.setChidaoLength(jobs.getValue1()==null?"0":jobs.getValue1());
            data.setZaotuiLength(jobs.getValue2()==null?"0":jobs.getValue2());
            data.setKaoqinTimes(jobs.getValue3()==null?"0":jobs.getValue3());
            data.setIpPhoneLength(jobs.getValue4()==null?"0":jobs.getValue4());
            data.setMouse_click(jobs.getValue5()==null?"0":jobs.getValue5());
            data.setKey_press(jobs.getValue6()==null?"0":jobs.getValue6());
            data.setKaoqinLength(jobWork.getValue1()==null?"0":jobWork.getValue1());
            data.setKaoqinlv(jobWork.getValue2()==null?"0":jobWork.getValue2());
            data.setSaturabilityA(jobWork.getValue3()==null?"0":jobWork.getValue3());
            data.setMeetingTime(jobWork.getValue4()==null?"0":jobWork.getValue4());
            data.setFileAppend(jobWork.getValue5()==null?"0":jobWork.getValue5());
            jobDataAlls.add(data);
        }
        try {
            ExcelUtil<JobDataAll> util = new ExcelUtil<JobDataAll>(JobDataAll.class);
            return util.exportExcel(jobDataAlls, "jobs");
        } catch (Exception e) {
            return error("导出Excel失败，请联系网站管理员！");
        }
    }
	
	//集团数据指标平均值.
	
	@RequestMapping("AvercompanyAlldata")
    @ResponseBody
	public TableDataInfo AverChiDaoTimes(ModelMap mm,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String date = request.getParameter("date");
		System.out.println("date--"+date);
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
	  //根据部门id查询员工.
//	  	mm.put("datetime", date);
//		mm.put("depts", departmentServiceIMP.getDepartments());
//		mm.put("list", jobDataAlls);
//		return "JobData/AverData";
        TableDataInfo tableDataInfo = getDataTable(jobDataAlls);
        tableDataInfo.setTotal(jobDataAlls.size());
        return tableDataInfo;
	}
	
	
}
