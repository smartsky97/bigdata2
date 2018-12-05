package com.pl.web.controller.bigdata;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pl.framework.web.base.BaseController;
import com.pl.web.dto.EmpBasicInfo;
import com.pl.web.dto.EmpLabelResult;
import com.pl.web.dto.EmpTargetDynamic;
import com.pl.web.dto.EmpTargetResult;
import com.pl.web.service.IEmpLabelService;
import com.pl.web.service.ITagsService;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.EmployeeServiceIMP;
import com.pl.web.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 指标展示的json组合
 * 
 * @author songwubian
 *
 */
@Controller
public class TargetShowController extends BaseController {

	@Autowired
	private ITagsService tagsService;
	@Autowired
	private IEmpLabelService empLabelService;
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	private static PrintWriter writer = null;
	//员工选择
	@Autowired
	private EmployeeServiceIMP employeeServiceIMP;
	
   //可以删除的	
	@RequestMapping(value = "targetshow.do")
	public String show(@RequestParam() Map<String, String> map, Model model)
			throws JsonGenerationException, JsonMappingException, IOException {
		String departmentId = map.get("department_id");
		String cnName = map.get("employee");
		String startTime = map.get("start_time");
		String endTime = map.get("end_time");
		if (startTime != "" && startTime != null && endTime != "" && endTime != null) {
			startTime = startTime.substring(0, 7);
			endTime = endTime.substring(0, 7);
		} else {
			startTime = null;
			endTime = null;
		}
		//获取部门下具体员工的所有指标
		List<EmpTargetResult> show = tagsService.show(departmentId, cnName, startTime);
		EmpBasicInfo basicInfo = null;
		StringBuffer sb = new StringBuffer();
		List<EmpTargetDynamic> empTargetDynamics = new ArrayList<EmpTargetDynamic>();
		ObjectMapper mapper = new ObjectMapper();
		String basicInfoJson = null;
		for (int i = 0; i < show.size(); i++) {
			if (i == 0) {
				basicInfo = show.get(0).getEmpBasicInfo();
				model.addAttribute("baseInfo", basicInfo);
				basicInfoJson = mapper.writeValueAsString(basicInfo);
				System.out.println("basicInfoJson:=====" + basicInfo);
				sb.append("[" + basicInfoJson + ",");
			}
			EmpTargetDynamic empTargetDynamic = show.get(i).getEmpTargetDynamic();
			empTargetDynamics.add(empTargetDynamic);
			String empTargetDynamicStr = mapper.writeValueAsString(empTargetDynamic);
			System.out.println("empTargetDynamic:======" + empTargetDynamic);
			if (i == show.size() - 1) {
				sb.append(empTargetDynamicStr + "]");
			} else {
				sb.append(empTargetDynamicStr + ",");
			}

		}
		model.addAttribute("empTargetDynamics", empTargetDynamics);
		System.out.println("empTargetDynamics:============" + empTargetDynamics);
		List<EmpLabelResult> labelResults = empLabelService.selectByUserId(departmentId, cnName);
		System.out.println(labelResults);
		model.addAttribute("labels", labelResults);
		return "target";
	}

