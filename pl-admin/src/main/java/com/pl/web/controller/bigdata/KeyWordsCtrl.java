package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.web.model.KeyWords;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.KeyWordServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class KeyWordsCtrl extends BaseController {
	/*
	 * 日志收集
	 */
	private static Logger logger= LoggerFactory.getLogger(KeyWordsCtrl.class);
	/*
	 * 注入
	 */
	@Autowired
	private KeyWordServiceIMP keyWordServiceIMP;
	@Autowired
	private DepartmentServiceIMP departmentServiceIMP;
	/*
	 * 分词列表
	 */
	@RequestMapping("KeyWordList")
	public String KeyList(ModelMap mm,HttpServletRequest request){
		int currentPage = 0;
		int totalRecord =this.keyWordServiceIMP.getKeyWordsDataSize();
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
		List<KeyWords> keyWords = this.keyWordServiceIMP.list(fromIndex, pageSize);
		mm.put("list",keyWords);
		mm.put("page", pager);
		mm.put("depts", departmentServiceIMP.getDepartments(getUserId()));
		return "keyword/list";
	}
	/*
	 * 将depts转发到add.jsp
	 */
	@RequestMapping("toAdd")
	public String toAdd(ModelMap mm){
		mm.put("depts", departmentServiceIMP.getDepartments(getUserId()));
		return "keyword/add";
	}
	/*
	 * 删除分词
	 */
	@RequestMapping("DeleteKeyWord")
	public String Delete(ModelMap mm,HttpServletRequest request){
			String id1 =request.getParameter("id");
			System.out.println(id1);
			int id=Integer.parseInt(id1);
			boolean result= this.keyWordServiceIMP.Delete(id);
			if(result){
				System.out.println("删除成功");
			}
		return KeyList(mm,request);
	}
	/*
	 * 增加分词
	 */
	@RequestMapping("AddKeyWord")
	public String AddKeyWord(KeyWords keyWords,ModelMap mm,HttpServletRequest request){
		boolean result = this.keyWordServiceIMP.Add(keyWords);
		if(result){
			System.out.println("添加成功");
		}
		return KeyList(mm,request);	
	}
	/*
	 * 更新分词
	 */
	@RequestMapping("UpdateKeyWord")
	public String UpdateKeyWord(KeyWords keyWords,ModelMap mm,HttpServletRequest
			request){
		boolean result = this.keyWordServiceIMP.updateKeyWord(keyWords);
		if (result) {
			System.out.println("更新成功");
		}
		return KeyList(mm,request);
	}
	/*
	 * 更新前的查询
	 */
	@RequestMapping("updateKeyUI")
	public String updateKeyUi(ModelMap mm,HttpServletRequest request){
			String id2 = request.getParameter("id");
		//	System.out.println(id2+"--------");
			int id=Integer.parseInt(id2);
			KeyWords keyWords=this.keyWordServiceIMP.getKeyWordsById(id);
			mm.put("keywords", keyWords);
			mm.put("depts", departmentServiceIMP.getDepartments(getUserId()));
		return "keyword/listinfo";
	}
	/*
	 * 多条件查询关键词
	 */
	@RequestMapping("searchKeyWords")
	public String search(ModelMap mm,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String mailname = request.getParameter("mailname");
		System.out.println("部门---------"+mailname);
		String cname = request.getParameter("employee");
		System.out.println("员工+++++++++"+cname);
		String taskname = request.getParameter("taskname");
		System.out.println(taskname);
		String startime=request.getParameter("startime");
		System.out.println(startime);
		String endtime = request.getParameter("endtime");
		System.out.println(endtime);
		int currentPage = 0;
		int totalRecord = this.keyWordServiceIMP.getSearchKeyWordsDataSize(mailname, cname,
				startime, endtime, taskname);
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
		List<KeyWords> keyWords = this.keyWordServiceIMP.searchKeyWords(mailname, cname,
				startime, endtime, taskname, fromIndex, pageSize);
		//System.out.println(keyWords.get(0).toString());
		mm.put("mailname", mailname);
		mm.put("cname", cname);
		mm.put("taskname", taskname);
		mm.put("startime", startime);
		mm.put("endtime", endtime);
		mm.put("page", pager);
		mm.put("list", keyWords);
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		return "keyword/listSearch";
		
	}
	
}
