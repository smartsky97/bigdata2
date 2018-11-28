package com.pl.web.controller.bigdata;

import com.pl.web.model.Department;
import com.pl.web.model.QualityResultPage;
import com.pl.web.service.IEmpQualityResultService;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 员工量前端结果展示
 * @author huangjz
 *
 */
@Controller	
public class EmpQualityResultControl {
	
	@Autowired
    private DepartmentServiceIMP departmentServiceIMP;
	@Autowired
	private IEmpQualityResultService qualityResultService;
	@RequestMapping("qualityResult")
	public ModelAndView qualityResult(HttpServletRequest request, ModelMap mm,
			HttpServletResponse response) throws Exception{
		int pageSize = 0;
		
		int currentPage = Pager.DEFAULT_PAGENUM;
		String pageNum = request.getParameter("pageNum");
		
		if("".equals(pageNum)||null == pageNum ||"0".equals(pageNum)){
			pageNum="1";
		 }
		String department_id = request.getParameter("department_id");
		String computeDate = request.getParameter("computeDate");
		if ("".equals(department_id)) {
			department_id=null;
		}
		if ("".equals(computeDate)) {
			computeDate=null;
		}
		
		Integer index = null;
		Integer length = null;
		int totalRecord = qualityResultService.resultCount(computeDate, department_id, index, length);
		
		System.out.println("--totalRecord--" +totalRecord);
		
		currentPage = Integer.parseInt(pageNum);
		pageSize = Pager.DEFAULT_PAGESIZE;
		Pager page = new Pager(currentPage,pageSize,totalRecord);
		int fromIndex = (page.getCurrentPage()-1)*page.getPageSize();
		List<Department> depts = departmentServiceIMP.getDepartments();

		List<QualityResultPage> list = qualityResultService.select(computeDate,department_id , fromIndex,pageSize);
		
		System.out.println("---EmpQualityResult---list --" +list);
		mm.put("depts", depts);
		mm.put("department_id", department_id);
		mm.put("computeDate", computeDate);
		mm.put("page", page);
		mm.put("list", list);
		mm.put("pageNum", pageNum);
        return new ModelAndView("qualityResult/list",mm);  
	}
}
