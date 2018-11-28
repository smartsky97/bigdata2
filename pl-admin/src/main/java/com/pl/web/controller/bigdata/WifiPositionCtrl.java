package com.pl.web.controller.bigdata;

import com.pl.web.model.WifiPosition;
import com.pl.web.service.impl.WifiPostionServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 探针位置和对应探针mac管理
 * @author root
 *
 */
@Controller
public class WifiPositionCtrl{
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(WifiPositionCtrl.class);
	/*
	 * 实现注入
	 */
	@Autowired
	private WifiPostionServiceIMP wifiPostionServiceIMP;
	/*
	 * 列表展示数据
	 */
	@RequestMapping("positionList")
	public String wifiPositionList(ModelMap mm,HttpServletRequest request){
		int currentPage = 0;
		int totalRecord =this.wifiPostionServiceIMP.getDataSize();
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
		List<WifiPosition> wifis = this.wifiPostionServiceIMP.list(fromIndex, pageSize);
		mm.put("page", pager);
		mm.put("list", wifis);
		mm.put("pageNum", pageNum);
		return "wifipost/list";	
	}
	/*
	 * 添加数据
	 */
	@RequestMapping("addwifipot")
	public String AddWifiPot(ModelMap mm,WifiPosition wifiPosition,HttpServletRequest request){
		boolean result = this.wifiPostionServiceIMP.AddWifiPostion(wifiPosition);
		if(result){
			System.out.println("添加记录成功");
		}
		return wifiPositionList(mm,request);	
	}
	/*
	 * 删除数据
	 */
	@RequestMapping("DeleteWifiPot")
	public String DeleteWifPot(ModelMap mm,HttpServletRequest request){
		String id1= request.getParameter("id");
		int id = Integer.parseInt(id1);
		boolean result1 = this.wifiPostionServiceIMP.DeleteWifiPostion(id);
		if(result1){
			System.out.println("删除成功");
		}
		return wifiPositionList(mm,request);
	}
	/*
	 * 更新数据
	 */
	@RequestMapping("updateWifiPot")
	public String UpdateWifiPot(ModelMap mm,WifiPosition wifiPosition,HttpServletRequest request){
		boolean result2 = this.wifiPostionServiceIMP.updateWifiPostion(wifiPosition);
		if(result2){
			System.out.println("更新成功");
		}
		return wifiPositionList(mm,request);
	}
	/*
	 * 通过id查询
	 */
	@RequestMapping("updateWifiPostUI")
	public String getWifiPotById(ModelMap mm ,HttpServletRequest request){
			String id2= request.getParameter("id");
			int id = Integer.parseInt(id2);
			WifiPosition wifiPosition = this.wifiPostionServiceIMP.getWifiPostionId(id);
			mm.put("wifipost", wifiPosition);
			return "wifipost/listinfo";	
	}
	/*
	 * 详细查询
	 */
	@RequestMapping("searchWifiPost")
	public String searchWifiPost(ModelMap mm,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String number = request.getParameter("number");
		System.out.println(number);
		String place = request.getParameter("place");
		System.out.println(place);
		String mac = request.getParameter("mac");
		System.out.println(mac);
		int currentPage = 0;
		int totalRecord = this.wifiPostionServiceIMP.searchDataSize(number, place, mac);
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
		List<WifiPosition> wifiPositions = 
				this.wifiPostionServiceIMP.searchWifiPostion(number, place, mac, fromIndex, pageSize);
		mm.put("number", number);
		mm.put("place", place);
		mm.put("mac", mac);
		mm.put("page", pager);
		mm.put("list", wifiPositions);
		return "wifipost/listSearch";
	}
}
