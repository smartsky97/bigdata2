package com.pl.web.controller.bigdata;

import com.alibaba.fastjson.JSONObject;
import com.pl.web.model.Employee;
import com.pl.web.model.JobSatDown;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.EmployeeServiceIMP;
import com.pl.web.service.impl.JobSatDownServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 工作饱和度(减法)Ctrl层
 * @author lihao
 *
 */
@Controller
public class JobSatDownCtrl {
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(JobSatDownCtrl.class);
	//Service实现层注入
	@Autowired
	private JobSatDownServiceIMP jobSatDownServiceIMP;
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	//员工选择
	@Autowired
	private EmployeeServiceIMP employeeServiceIMP;
	
/*................A方法计算结果展示(8:30-17:30)...................*/	
	
	//前段页面点击与后台交互(首页点击看到的列表)
	@RequestMapping("jobSatDownListCtrl")
	public String list(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int currentPage = 0;
		int totalRecord = jobSatDownServiceIMP.getSatDownSize();
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
		List<JobSatDown> JobSatDowns = jobSatDownServiceIMP.list(fromIndex,pageSize);
		mm.put("depts", departmentServiceIMP.getDepartments());
		mm.put("page", pager);
		mm.put("list", JobSatDowns);
		mm.put("pageNum", pageNum);
		return "job/listDown";
	}
	//前段多条件查询与后台交互
	@RequestMapping("jobStaDownGetDetailCtrl")
	public String jobStaDownList(ModelMap mm,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String department = request.getParameter("department");
		String department_id = request.getParameter("department");
		System.out.println("部门----"+department);
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		String mailname =request.getParameter("mailname");
		System.out.println(mailname);
		int currentPage = 0;
		int totalRecord = jobSatDownServiceIMP.getJobDetails1Size(department,mailname,startime,endtime);
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
		List<JobSatDown> list=this.jobSatDownServiceIMP.getJobDetails1(department, mailname, startime, endtime,fromIndex,pageSize);
		//根据部门id查询员工.
		List<Employee> employees = employeeServiceIMP.getEmps(department_id);
		mm.put("department",department);
		mm.put("depts",departmentServiceIMP.getDepartments());
		mm.put("nums", employees);
		mm.put("startime",startime );
		mm.put("mailname", mailname);
		mm.put("endtime", endtime);
		mm.put("page", pager);
		mm.put("list",list );
		mm.put("pageNum", pageNum);
		return "job/listDown1";
		
	}
	
	//Echars图形界面展示
	@RequestMapping("testDownListCtrl")
	@ResponseBody
	public String LoadTree(Model mm,HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		String mailname =request.getParameter("mailname");
		System.out.println(mailname);
		List<JobSatDown> jobSatAdd=this.jobSatDownServiceIMP.getJobDetails(mailname, startime, endtime);
		
		String jsonDate= JSONObject.toJSONString(jobSatAdd);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonDate);
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}

/*................B方法计算结果展示(全天)..........................*/

	//前段页面点击与后台交互(首页点击看到的列表)
		@RequestMapping("jobSatDownListCtrl_B")
		public String list_B(ModelMap mm,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			int currentPage = 0;
			int totalRecord = jobSatDownServiceIMP.getSatDownSize_B();
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
			List<JobSatDown> JobSatDowns = jobSatDownServiceIMP.list_B(fromIndex,pageSize);
			mm.put("depts", departmentServiceIMP.getDepartments());
			mm.put("page", pager);
			mm.put("list", JobSatDowns);
			mm.put("pageNum", pageNum);
			return "jobnew/listDown";
		}
		//前段多条件查询与后台交互
		@RequestMapping("jobStaDownGetDetailCtrl_B")
		public String jobStaDownList_B(ModelMap mm,HttpServletRequest request) throws Exception{
			request.setCharacterEncoding("utf-8");
			String department_id =request.getParameter("department");
			String department = request.getParameter("department");
			System.out.println("部门----"+department);
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println(mailname);
			int currentPage = 0;
			int totalRecord = jobSatDownServiceIMP.getJobDetails1Size_B(department,mailname,startime,endtime);
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
			List<JobSatDown> list=this.jobSatDownServiceIMP.getJobDetails1_B(department, mailname, startime, endtime,fromIndex,pageSize);
			//根据部门id查询员工.
			List<Employee> employees = employeeServiceIMP.getEmps(department_id);
			mm.put("department",department);
			mm.put("depts",departmentServiceIMP.getDepartments());
			mm.put("nums", employees);
			mm.put("startime",startime );
			mm.put("mailname", mailname);
			mm.put("endtime", endtime);
			mm.put("page", pager);
			mm.put("list",list );
			mm.put("pageNum", pageNum);
			return "jobnew/listDown1";
			
		}
		
		//Echars图形界面展示
		@RequestMapping("testDownListCtrl_B")
		@ResponseBody
		public String LoadTree_B(Model mm,HttpServletRequest request,HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/javascript");
			String startime=request.getParameter("startime");
			System.out.println(startime);
			String endtime = request.getParameter("endtime");
			System.out.println(endtime);
			String mailname =request.getParameter("mailname");
			System.out.println(mailname);
			List<JobSatDown> jobSatAdd=this.jobSatDownServiceIMP.getJobDetails_B(mailname, startime, endtime);
			
			String jsonDate= JSONObject.toJSONString(jobSatAdd);
			try {
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(jsonDate);
			} catch (IOException  e) {
				e.printStackTrace();
			}
			return null;
		}

}
