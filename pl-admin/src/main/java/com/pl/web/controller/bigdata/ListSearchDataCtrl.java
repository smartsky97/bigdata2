package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.SerachData;
import com.pl.web.service.impl.SearchDataServiceImpl;
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
		startPage();
		List<SerachData> list = searchDataServiceImpl.list();
        TableDataInfo tableDataInfo = getDataTable(list);
        return tableDataInfo;
	}

	@RequestMapping("serachDataCtrl")
	public String SerachDataCtrl() {
	    return "bigdata/jobData/searchdata";
    }
}
