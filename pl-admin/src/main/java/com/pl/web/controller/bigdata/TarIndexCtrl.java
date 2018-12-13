package com.pl.web.controller.bigdata;

import com.pl.web.model.Comparison;
import com.pl.web.model.Emp_Lable_target;
import com.pl.web.model.Tar_index;
import com.pl.web.service.impl.LablesServiceIMP;
import com.pl.web.service.impl.LablesTargetServiceIMP;
import com.pl.web.service.impl.TarIndexServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 指标计算的增加和更新页面 下拉框（比较符的封装）
 * @author luoly
 *
 */
@Controller
public class TarIndexCtrl {

	@Autowired
	private TarIndexServiceIMP tarIndexServiceIMP;
	
	@Autowired
	private LablesTargetServiceIMP lablesTargetServiceIMP;

    @Autowired
    private LablesServiceIMP lablesServiceIMP;
	
	@RequestMapping("TarIndexCtrl")
	public String list(ModelMap mm,HttpServletRequest request){
		
		List<Comparison> comparison=new ArrayList<Comparison>();
		String label_id=request.getParameter("label_id");
		int label_id1=Integer.parseInt(label_id);
		List<Tar_index> tarindex=this.tarIndexServiceIMP.findAll(label_id1);
		Comparison comp =new Comparison();
		comp.setComparison(">");
		Comparison comp1 =new Comparison();
		comp1.setComparison("<");
		Comparison comp2 =new Comparison();
		comp2.setComparison(">=");
		Comparison comp3 =new Comparison();
		comp3.setComparison("<=");
		comparison.add(comp);
		comparison.add(comp1);
		comparison.add(comp2);
		comparison.add(comp3);
		mm.put("list", tarindex);
		mm.put("comp", comparison);
		mm.put("label_id", label_id);
		return "editlabel/add";
	}

	@RequestMapping("bigdata/staff/labletargetadd/{id}")
	public String labletargetadd(ModelMap mm,@PathVariable("id") int id) {
		List<Tar_index> tarindex=this.tarIndexServiceIMP.findAll(id);
		mm.put("tarindex",tarindex);
        mm.put("labelid",id);
		return "bigdata/staff/labletargetadd";
	}

	@RequestMapping("bigdata/staff/labletargetedit/{id}")
	public String labletargetedit(ModelMap mm,@PathVariable("id") int id) {
		Emp_Lable_target lables=this.lablesTargetServiceIMP.selectLableTargetById(id);
		List<Tar_index> tarindex=this.tarIndexServiceIMP.findAll(lables.getLabel_id());
		mm.put("tarindex",tarindex);
        mm.put("lable",lables);
		return "bigdata/staff/labletargetedit";
	}

	@RequestMapping("TarIndexCtrlupdate")
	public String list1(ModelMap mm,HttpServletRequest request){
		
		List<Comparison> comparison=new ArrayList<Comparison>();
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		Emp_Lable_target elt=this.lablesTargetServiceIMP.selectLableTargetById(id1);
		List<Tar_index> tarindex=this.tarIndexServiceIMP.findAll(elt.getLabel_id());
		Comparison comp =new Comparison();
		comp.setComparison(">");
		Comparison comp1 =new Comparison();
		comp1.setComparison("<");
		Comparison comp2 =new Comparison();
		comp2.setComparison(">=");
		Comparison comp3 =new Comparison();
		comp3.setComparison("<=");
		comparison.add(comp);
		comparison.add(comp1);
		comparison.add(comp2);
		comparison.add(comp3);
		mm.put("elt", elt);
		mm.put("list", tarindex);
		mm.put("comp", comparison);
		mm.put("label_id", elt.getLabel_id());
		return "editlabel/update";
	}
}
