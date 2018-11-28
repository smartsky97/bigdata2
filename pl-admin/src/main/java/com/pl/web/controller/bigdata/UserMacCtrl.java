package com.pl.web.controller.bigdata;

import com.pl.web.model.UserMac;
import com.pl.web.service.impl.UserMacServiceIMP;
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
 * mac--user对应管理.
 * @author lh
 *
 */
@Controller
public class UserMacCtrl {
	/*
	 * 日志收集
	 */
	private static Logger logger = LoggerFactory.getLogger(UserMacCtrl.class);
	/*
	 * 实现注入
	 */
	@Autowired
	private UserMacServiceIMP userMacServiceIMP;
	/*
	 * 数据列表
	 */
	@RequestMapping("userMacList")
	public String UserMacList (ModelMap mm,HttpServletRequest request)throws Exception{
		int currentPage = 0;
		int totalRecord =this.userMacServiceIMP.getAllDataSize();
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
		List<UserMac> macList = this.userMacServiceIMP.list(fromIndex, pageSize);
		mm.put("page", pager);
		mm.put("list", macList);
		mm.put("pageNum", pageNum);
		return "usermac/list";
	}
	/*
	 * 删除数据
	 */
	@RequestMapping("DeleteUserMac")
	public String DeleteUserMac(ModelMap mm,HttpServletRequest request) throws Exception{
		String id1 = request.getParameter("id");
		int id =Integer.parseInt(id1);
		boolean result = this.userMacServiceIMP.DeleteUserMac(id);
		if(result){
			System.out.println("删除成功");
		}
		return UserMacList(mm,request);	
	}
	/*
	 * 添加数据
	 */
	@RequestMapping("AddUserMac")
	public String AddUserMac(UserMac userMac,ModelMap mm,HttpServletRequest request) throws Exception{
		String mac =request.getParameter("mac");
		int s =this.userMacServiceIMP.Compare(mac);
		if(s>0){
			mm.put("message", "此MAC地址已经存在,请不要重复添加!");
			return "usermac/add";
		}else{
			boolean result=this.userMacServiceIMP.AddUserMac(userMac);
			
			return UserMacList(mm,request);
			
		}
			
		
	}
	/*
	 * 更新数据
	 */
	@RequestMapping("UpdateUserMac")
	public String updateUserMac(ModelMap mm,UserMac userMac,HttpServletRequest request) throws Exception{
		String mac =request.getParameter("mac");
		int counts =this.userMacServiceIMP.Compare(mac);
		if(counts>0){
			mm.put("message", "此MAC地址已经存在,请不要重复添加!");
			return updateUserMacUI(mm,request);
		}else{
			
			boolean result1=this.userMacServiceIMP.updateUserMac(userMac);
			
			return UserMacList(mm,request);
		}
		
	}
	//更新前的查询
	@RequestMapping("updateUserMacUI")
	public String updateUserMacUI(ModelMap mm,HttpServletRequest request){
			String id2= request.getParameter("id");
			int id = Integer.parseInt(id2);
			UserMac userMac=this.userMacServiceIMP.getUserMacById(id);
			mm.put("usermac",userMac);
			return "usermac/listinfo";
	}
	/*
	 * 多条件查询
	 */
	@RequestMapping("searchUserMac")
	public String searchUserMac(ModelMap mm,HttpServletRequest request){
		String userName =request.getParameter("userName");
		System.out.println(userName);
		String mac = request.getParameter("mac");
		System.out.println(mac);
		String cnName =request.getParameter("cnName");
		int currentPage = 0;
		int totalRecord = this.userMacServiceIMP.searchDataSize(userName,cnName, mac);
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
		List<UserMac> userMacs=this.userMacServiceIMP.searchUserMac(userName,cnName,mac, fromIndex, pageSize);
		mm.put("userName", userName);
		mm.put("cnName",cnName);
		mm.put("mac", mac);
		mm.put("page", pager);
		mm.put("list", userMacs);
		mm.put("pageNum", pageNum);
		return "usermac/searchData";
		
	}
}
