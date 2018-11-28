package com.pl.web.controller.bigdata;

import com.alibaba.fastjson.JSONArray;
import com.pl.web.dto.EmpAverSat;
import com.pl.web.service.impl.EmpAverSatServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * 员工平均工作饱和度
 * @author lih
 *
 */
@Controller
public class EmpAverSatCtrl {
	@Autowired
	private EmpAverSatServiceIMP empAverSatServiceIMP;
	
/*................A方法计算结果展示(8:30-17:30)...................*/
	@RequestMapping("empAverSat")
	@ResponseBody
	public String AverSat(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String endtime = dateFormat.format( now );
		Calendar c = Calendar.getInstance(); 
        c.add(Calendar.DATE, - 7);
        Date monday = c.getTime();
        String startime = dateFormat.format(monday);
        String mailname =null;
        System.out.println(endtime+"结束时间");
		System.out.println(startime+"开始时间"); 
		List<EmpAverSat> jobAverSat=this.empAverSatServiceIMP.getEmpAverSats(mailname,startime,endtime);
		String jsonAverSat=JSONArray.toJSONString(jobAverSat);
		//System.out.println(jsonAverSat);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonAverSat);
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@RequestMapping("empSearchAverSat")
	@ResponseBody
	public String SearchAverSat(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		String mailname =request.getParameter("mailname");
		System.out.println(mailname);
		String department = request.getParameter("department");
		System.out.println("部门ID--"+department);
		List<EmpAverSat> jobAverSat=this.empAverSatServiceIMP.searchEmpAverSats(department,mailname, startime, endtime);
		String jsonDate=JSONArray.toJSONString(jobAverSat);
		//System.out.println(jsonDate);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonDate);
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
/*----------------------------B方法计算结果展示(全天)-----------------------*/
	//B方案计算结果展示(全天)
	@RequestMapping("empAverSat_B")
	@ResponseBody
	public String AverSat_B(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String endtime = dateFormat.format( now );
		Calendar c = Calendar.getInstance(); 
        c.add(Calendar.DATE, - 7);
        Date monday = c.getTime();
        String startime = dateFormat.format(monday);
        String mailname =null;
        System.out.println(endtime+"结束时间");
		System.out.println(startime+"开始时间"); 
		List<EmpAverSat> jobAverSat=this.empAverSatServiceIMP.getEmpAverSats_B(mailname, startime, endtime);
		String jsonAverSat=JSONArray.toJSONString(jobAverSat);
		//System.out.println(jsonAverSat);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonAverSat);
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("empSearchAverSat_B")
	@ResponseBody
	public String SearchAverSat_B(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		String mailname =request.getParameter("mailname");
		System.out.println(mailname);
		String department = request.getParameter("department");
		System.out.println("部门ID--"+department);
		List<EmpAverSat> jobAverSat=this.empAverSatServiceIMP.searchEmpAverSats_B(department, mailname, startime, endtime);
		String jsonDate=JSONArray.toJSONString(jobAverSat);
		//System.out.println(jsonDate);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonDate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
