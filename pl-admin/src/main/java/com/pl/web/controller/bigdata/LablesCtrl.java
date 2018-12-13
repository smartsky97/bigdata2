package com.pl.web.controller.bigdata;

import com.pl.common.base.AjaxResult;
import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.model.Emp_Lable_target;
import com.pl.web.model.Lables;
import com.pl.web.service.impl.LablesServiceIMP;
import com.pl.web.service.impl.LablesTargetServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 标签管理Ctrl层
 *
 * @author lihao
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
                              HttpServletResponse response) throws Exception {
        startPage();
        List<Lables> labels = lablesServiceIMP.list();
        TableDataInfo tableDataInfo = getDataTable(labels);
        return tableDataInfo;
    }

    @RequestMapping("bigdata/staff/labletag")
    public String labletag(ModelMap mm) {
        return "bigdata/staff/labletag";
    }

    @RequestMapping("bigdata/staff/labletagadd")
    public String labletagadd(ModelMap mm) {
        return "bigdata/staff/labletagadd";
    }

    //更新时由id查询出的结果然后更新该内容.
    @RequestMapping("bigdata/staff/labletagedit/{id}")
    public String labletagedit(@PathVariable("id") String id, ModelMap mp)
            throws Exception {
        Lables lables = this.lablesServiceIMP.getLablesById(id);
        mp.put("lable", lables);
        return "bigdata/staff/labletagedit";
    }

    //删除指标
    @RequestMapping("bigdata/staff/delLables/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") int id) throws Exception {
        boolean result = this.lablesServiceIMP.del(id);
        if (result) {
            System.out.println("删除成功");
            return toAjax(1);
        }
        return toAjax(0);
    }

    //添加指标
    @RequestMapping("bigdata/staff/addLables")
    @ResponseBody
    public AjaxResult add(Lables lables) throws Exception {
        boolean result = this.lablesServiceIMP.addLables(lables);
        if (result) {
            System.out.println("添加成功");
            return toAjax(1);
        }
//		return list(mm,request,response);
        return toAjax(0);
    }

    //更新指标
    @RequestMapping("bigdata/staff/updateLables")
    @ResponseBody
    public AjaxResult update(Lables lables) throws Exception {
        boolean result = this.lablesServiceIMP.update(lables);
        if (result) {
            System.out.println("更新成功");
            return toAjax(1);
        }
//		return list(mm,request,response);
        return toAjax(0);
    }

    //更新之前的由id查询,再更新.
    @RequestMapping("updateLablesUI")
    public String updateuserUI(Lables lables, ModelMap mm, HttpServletRequest request) throws Exception {
        // TODO Auto-generated method stub 
        String id = request.getParameter("id");
        lables = this.lablesServiceIMP.getLablesById(id);
        mm.put("lables", lables);
        return "lable/listinfo";
    }

    @RequestMapping("bigdata/staff/labletarget/{id}")
    public String labletarget(ModelMap mm, @PathVariable("id") String id) {
        Lables lable = lablesServiceIMP.getLablesById(id);
        mm.put("lable", lable);
        return "bigdata/staff/labletarget";
    }

    //由Id查询标签计算指标
    @RequestMapping("bigdata/staff/addLableslist/{id}")
    @ResponseBody
    public TableDataInfo addLablesUI(@PathVariable("id") String id) throws Exception {
        // TODO Auto-generated method stub 
        int id1 = Integer.parseInt(id);
//		lables=this.lablesServiceIMP.getLablesById(id);
        List<Emp_Lable_target> list = this.lablesTargetServiceIMP.getLablesTargetById(id1);
        TableDataInfo tableDataInfo = getDataTable(list);
        return tableDataInfo;
    }

    //由Id删除标签
    @RequestMapping("bigdata/staff/delLablesTarget/{id}")
    @ResponseBody
    public AjaxResult delete(Emp_Lable_target labletarget, ModelMap mm, HttpServletRequest request, @PathVariable String id) {
        int id1 = Integer.parseInt(id);
        boolean result = this.lablesTargetServiceIMP.deleteLableTargetById(id1);
        if (result) {
            System.out.println("删除成功");
            return toAjax(1);
        }
        return toAjax(0);
    }

    //添加标签计算指标
    @RequestMapping("bigdata/staff/addLablesTarget")
    @ResponseBody
    public AjaxResult add(Emp_Lable_target labletarget, ModelMap mm, HttpServletRequest request) {
        boolean result = this.lablesTargetServiceIMP.add(labletarget);
        if (result) {
            System.out.println("添加成功");
            return toAjax(1);
        }
        return toAjax(0);
    }

    //更新标签计算指标
    @RequestMapping("bigdata/staff/updateLablesTargetUI")
    @ResponseBody
    public AjaxResult updateLablesTargetUI(Emp_Lable_target elt) throws Exception {
        boolean result = this.lablesTargetServiceIMP.updateLableTarget(elt);
        if (result) {
            System.out.println("修改成功");
            return toAjax(1);
        }
        return toAjax(0);
    }
}
