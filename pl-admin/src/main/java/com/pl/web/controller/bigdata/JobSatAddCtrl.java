package com.pl.web.controller.bigdata;

import com.alibaba.fastjson.JSONArray;
import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.Employee;
import com.pl.web.model.JobSatAdd;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.EmployeeServiceIMP;
import com.pl.web.service.impl.JobSatAddServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 工作饱和度(加法)Ctrl层
 * @author lihao
 *
 */
@Controller
@RequestMapping("/bigdata/job")
public class JobSatAddCtrl extends BaseController {
    private String prefix = "bigdata/job";

	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(JobSatAddCtrl.class);
	
	//Service层注入
	@Autowired
	private JobSatAddServiceIMP jobSatAddServiceIMP;
	//部门选择
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	//员工选择
	@Autowired
    private EmployeeServiceIMP employeeServiceIMP;
	
/*---------------A方案计算结果展示(8:30-17:30)-------------*/	
	//前端点击员工饱和度(加法)交互后台
	@RequestMapping("jobSatAddListCtrl")
	public String listAdd(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		return prefix + "/listAdd";
	}

    @PostMapping("/list")
    @ResponseBody
	public TableDataInfo list(JobSatAdd jobSatAdd) {
        startPage();
        jobSatAdd.setUserid(getUserId());
        List<JobSatAdd> list = jobSatAddServiceIMP.list(jobSatAdd);
        return getDataTable(list);
    }

	/*
	 * 员工饱和度(加法)列表查询
	 */
	@RequestMapping("jobStaAddGetDetailCtrl")
	public String jobStaAddList(ModelMap mm,HttpServletRequest request,HttpServletResponse response) throws Exception{
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
		int totalRecord = jobSatAddServiceIMP.getJobDetails1Size(department,mailname, startime, endtime);
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
		List<JobSatAdd> jobSatAdd=this.jobSatAddServiceIMP.getJobDetails1(department,mailname, startime, endtime,fromIndex,pageSize);
		//根据部门id查询员工.
		List<Employee> employees = employeeServiceIMP.getEmps(department_id);
		mm.put("department",department);
		mm.put("startime",startime );
		mm.put("endtime",endtime );
		mm.put("mailname",mailname );
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		mm.put("nums", employees);
		mm.put("page", pager);
		mm.put("list", jobSatAdd);
		mm.put("pageNum", pageNum);
		return "job/listAdd1";
		
	}
	
	/*
	 * 员工画像展示
	 */
	@RequestMapping("testAddListCtrl")
	@ResponseBody
	public String LoadTree(ModelMap mm,HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
//		String department = request.getParameter("department");
//		System.out.println("部门----"+department);
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		String mailname =request.getParameter("mailname");
		System.out.println(mailname);
		List<JobSatAdd> jobSatAdd=this.jobSatAddServiceIMP.getJobDetails(mailname, startime, endtime);
//		mm.put("depts",departmentServiceIMP.getDepartments());
		String jsonDate=JSONArray.toJSONString(jobSatAdd);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonDate);
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
/*---------------------B方法计算结果展示(全天)-----------------------------*/
	//前端点击员工饱和度(加法)交互后台
	//todo
		@RequestMapping("jobSatAddListCtrl_B")
		public String list_B(ModelMap mm,HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//当前默认为第一页
			/*int currentPage = 0;
			int totalRecord = jobSatAddServiceIMP.getSatAddSize_B();
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
			List<JobSatAdd> JobSatAdds = jobSatAddServiceIMP.list_B(fromIndex,pageSize);
			mm.put("page", pager);
			mm.put("list", JobSatAdds);
			mm.put("depts",departmentServiceIMP.getDepartments());
			mm.put("pageNum", pageNum);*/
            List<JobSatAdd> JobSatAdds = jobSatAddServiceIMP.list_B(0,10);

            mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
			return prefix + "/listAdd_b";
		}

    @PostMapping("/list_b")
    @ResponseBody
    public TableDataInfo list_b(JobSatAdd jobSatAdd) {
        startPage();
        jobSatAdd.setUserid(getUserId());
        List<JobSatAdd> list = jobSatAddServiceIMP.list_b(jobSatAdd);
        return getDataTable(list);
    }

		/*
		 * 员工饱和度(加法)列表查询
		 */
		@RequestMapping("jobStaAddGetDetailCtrl_B")
		public String jobStaAddList_B(ModelMap mm,HttpServletRequest request,HttpServletResponse response) throws Exception{
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
			int totalRecord = jobSatAddServiceIMP.getJobDetails1Size_B(department, mailname, startime, endtime);
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
			List<JobSatAdd> jobSatAdd=this.jobSatAddServiceIMP.getJobDetails1_B(department,mailname, startime, endtime,fromIndex,pageSize);
			//根据部门id查询员工.
			List<Employee> employees = employeeServiceIMP.getEmps(department_id);
			mm.put("department",department);
			mm.put("startime",startime );
			mm.put("endtime",endtime );
			mm.put("mailname",mailname );
			mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
			mm.put("nums", employees);
			mm.put("page", pager);
			mm.put("list", jobSatAdd);
			mm.put("pageNum", pageNum);
			return "jobnew/listAdd1";
			
		}
		
		/*
		 * 员工画像展示
		 */
		@RequestMapping("testAddListCtrl_B")
		@ResponseBody
		public String LoadTree_B(ModelMap mm,HttpServletRequest request,HttpServletResponse response) throws Exception {
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
			List<JobSatAdd> jobSatAdd=this.jobSatAddServiceIMP.getJobDetails_B(mailname, startime, endtime);
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
