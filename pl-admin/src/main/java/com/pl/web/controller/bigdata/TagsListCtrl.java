package com.pl.web.controller.bigdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pl.web.model.Tags;
import com.pl.web.service.impl.TagsServiceIMP;
import com.pl.web.util.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标签列表Ctrl类.
 * @author root
 *
 */
@Controller
public class TagsListCtrl {
	
	private static Logger logger = LoggerFactory.getLogger(TagsListCtrl.class);
	//标签Service实现类注入.
	@Autowired
	private TagsServiceIMP tagsServiceIMP;
	//前段标签列表点击与后台交互.
	@RequestMapping("tagsCtrl")
	public String list(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//当前默认为第一页
		int currentPage = 0;
		int totalRecord = tagsServiceIMP.getTagsSize();
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
		List<Tags> tags = tagsServiceIMP.list(fromIndex,pageSize);
		mm.put("page", pager);
		mm.put("list", tags);
		mm.put("pageNum", pageNum);
		return "tags/list";
	}
	//更新标签状态(设置启用或者不启用).
	@RequestMapping("editForm")
	public String updateStatus(Tags tags, ModelMap mm, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String ds = request.getParameter("postData");
			JSONArray json = JSON.parseArray(ds); // 使用net.sf.json.JSONObject对象来解析json
			JSONObject jsonOne;
			Map<String, Object> map = null;
			List<Tags> listTags = new ArrayList<Tags>();
			for (int i = 0; i < json.size(); i++) {
				Tags tags2=new Tags();
				map = new HashMap<String, Object>();
				jsonOne = json.getJSONObject(i);
				map.put("key", (String) jsonOne.get("Key"));
				map.put("value", (String) jsonOne.get("Value"));
				
				tags2.setId(map.get("key").toString());
				tags2.setStatus(map.get("value").toString());
				listTags.add(tags2);
			}
			boolean result=this.tagsServiceIMP.updateStatus(listTags);
			return list(mm,request,response);
	}
	
	//更新标签状态.
	@RequestMapping("updateTagStatus")
	public String Tagstatus(ModelMap mm,HttpServletRequest request){
		//当前默认为第一页
		int currentPage = 0;
		int totalRecord = tagsServiceIMP.getTagsSize();
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
		List<Tags> tags = tagsServiceIMP.list(fromIndex,pageSize);
		mm.put("page", pager);
		mm.put("list", tags);
		mm.put("pageNum", pageNum);
		return "tags/MyJsp";
		
	}
	//删除标签.
	@RequestMapping("delTags")
	public String delete(Tags tags, ModelMap mm, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		boolean result = this.tagsServiceIMP.del(id);
		if (result) {
			System.out.println("删除成功");
		}
		return list(mm,request,response);
	}
	//增加标签.
	@RequestMapping("addTags")
	public String add(Tags tags, ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean result = this.tagsServiceIMP.addTags(tags);
		if (result) {
			System.out.println("添加成功");
		}
		return list(mm,request,response);
	}
	//更新标签
	@RequestMapping("updateTags")
	public String update(Tags tags, ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean result = this.tagsServiceIMP.update1(tags);
		if (result) {
			System.out.println("更新成功");
		}
		return list(mm,request,response);
	}
	//更新时由id查询出的结果然后更新该内容.
	@RequestMapping("updateTagsUI")
	public String updateuserUI(ModelMap mm, HttpServletRequest request)
			throws Exception {
		String id = request.getParameter("id");
		Tags tags = this.tagsServiceIMP.getTagsById(id);
		mm.put("tags", tags);
		return "tags/listinfo";
	}
	//测试代码
	@RequestMapping("testUpdate")
	public void updateStatus(ModelMap mm , HttpServletRequest request){
		String code	= request.getParameter("id");
		System.out.println("code--"+code);
		String dict = request.getParameter("status");
		System.out.println("dict--"+dict);
		Tags tags = new Tags();
		tags.setId(code);
		tags.setStatus(dict);
		int result = this.tagsServiceIMP.update(tags);

	}
}