	@RequestMapping("bigdata/staff/userdraw")
	public String userdraw(ModelMap mm) {
        mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		return "bigdata/staff/userdraw";
	}

//	@RequestMapping(value = "/showjson.do", produces = { "application/json,charset=utf-8" })
	@RequestMapping(value = "bigdata/staff/showjson")
	@ResponseBody
//	public void showJson(@RequestParam() Map<String, String> map, HttpServletResponse response) throws Exception {
	public String showJson(@RequestParam(name="department_id",required = false)  String department_id,@RequestParam(name="employee",required = false) String employee,
                           @RequestParam(name="start_time",required = false) String start_time) throws Exception {
		String departmentId = department_id;
		String cnName = employee;
		String startTime = start_time;
	//	String endTime = map.get("end_time");
		if (startTime != "" && startTime != null ) {
			startTime = startTime.substring(0, 7);
		} else {
			startTime = null;
			
		}
		//获取指定部门员工的所有指标
		List<EmpTargetResult> show = tagsService.show(departmentId, cnName, startTime);
		//基本指标
		EmpBasicInfo basicInfo = null;
		StringBuffer sb = new StringBuffer();
		//动态指标
		List<EmpTargetDynamic> empTargetDynamics = new ArrayList<EmpTargetDynamic>();
		ObjectMapper mapper = new ObjectMapper();
		String basicInfoJson = null;
		for (int i = 0; i < show.size(); i++) {
			//基本信息只提取一次，防止重复
			if (i == 0) {
				basicInfo = show.get(0).getEmpBasicInfo();
				basicInfoJson = mapper.writeValueAsString(basicInfo);
				System.out.println("basicInfoJson:=====" + basicInfo);
				sb.append("[" + basicInfoJson + ",");
			}
			//动态指标信息需每次提取
			EmpTargetDynamic empTargetDynamic = show.get(i).getEmpTargetDynamic();
			empTargetDynamics.add(empTargetDynamic);
			//将指标信息拼接成前端要展示的json字符串
			String empTargetDynamicStr = mapper.writeValueAsString(empTargetDynamic);
			System.out.println("empTargetDynamic:======" + empTargetDynamic);
			if (i == show.size() - 1) {
				sb.append(empTargetDynamicStr + "]");
			} else {
				sb.append(empTargetDynamicStr + ",");
			}

		}
		System.out.println("empTargetDynamics:============" + empTargetDynamics);
		List<EmpLabelResult> labelResults = empLabelService.selectByUserId(departmentId, cnName);
		System.out.println(labelResults);
		return sb.toString();
//		response.setCharacterEncoding("UTF-8"); // 防止乱码
//		response.setContentType("application/json;charset=utf-8");
//		writer = response.getWriter();
//
//		writer.write(sb.toString());
//		System.out.println("json字符串:" + sb.toString());
//		writer.flush();
//		writer.close();
	}

	/**
	 * mysql动态指标分页显示controller
	 * 
	 * @param map
	 *            存取request参数键值对
	 * @param model
	 *            model存数据便于页面展示
	 * @return String 返回jsp页面
	 */	
	@RequestMapping(value = "pageShow.do")
	public String pageShow1(ModelMap mm,HttpServletRequest request,HttpServletResponse response) {
		/**
		 * 由于数据库查询未取出departmentId，所以需将部门id保存到页面对象中，便于分页下次查询
		 * ,start_time，end_time同理
		 */
		String department_id =request.getParameter("department_id");
		String employee = request.getParameter("employee");
		String start_time =	request.getParameter("start_time");
		int currentPage = 0;
		int totalRecord = tagsService.resultCount(department_id, employee, start_time);
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
		// 基本信息集合
		EmpBasicInfo basicInfo = null;
		// 动态指标的list集合
		List<EmpTargetDynamic> empTargetDynamics = new ArrayList<EmpTargetDynamic>();
		List<EmpTargetResult> pageShows = tagsService.pageShow(department_id, employee, start_time,fromIndex,pageSize);
		for (int i = 0; i < pageShows.size(); i++) {
			if (i == 0) {
				basicInfo = pageShows.get(0).getEmpBasicInfo();
				mm.put("baseInfo", basicInfo);
			}
			EmpTargetDynamic empTargetDynamic = pageShows.get(i).getEmpTargetDynamic();
			empTargetDynamics.add(empTargetDynamic);

		}
		mm.put("empTargetDynamics", empTargetDynamics);
		List<EmpLabelResult> labelResults = empLabelService.selectByUserId(department_id, employee);
		mm.put("labels", labelResults);
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		mm.put("nums", employeeServiceIMP.getEmps(department_id));
		mm.put("department_id", department_id);
		mm.put("employee", employee);
		mm.put("start_time", start_time);
		mm.put("page", pager);
		mm.put("pageNum", pageNum);
		return "elist";
	}
}
