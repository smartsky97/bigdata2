package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.Url;
import com.pl.web.model.UrlIndex;
import com.pl.web.service.UrlIndexServiceIMP;
import com.pl.web.service.impl.UrlServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ListUrlController extends BaseController {
	@Autowired
	private UrlServiceIMP urlServiceIMP;
	@Autowired
	private UrlIndexServiceIMP urlIndexServiceIMP;
	
	/*
	 * 页面展示URL列表
	 */
	@RequestMapping(value="bigdata/url/listUrl")
    @ResponseBody
	public TableDataInfo list(Url url) throws Exception{
        startPage();
		List<Url> urls = urlServiceIMP.getUrls(url);
        TableDataInfo tableDataInfo = getDataTable(urls);
        return tableDataInfo;
	}

	@RequestMapping("bigdata/url/url")
	public String wifidata() {
		return "bigdata/url/url";
	}

	/*
	 * 页面展示URL1(第二种方法更新url库)
	 */
	@RequestMapping(value="listUrl1")
	public String list1(ModelMap mm){
		List<Url> urls = urlServiceIMP.getUrls1();
		mm.put("urls",urls);
		return "URL/listUrl1";
		
	}
	
	@RequestMapping("urlinfo")
	public String urlInfo(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		List<UrlIndex> urlindexs = urlIndexServiceIMP.getUrlindexs();
		mm.put("urlIndexs",urlindexs);
		return "URL/urlinfo";
	}
	/*
	 * 编辑URL库数据
	 */
	@RequestMapping(value="editUrl")
	public String editUrl(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String urlName = request.getParameter("urlName");
		System.out.println("urlName--"+urlName);
		Url url = urlServiceIMP.getUrlByName(urlName);
		System.out.println("url类是什么东西"+url);
		List<UrlIndex> urlindexs = urlIndexServiceIMP.getUrlindexs();
		mm.put("urlIndexs", urlindexs);
		mm.put("url", url);
		return "URL/urlinfo";
	}
	/*
	 * 更新URL库
	 */
	@RequestMapping(value="updateUrl")
	public String updateUrl(ModelMap mm,HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		String urlName = request.getParameter("urlName");
		String urlType1 = request.getParameter("urlType");
		int urlType =Integer.parseInt(urlType1);
		Url url = new Url();
		url.setUrlName(urlName);
		url.setUrlType(urlType);
		urlServiceIMP.updateUrl(url);
		return wifidata();
	}
	/*
	 * 添加数据
	 */
	@RequestMapping(value="addUrl")
	public String addUrl(ModelMap mm,HttpServletRequest request,  
            HttpServletResponse response) throws Exception{
		String urlName = request.getParameter("urlName");
		String urlType1 = request.getParameter("urlType");
		int urlType =Integer.parseInt(urlType1);
		int numbers =this.urlServiceIMP.compareURL(urlName);
		if(numbers >0){
			mm.put("meage","URL已经存在,请不要重复添加!");
			return urlInfo(mm,request,response);
		}else{
		Url url = new Url();
		url.setUrlName(urlName);
		url.setUrlType(urlType);
		this.urlServiceIMP.saveUrl(url);
		return wifidata();
		}
	}
	/*
	 * 删除URL库数据
	 */
	@RequestMapping(value="deleteUrl")
	public String deleteUrl(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String urlName = request.getParameter("urlName");
		this.urlServiceIMP.deleteUrl(urlName);
		return wifidata();
	}
	/*
	 * 保存数据
	 */
/*	@RequestMapping(value="saveUrls")
	public String saveUrls(ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
	       try{
			String[] urlNames = request.getParameterValues("urlName");
			String[] urlTypes = request.getParameterValues("urlType");
			for(int i=0;i<urlNames.length;i++){
				Url url = new Url(urlNames[i],urlTypes[i]);
				urlServiceIMP.saveUrl(url);
				urlServiceIMP.deleteUrl1(url);
			}
			mm.put("urls", urlServiceIMP.getUrls1());}
	       catch(NullPointerException e){
	    	   return list(mm,request,response);
	       }
			return list1(mm);
	} */
	
	/*
	 * 查询数据URL数据
	 */
	@RequestMapping("searchUrl")
	public String SearchUrl(ModelMap mm,HttpServletRequest request){
			String urlName1 = request.getParameter("urlName");
			String urlName =urlName1.toLowerCase();
			System.out.println("URL名称--"+ urlName);
			String urlType = request.getParameter("urlType");
			System.out.println("URL类型--"+ urlType);
			List<UrlIndex> listURIndexs =this.urlIndexServiceIMP.getUrlindexs();
			List<Url> listUrl = this.urlServiceIMP.SearchURL(urlName, urlType);
			//System.out.println(listUrl.get(0).toString());
			mm.put("urlIndexs", listURIndexs);
			mm.put("urls", listUrl);
			mm.put("urlType", urlType);
			mm.put("urlName", urlName1);
			return "URL/searchUrl";
		
	}
}

