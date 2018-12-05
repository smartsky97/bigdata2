package com.pl.web.controller.bigdata;


import com.alibaba.fastjson.JSONArray;
import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.Employee;
import com.pl.web.model.JobSatAdd;
import com.pl.web.model.Month_saturation_collection_a;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.EmployeeServiceIMP;
import com.pl.web.service.impl.Month_JobSatAddServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 月度饱和度加法A展示Crtl层
 * @author root
 *
 */
@Controller
public class MonthSatAdd_aCtrl extends BaseController {
	private static Logger log = LoggerFactory.getLogger(MonthSatAdd_aCtrl.class);
	@Autowired
	private Month_JobSatAddServiceIMP month_JobSatAddServiceIMP;
	//部门选择
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	//员工选择
	@Autowired
	private EmployeeServiceIMP employeeServiceIMP;
	
	//目录点击员工饱和度(加法)交互后台
	@RequestMapping("bigdata/month/MonthjobSatAddListCtrl")
    @ResponseBody
    public TableDataInfo MonthSatAdd_a_list(JobSatAdd jobSatAdd) throws Exception {
        startPage();
		jobSatAdd.setUserid(getUserId());
		if ("全部".equals(jobSatAdd.getMailname())) {
            jobSatAdd.setMailname(null);
        }
        List<Month_saturation_collection_a> MonthJobSatAdds_a = month_JobSatAddServiceIMP.Month_list(jobSatAdd);
        TableDataInfo tableDataInfo = getDataTable(MonthJobSatAdds_a);
        return tableDataInfo;
    }

    @RequestMapping("bigdata/month/monthjob")
    public String monthjob(ModelMap mm) {
        mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
        return "bigdata/month/monthjob";
    }

		/*
		 * 列表查询_员工饱和度(加法)
		 */
		@RequestMapping("Month_JobStaAddGetDetailCtrl")
		public String MonthjobStaAddList(ModelMap mm,HttpServletRequest request,HttpServletResponse response) throws Exception{
			request.setCharacterEncoding("utf-8");
			String department_id = request.getParameter("department");
			String department = request.getParameter("department");
			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println("员工姓名-----"+mailname);
			int currentPage = 0;
			int totalRecord =month_JobSatAddServiceIMP.getMonthJobDetails1Size(department, mailname, startime, endtime);
			mm.put("totalRecord", totalRecord);
			String pageNum = request.getParameter("pageNum");
			int pageSize = Pager.DEFAULT_PAGESIZE;
			//如果前台传入pageNum参数，则设置pageNum为当前第几页
			if(pageNum!=null&&!"".equals(pageNum.trim())){
					currentPage = Integer.parseInt(pageNum);
			}else{
					currentPage = Pager.DEFAULT_PAGENUM;
			}
			Pager pager = new Pager(currentPage, pageSize, totalRecord);
			int fromIndex = pager.getPageSize() * (pager.getCurrentPage() - 1);
			List<Month_saturation_collection_a> MonthjobSatAdd=this.month_JobSatAddServiceIMP.
					getMonthJobDetailSearch(department, mailname, startime, endtime, fromIndex, pageSize);
			//根据部门id查询员工.
			List<Employee> employees = employeeServiceIMP.getEmps(department_id);
			mm.put("department",department);
			mm.put("startime",startime );
			mm.put("endtime",endtime );
			mm.put("mailname",mailname );
			mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
			mm.put("nums", employees);
			mm.put("page", pager);
			mm.put("list", MonthjobSatAdd);
			mm.put("pageNum", pageNum);
			return "MonthJobSta/listAdd1";
			
		}
		
		/*
		 * Echars图表展示
		 */
		@RequestMapping("bigdata/month/MonthEcharsAddListCtrl")
		@ResponseBody
		public String LoadTree(ModelMap mm,HttpServletRequest request,HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/javascript");
//			String department = request.getParameter("department");
//			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println(mailname);
			List<Month_saturation_collection_a> jobSatAdd=
					this.month_JobSatAddServiceIMP.getMonthJobDetails(mailname, startime, endtime);
//			mm.put("depts",departmentServiceIMP.getDepartments());
			String jsonDate=JSONArray.toJSONString(jobSatAdd);
			try {
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jsonDate);
			} catch (IOException  e) {
				e.printStackTrace();
			}
			return null;
		}
}
