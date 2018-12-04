package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.web.model.Department;
import com.pl.web.service.impl.DepartmentServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/bigdata/jobData")
public class DepartmentController extends BaseController {
    private String prefix = "bigdata/jobData";
	@Autowired
    private DepartmentServiceIMP departmentServiceIMP;
	/*
	 * 画像
	 */
	@RequestMapping(value="listDept")
	public ModelAndView getDepartments(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("edraw",model);
	}
	/*
	 * 列表
	 */
	@RequestMapping(value="listDept1")
	public ModelAndView getDepartments1(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("elist",model);
	}
	/*
	 * 
	 */
	@RequestMapping(value="listDept2")
	public ModelAndView getDepartments2(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/simple",model);
	}
	
	@RequestMapping(value="listDept3")
	public ModelAndView getDepartments3(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/simpleb",model);
	}
	@RequestMapping(value="listDept4")
	public ModelAndView getDepartments4(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/saturationAdd_B",model);
	}
	@RequestMapping(value="listDept5")
	public ModelAndView getDepartments5(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/saturationAdd",model);
	}
	@RequestMapping(value="listDept6")
	public ModelAndView getDepartments6(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/saturationDown_B",model);
	}
	@RequestMapping(value="listDept7")
	public ModelAndView getDepartments7(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/saturationDown",model);
	}
	@RequestMapping(value="listDept8")
	public ModelAndView getDepartments8(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("MonthJobSta/saturation",model);
	}
	@RequestMapping(value="listDept9")
	public ModelAndView getDepartments9(HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("pages/table/jobEfficiency",model);
	}
	//集团指标数据
	@RequestMapping(value="listDept10")
	public String getDepartments10(ModelMap mm) throws Exception{
		/*List<Department> depts = departmentServiceIMP.getDepartments();
		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
		model.put("depts",depts);
		return new ModelAndView("JobData/alldata",model);*/
        mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		return prefix + "/jobdataall";
	}
	//集团指标数据平均值
	@RequestMapping(value="listDept11")
	public String getDepartments11(ModelMap mm) throws Exception{
//		List<Department> depts = departmentServiceIMP.getDepartments();
//		Map<String,List<Department>> model = new HashMap<String,List<Department>>();
//		model.put("depts",depts);
//		return new ModelAndView("JobData/AverData",model);
        mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
        return prefix + "/jobdataallavg";
	}
	public String GetDegt(HttpServletRequest request,HttpServletResponse response){
		return "JobData/AverData";
	}

}

