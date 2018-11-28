package com.pl.web.controller.bigdata;

import com.pl.web.model.Employee;
import com.pl.web.model.EmpsKaoQin;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.EmployeeServiceIMP;
import com.pl.web.service.impl.EmpsKaoQinServiceIMP;
import com.pl.web.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
 * 花样年员工考勤信息展示
 */
@Controller
public class EmpsKaoQinCtrl {
	
	@Autowired 
	private EmpsKaoQinServiceIMP empsKaoQinServiceIMP;
	//部门选择
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	//员工选择
	@Autowired
	private EmployeeServiceIMP employeeServiceIMP;
	
	/**
	 * 员工考勤率展示(列表)
	 * @param mm
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("EmpsKaoQin")
	public String EmpsKaoQinList(ModelMap mm,HttpServletRequest request,HttpServletResponse response){
		int currentPage = 0;
		int totalRecord =this.empsKaoQinServiceIMP.getAllDataSize();
		mm.put("totalRecord", totalRecord);
		String pageNum = request.getParameter("pageNum");
		int pageSize = Pager.DEFAULT_PAGESIZE;
		//如果前台传入pageNum参数，则设置pageNum为当前第几页
		if (pageNum !=null && !"".equals(pageNum.trim())) {
			currentPage = Integer.parseInt(pageNum);
		}else {
			currentPage = Pager.DEFAULT_PAGENUM;
		}
		Pager pager = new Pager(currentPage, pageSize, totalRecord);
		int fromIndex = pager.getPageSize() * (pager.getCurrentPage() - 1);
		List<EmpsKaoQin> EmpsKaoQin = this.empsKaoQinServiceIMP.findAll(fromIndex, pageSize);
		mm.put("list", EmpsKaoQin);
		mm.put("page", pager);
		mm.put("depts",departmentServiceIMP.getDepartments());
		mm.put("pageNum", pageNum);
		return "kaoqin/empsList";
	}
	/**
	 * 员工考勤率查询
	 * @param mm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("SearchEmpsKaoQin")
	public String SearchEmpsKaoQin(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String department_id = request.getParameter("department");
		String department = request.getParameter("department");
		System.out.println("部门+++:"+department);
		String mailname = request.getParameter("mailname");
		System.out.println("姓名+++:"+mailname);
		String time = request.getParameter("date");
		int currentPage = 0;
		int totalRecord = this.empsKaoQinServiceIMP.getSearchSize(department, mailname, time);
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
		List<EmpsKaoQin> searchEmpsKaoQins =this.empsKaoQinServiceIMP.
				searchEmpKaoQin(department, mailname, time, fromIndex, pageSize);
		List<Employee> empList = this.employeeServiceIMP.getEmps(department_id);
		
		mm.put("department",department);
		mm.put("mailname", mailname);
		mm.put("time", time);
		mm.put("depts",departmentServiceIMP.getDepartments());
		mm.put("nums", empList);
		mm.put("page", pager);
		mm.put("list", searchEmpsKaoQins);
		mm.put("pageNum", pageNum);
		return "kaoqin/empsSearch";
		
	}
}
