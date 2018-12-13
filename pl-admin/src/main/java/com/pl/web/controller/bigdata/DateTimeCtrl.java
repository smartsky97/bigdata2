package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.DateTime;
import com.pl.web.service.impl.DateTimeServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class DateTimeCtrl extends BaseController {
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(DateTimeCtrl.class);
	
	@Autowired
	private DateTimeServiceIMP dateTimeServiceIMP;
	
	//页面展示列表
	@RequestMapping("bigdata/url/dateTimeList")
    @ResponseBody
	public TableDataInfo DateTimeList(DateTime dateTime){
        startPage();
		List<DateTime> dateTimes = this.dateTimeServiceIMP.dataList(dateTime);
        TableDataInfo tableDataInfo = getDataTable(dateTimes);
        return tableDataInfo;
	
	}

    @RequestMapping("bigdata/url/datetime")
    public String datetime() {
        return "bigdata/url/datetime";
    }

	@RequestMapping("bigdata/url/upload")
	public String upload() {
		return "bigdata/url/upload";
	}

	//添加
	@RequestMapping("AddDate")
	public String AddDateTime(ModelMap mm,DateTime dateTime,HttpServletRequest request){
		boolean result = this.dateTimeServiceIMP.AddDateTime(dateTime);
		if (result) {
			System.out.println("添加成功");
		} 
		return datetime();
	}
	//删除
	@RequestMapping("DeleteDate")
	public String DeleteDateTime(ModelMap mm,HttpServletRequest request){
		String id1 =request.getParameter("id");
		System.out.println(id1);
		int id=Integer.parseInt(id1);
		boolean result= this.dateTimeServiceIMP.DeleteDateTime(id);
		if(result){
			System.out.println("删除成功");
		}
		return datetime();
	}
	//更新
	@RequestMapping("UpdateDate")
	public String UpdateDate(ModelMap mm,DateTime dateTime,HttpServletRequest request){
		boolean result = this.dateTimeServiceIMP.UpdateDateTime(dateTime);
		if (result) {
			System.out.println("更新成功");
		} 
		return datetime();
	}
	//更新前的查询
	@RequestMapping("UpdateDateUI")
	public String getDateById(ModelMap mm,HttpServletRequest request){
		String id2 = request.getParameter("id");
		int id = Integer.parseInt(id2);
		DateTime dateTime =this.dateTimeServiceIMP.getDateTimeByID(id);
		mm.put("dates",dateTime);
		return "datetime/listinfo";
	}
	//查询
	@RequestMapping("searchDatetime")
	public String SearchDate(ModelMap mm,HttpServletRequest request){
		String date = request.getParameter("date");
		System.out.println("时间日期---"+date);
		String descb = request.getParameter("descb");
		int currentPage = 0;
		int totalRecord = this.dateTimeServiceIMP.getSearchDataSize(date,descb);
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
		List<DateTime> listDateTimes = this.dateTimeServiceIMP.listDateTimes(date, descb, fromIndex, pageSize);
		mm.put("date",date);
		mm.put("descb", descb);
		mm.put("page", pager);
		mm.put("list",listDateTimes);
		mm.put("pageNum", pageNum);
		return "datetime/listSearch";
	}
}
