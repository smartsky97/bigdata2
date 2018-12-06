package com.pl.web.controller.bigdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pl.common.base.AjaxResult;
import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.Tags;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.TagsServiceIMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class TagsListCtrl extends BaseController {
    //部门选择
    @Autowired
    private DepartmentServiceIMP departmentServiceIMP;
	
	private static Logger logger = LoggerFactory.getLogger(TagsListCtrl.class);
	//标签Service实现类注入.
	@Autowired
	private TagsServiceIMP tagsServiceIMP;
	//前段标签列表点击与后台交互.
	@RequestMapping("bigdata/staff/tagsCtrllist")
    @ResponseBody
	public TableDataInfo list(ModelMap mm, HttpServletRequest request,
                              HttpServletResponse response) throws Exception{
        startPage();
		List<Tags> tags = tagsServiceIMP.list();
        TableDataInfo tableDataInfo = getDataTable(tags);
        return tableDataInfo;
	}

    @RequestMapping("bigdata/staff/tagsCtrladd")
    public String tagsCtrladd() {
        return "bigdata/staff/tagsCtrladd";
    }

    @RequestMapping("bigdata/staff/tagsCtrl")
    public String tagsCtrl(ModelMap mm) {
//        mm.put("depts",departmentServiceIMP.getDepartments());
        return "bigdata/staff/tagsCtrl";
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
//			return list(mm,request,response);
        return null;
	}
	
	//更新标签状态.
	@RequestMapping("bigdata/staff/updateTagStatus")
    @ResponseBody
	public TableDataInfo Tagstatus(){
        startPage();
		List<Tags> tags = tagsServiceIMP.list();
        TableDataInfo tableDataInfo = getDataTable(tags);
        return tableDataInfo;
		
	}

    @RequestMapping("bigdata/staff/tarset")
    public String monthjob(ModelMap mm) {
//        mm.put("depts",departmentServiceIMP.getDepartments());
        return "bigdata/staff/tagsSet";
    }

	//删除标签.
	@RequestMapping("bigdata/staff/tagsCtrlremove/{id}")
    @ResponseBody
	public AjaxResult delete(@PathVariable("id") String id) throws Exception{
		boolean result = this.tagsServiceIMP.del(id);
		if (result) {
            System.out.println("删除成功");
            return toAjax(1);
		}
//		return list(mm,request,response);
		return toAjax(0);
	}
	//增加标签.
	@RequestMapping("bigdata/staff/addTags")
    @ResponseBody
	public AjaxResult add(Tags tags) throws Exception {
		boolean result = this.tagsServiceIMP.addTags(tags);
		if (result) {
			System.out.println("添加成功");
			return toAjax(1);
		} else {
            return toAjax(0);
        }
	}

	//更新标签
	@RequestMapping("bigdata/staff/updateTags")
    @ResponseBody
	public AjaxResult update(Tags tags, ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean result = this.tagsServiceIMP.update1(tags);
		if (result) {
			System.out.println("更新成功");
            return toAjax(1);
		}
//		return list(mm,request,response);
        return toAjax(0);
	}
	//更新时由id查询出的结果然后更新该内容.
	@RequestMapping("bigdata/staff/tagsCtrledit/{id}")
	public String updateuserUI(@PathVariable("id") String id,ModelMap mp)
			throws Exception {
		Tags tags = this.tagsServiceIMP.getTagsById(id);
        mp.put("tags",tags);
		return "bigdata/staff/tagsCtrledit";
	}
	//测试代码
	@RequestMapping("bigdata/staff/testUpdate")
    @ResponseBody
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
