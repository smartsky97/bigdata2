package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.web.model.Depart_kaoqin;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.DeptKaoQinServicceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/*
 * 部门考勤率展示
 */
@Controller
public class DeptKaoQinCtrl extends BaseController {
	
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(DateTimeCtrl.class);
	
	@Autowired
	private DeptKaoQinServicceIMP deptKaoQinServicceIMP;
	//部门选择
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	
	@RequestMapping("DeptKaoQin")
	public String ShowList(ModelMap mm,HttpServletRequest request,HttpServletResponse response){
		int currentPage = 0;
		int totalRecord =deptKaoQinServicceIMP.getAllDataSize();
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
		List<Depart_kaoqin> DeptKaoQs=deptKaoQinServicceIMP.findAll(fromIndex, pageSize);
		mm.put("list", DeptKaoQs);
		mm.put("page", pager);
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		mm.put("pageNum", pageNum);
		return "kaoqin/list";
	}
	
	@RequestMapping("DeptKaoQinSearch")
	public String SearchList(ModelMap mm,HttpServletRequest request,HttpServletResponse response){
		String department = request.getParameter("department");
		String time = request.getParameter("date");
		int currentPage = 0;
		int totalRecord =deptKaoQinServicceIMP.getSerarchSize(department, time);
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
		List<Depart_kaoqin> SearchList =deptKaoQinServicceIMP.searchDekp(department, time, fromIndex, pageSize);
		mm.put("department",department);
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		mm.put("time",time );
		mm.put("page", pager);
		mm.put("list", SearchList);
		mm.put("pageNum", pageNum);
		return "kaoqin/listSearch";
		
	}
	
}
