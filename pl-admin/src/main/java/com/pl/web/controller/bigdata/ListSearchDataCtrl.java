package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.SerachData;
import com.pl.web.service.impl.SearchDataServiceImpl;
import com.pl.web.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("bigdata/searchdata")
public class ListSearchDataCtrl extends BaseController {
	@Autowired
    private SearchDataServiceImpl searchDataServiceImpl;
	@RequestMapping("listSerachDataCtrl")
    @ResponseBody
	public TableDataInfo list(ModelMap mm, HttpServletRequest request, HttpServletResponse response){
		
		/*List<JobTime> job=searchDataServiceImpl.sum("2016-09-01", "2016-09-31");
		System.out.println("--SerachData--" +job );
		
		for (int i = 0; i < job.size(); i++) {
			System.out.println(job.get(i));
		}*/
		
		int pageSize = 0;
		int totalRecord = searchDataServiceImpl.getSerachDataSize();
		int currentPage = Pager.DEFAULT_PAGENUM;
		String pageNum = request.getParameter("pageNum");
		if(""!=pageNum&&pageNum!=null){
		    currentPage = Integer.parseInt(pageNum);
		}
		pageSize = Pager.DEFAULT_PAGESIZE;
		Pager page = new Pager(currentPage,pageSize,totalRecord);
		int fromIndex = (page.getCurrentPage()-1)*page.getPageSize();
		List<SerachData> list = searchDataServiceImpl.list(fromIndex,pageSize);
		
		System.out.println("--list--" +list );

//		mm.put("page", page);
//		mm.put("list", list);
//		mm.put("pageNum", pageNum);
//		return "searchdata/list";
        TableDataInfo tableDataInfo = getDataTable(list);
        tableDataInfo.setTotal(list.size());
        return tableDataInfo;
	}

	@RequestMapping("serachDataCtrl")
	public String SerachDataCtrl() {
	    return "bigdata/jobData/serachDataCtrl";
    }
}
