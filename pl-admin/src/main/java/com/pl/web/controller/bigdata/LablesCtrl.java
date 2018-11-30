package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.Emp_Lable_target;
import com.pl.web.model.Lables;
import com.pl.web.service.impl.LablesServiceIMP;
import com.pl.web.service.impl.LablesTargetServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 标签管理Ctrl层
 * @author lihao
 *
 */
@Controller
public class LablesCtrl extends BaseController {
	//Service实现层注入
	@Autowired
	private LablesServiceIMP lablesServiceIMP;
	
	@Autowired
	private LablesTargetServiceIMP lablesTargetServiceIMP;
	
	//主界面指标列表和后天交互
	@RequestMapping("bigdata/staff/lableCtrl")
    @ResponseBody
	public TableDataInfo list(ModelMap mm, HttpServletRequest request,
                              HttpServletResponse response) throws Exception{
        startPage();
		List<Lables> labels = lablesServiceIMP.list();
        TableDataInfo tableDataInfo = getDataTable(labels);
        return tableDataInfo;
	}

	@RequestMapping("bigdata/staff/labletag")
	public String monthjob(ModelMap mm) {
		return "bigdata/staff/labletag";
	}

	//删除指标
	@RequestMapping("delLables")
	public String delete(Lables lables,ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		boolean result=this.lablesServiceIMP.del(id1);
		 if(result){
	        	System.out.println("删除成功");
	        }
//		return list(mm,request,response);
        return "bigdata/staff/labletag";
	}
	//添加指标
	@RequestMapping("addLables")
	public String add(Lables lables,ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		boolean result=this.lablesServiceIMP.addLables(lables);
		if(result){
			System.out.println("添加成功");
		}
//		return list(mm,request,response);
        return "bigdata/staff/labletag";
	}
	//更新指标
	@RequestMapping("updateLables")
	public String update(Lables lables,ModelMap mm,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		boolean result=this.lablesServiceIMP.update(lables);
		if(result){
			System.out.println("更新成功");
		}
//		return list(mm,request,response);
        return "bigdata/staff/labletag";
	}
	//更新之前的由id查询,再更新.
	@RequestMapping("updateLablesUI") 
    public String updateuserUI(Lables lables,ModelMap mm,HttpServletRequest request) throws Exception {  
        // TODO Auto-generated method stub 
		String id=request.getParameter("id");
		lables=this.lablesServiceIMP.getLablesById(id);
        	mm.put("lables",lables);
    		return "lable/listinfo";
    }
	//由Id查询标签计算指标
	@RequestMapping("addLablesUI") 
    public String addLablesUI(Lables lables,ModelMap mm,HttpServletRequest request) throws Exception {  
        // TODO Auto-generated method stub 
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		lables=this.lablesServiceIMP.getLablesById(id);
		List<Emp_Lable_target> list = this.lablesTargetServiceIMP.getLablesTargetById(id1);
        	mm.put("lables",lables);
        	mm.put("list", list);
    		return "editlabel/list";
    }
	//由Id删除标签
	@RequestMapping("delLablesTarget")
	public String delete(Emp_Lable_target labletarget,ModelMap mm,HttpServletRequest request){
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		labletarget=this.lablesTargetServiceIMP.selectLableTargetById(id1);
		Lables lables=this.lablesServiceIMP.getLablesById(String.valueOf(labletarget.getLabel_id()));
		
		boolean result=this.lablesTargetServiceIMP.deleteLableTargetById(id1);
		 if(result){
	        	System.out.println("删除成功");
	        }
		 List<Emp_Lable_target> list = this.lablesTargetServiceIMP.getLablesTargetById(labletarget.getLabel_id());
		 	mm.put("list", list);
			mm.put("lables", lables);
			return "editlabel/list";
	}
	//添加标签计算指标
	@RequestMapping("addLablesTarget")
	public String add(Emp_Lable_target labletarget,ModelMap mm,HttpServletRequest request){
		String id=request.getParameter("id");
		int a=labletarget.getLabel_id();
		boolean result=this.lablesTargetServiceIMP.add(labletarget);
		if(result){
			System.out.println("添加成功");
		}
		List<Emp_Lable_target> list = this.lablesTargetServiceIMP.getLablesTargetById(a);
		Lables lables=this.lablesServiceIMP.getLablesById(String.valueOf(a));
		mm.put("list", list);
		mm.put("lables", lables);
		return "editlabel/list";
	}
	//更新标签计算指标
	@RequestMapping("updateLablesTargetUI") 
    public String updateLablesTargetUI(Emp_Lable_target elt,ModelMap mm,HttpServletRequest request) throws Exception {  
        // TODO Auto-generated method stub
		
		boolean result=this.lablesTargetServiceIMP.updateLableTarget(elt);
		
		Lables lables=this.lablesServiceIMP.getLablesById(String.valueOf(elt.getLabel_id()));
		if(result){
			System.out.println("修改成功");
		}
		List<Emp_Lable_target> list = this.lablesTargetServiceIMP.getLablesTargetById(elt.getLabel_id());
		mm.put("list", list);
		mm.put("lables", lables);
		return "editlabel/list";
    }
}
