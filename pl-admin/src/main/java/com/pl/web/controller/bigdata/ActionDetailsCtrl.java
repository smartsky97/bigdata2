package com.pl.web.controller.bigdata;

import com.pl.web.model.ActionDetails;
import com.pl.web.service.impl.ActionDetailServiceIMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 工作详细信息控制类
 * @author root
 *
 */
@Controller
public class ActionDetailsCtrl {
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(ActionDetailsCtrl.class);
	/*
	 * Service实现层注入.
	 */
	@Autowired
	private ActionDetailServiceIMP actionDetailServiceIMP;
	/*
	 * 员工工作详细信息(加法).
	 */
	@RequestMapping("lookAddDetails")
	public String Detail(Model mm, ActionDetails actionDetails, HttpServletRequest request) throws Exception{
			request.setCharacterEncoding("utf-8");
			String mailname=request.getParameter("mailname");
			System.out.println(mailname);
			String date =request.getParameter("date");
			System.out.println(date);
			List<ActionDetails> details=this.actionDetailServiceIMP.getDetails(mailname, date);
			mm.addAttribute("list", details);
		return "job/jobDetails";	
	}
	/*
	 * 员工工作详细信息(减法).
	 */
	@RequestMapping("lookDownDetails")
	public String DetailDown(Model mm,ActionDetails actionDetails,HttpServletRequest request) throws Exception{
			request.setCharacterEncoding("utf-8");
			String mailname=request.getParameter("mailname");
			String date =request.getParameter("date");
			List<ActionDetails> details=this.actionDetailServiceIMP.getDetails(mailname, date);
			mm.addAttribute("list", details);
		return "job/jobDetails";	
	}
}
