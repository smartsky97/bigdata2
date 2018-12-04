package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.QualityResultPage;
import com.pl.web.service.IEmpQualityResultService;
import com.pl.web.service.impl.DepartmentServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 员工量前端结果展示
 * @author huangjz
 *
 */
@Controller
@RequestMapping("bigdata/quality")
public class EmpQualityResultControl extends BaseController {
	
	@Autowired
    private DepartmentServiceIMP departmentServiceIMP;
	@Autowired
	private IEmpQualityResultService qualityResultService;
	@RequestMapping("qualityResult")
    @ResponseBody
	public TableDataInfo qualityResult(HttpServletRequest request) throws Exception{
		String department_id = request.getParameter("department_id");
		String computeDate = request.getParameter("computeDate");
		if ("".equals(department_id)) {
			department_id=null;
		}
		if ("".equals(computeDate)) {
			computeDate=null;
		}
        startPage();
		List<QualityResultPage> list = qualityResultService.select(computeDate,department_id,getUserId());
        TableDataInfo tableDataInfo = getDataTable(list);
        return tableDataInfo;
	}

	@RequestMapping("qualityresultpage")
	public String SerachDataCtrl(ModelMap mm) {
        mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		return "bigdata/jobData/qualityresultpage";
	}
}
