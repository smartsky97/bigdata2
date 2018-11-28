package com.pl.web.controller.bigdata;

import com.alibaba.fastjson.JSONArray;
import com.pl.web.model.WifiData;
import com.pl.web.service.impl.WifiDataServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class WifiDataCtrl {
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(WifiDataCtrl.class);
	/*
	 * 注入
	 */
	@Autowired
	private WifiDataServiceIMP wifiDataServiceIMP;

	/*
	 * WIFI定位数据列表
	 */
	@RequestMapping("wifiList")
	public String listWifiData(ModelMap mm,HttpServletRequest request)throws Exception{
		/*int currentPage = 0;
		int totalRecord =this.wifiDataServiceIMP.getWifiDataSize();
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
		List<WifiData> listData = this.wifiDataServiceIMP.list(fromIndex, pageSize);
		mm.put("page", pager);
		mm.put("list", listData);
		mm.put("pageNum", pageNum);*/
		return "wifi/list";
	}
	
	/*
	 * 查询wifi定位数据(以表格展示)
	 */
	@RequestMapping("searchWifiData")
	public String searchWifiData(ModelMap mm, WifiData wifiData,
			HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		String macCode = request.getParameter("number");
		System.out.println("-----------" + macCode);
		String positionName = request.getParameter("position");
		System.out.println("-----------" + positionName);
		String userName = request.getParameter("username");
		System.out.println("---------" + userName);
		String cnName =request.getParameter("cnname");
		String startTime = request.getParameter("startime");
		System.out.println("------" + startTime);
		String endTime = request.getParameter("endtime");
		System.out.println("-------" + endTime);
		int currentPage = 0;
		int totalRecord = this.wifiDataServiceIMP.searchWifiDataSize(macCode, positionName, userName,cnName,startTime, endTime);
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
		List<WifiData> wifiDatas = this.wifiDataServiceIMP.searchWifiData(macCode, positionName, userName,cnName,startTime, endTime, fromIndex, pageSize);
		mm.put("startime", startTime);
		mm.put("endtime", endTime);
		mm.put("number", macCode);
		mm.put("username", userName);
		mm.put("cnname", cnName);
		mm.put("position", positionName);
		mm.put("page", pager);
		mm.put("list", wifiDatas);
		mm.put("pageNum", pageNum);
		return "wifi/listSearch";
	}

	/*
	 * 查询Wifi定位数据(Echars视图展示)
	 */
	@RequestMapping("showWifiData")
	@ResponseBody
	public String showWifiData(ModelMap mm, WifiData wifiData,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/javascript");
		String macCode = request.getParameter("number");
		System.out.println("-----------" + macCode);
		String positionName = request.getParameter("position");
		System.out.println("-----------" + positionName);
		String userName = request.getParameter("username");
		System.out.println("---------" + userName);
		String cnName =request.getParameter("cnname");
		String startTime = request.getParameter("startime");
		System.out.println("------" + startTime);
		String endTime = request.getParameter("endTime");
		System.out.println("-------" + endTime);
		List<WifiData> showWifiData = this.wifiDataServiceIMP
				.searchWifiDataShow(macCode, positionName, userName,cnName,startTime,endTime);
		// 转换JSON数组
		String jsonDate = JSONArray.toJSONString(showWifiData);
			System.out.println("wifi数据"+jsonDate);
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsonDate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
