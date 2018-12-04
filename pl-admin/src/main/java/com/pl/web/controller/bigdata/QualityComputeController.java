package com.pl.web.controller.bigdata;

import com.pl.framework.web.base.BaseController;
import com.pl.framework.web.page.TableDataInfo;
import com.pl.web.dto.EmpQualitySaturability;
import com.pl.web.dto.EmpTartgetQuality;
import com.pl.web.model.Department;
import com.pl.web.model.EmpQualityResult;
import com.pl.web.model.EmpQualityWeight;
import com.pl.web.model.JobTime;
import com.pl.web.service.IEmpQualityResultService;
import com.pl.web.service.IEmpQualityWeightService;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.SearchDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 工作量计算controller
 * @author songwb
 *
 */
@Controller
public class QualityComputeController extends BaseController {
	@Autowired
    private DepartmentServiceIMP departmentServiceIMP;
	
	@Autowired
    private SearchDataServiceImpl searchDataServiceImpl;
	
    Map<String, Object> model=new HashMap<String, Object>();  

	@Autowired
	private IEmpQualityWeightService empQualityWeightService;
	@Autowired
	private IEmpQualityResultService empQualityResultService;
	

	
	@RequestMapping(value="quality")
	public String getDepartment(Model model,HttpServletRequest request) throws Exception{
		String department_id =request.getParameter("department_id");
		String id =request.getParameter("id");
		System.out.println(  id+"--department_id--"+ department_id);
		
		List<Department> depts = departmentServiceIMP.getDepartments(getUserId());
		if (null!=department_id &&!"".equals(department_id)) {
		    String name=""; 	
			for (int i = 0; i < depts.size(); i++) {
				if (Integer.valueOf(depts.get(i).getId()).equals(Integer.valueOf(department_id))) {
					name=depts.get(i).getDepartment();
				}
			}
			if (null!=id &&!"".equals(id)) {
				EmpQualityWeight empQualityWeight=empQualityWeightService.getById(Integer.valueOf(id));
	            System.out.println("--empQualityWeight--"+ empQualityWeight);
	            model.addAttribute("empQualityWeight", empQualityWeight);
			    model.addAttribute("department_id",department_id);
			    System.out.println("=-departmentName--" +name);
			   model.addAttribute("departmentName",name);
			}
		}
		model.addAttribute("depts",depts);
		return "quality/edit";
	}
	
	
	/*
	 * 更新前的查询
	 */
	@RequestMapping("updateQualityWei")
	public String update(ModelMap mm,HttpServletRequest request){
			String id2 = request.getParameter("id");
		//	System.out.println(id2+"--------");
			int id=Integer.parseInt(id2);
			EmpQualityWeight empQualityWeight=empQualityWeightService.getById(id);
             System.out.println("--empQualityWeight--"+ empQualityWeight);
			mm.put("empQualityWeight", empQualityWeight);
			mm.put("depts", departmentServiceIMP.getDepartments(getUserId()));
			return "redirect:listQualiWeig.do";
	}
	
/*	
	 // 员工量列表
	@RequestMapping(value="qualist")
	public String getDeparlist(Model model , HttpServletRequest request,ModelMap modelMap) throws Exception{
		List<Department> depts = departmentServiceIMP.getDepartments();
		int pageSize = 0;

//		List<EmpQualityWeight> list = empQualityWeightService.pageShow(null, null, null, fromIndex,pageSize);

		int currentPage = 0;
		int totalRecord = empQualityWeightService.resultCount(null, null, null);
		modelMap.put("totalRecord", totalRecord);
		String pageNum = request.getParameter("pageNum");
		model.addAttribute("depts",depts);
		return "quality/list";
	}
	*/
	private double result;
	@RequestMapping("qualityWeight.do")
	public String insertQualityWeight(EmpQualityWeight empQualityWeight,Model model,HttpServletRequest request) {
//		System.out.println("EmpQualityWeight:" + empQualityWeight.getId());
		System.out.println("EmpQualityWeight:" + empQualityWeight.getMouseClickWeight());
	   
		 if (null !=empQualityWeight.getId()) {
			 int result = empQualityWeightService.update(empQualityWeight);
				System.out.println("update:" + result);
		}else{
			int result = empQualityWeightService.insert(empQualityWeight);
			System.out.println("update:" + result);
		}
		
		return "redirect:listQualiWeig.do";
	}
	
	@RequestMapping("bigdata/jobData/listQualiWeig")
    @ResponseBody
	public TableDataInfo list(HttpServletRequest request){
		String deptId = request.getParameter("department_id");
		if ("".equals(deptId)) {
			deptId=null;
		}
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		if (null ==startTime ) {
			startTime="20160901";
		}
		
		if (null ==endTime ) {
			endTime="20160931";
		}
        startPage();
		List<EmpQualityWeight> list = empQualityWeightService.pageShow(deptId, startTime, endTime,getUserId());
		
		System.out.println("---EmpQualityWeight---list --" +list);
        TableDataInfo tableDataInfo = getDataTable(list);
        return tableDataInfo;
	}

	@RequestMapping("bigdata/jobData/empqualityweight")
	public String SerachDataCtrl(ModelMap mm) {
		mm.put("depts",departmentServiceIMP.getDepartments(getUserId()));
		return "bigdata/jobData/empqualityweight";
	}
	
	@RequestMapping("qualityList.do")
	public String qualityWeightList(EmpQualityWeight empQualityWeight,Model model,HttpServletRequest request) {
		System.out.println("EmpQualityWeight:" + empQualityWeight.getEmailSendTimesWeight());
		int result = empQualityWeightService.insert(empQualityWeight);
		System.out.println("result:" + result);
		return "redirect:quality.do";
	}
	
	@RequestMapping("computeQaulityww.do")
	@Scheduled(cron="0 0 0 * * ?")
//	@Scheduled(fixedRate=2000)
	public void computeQaulityWeight() {
		
	  try {
		  long stime=0;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		 String computeData="";
		 if (null == stime+"" || 0==stime) {
			 stime=  System.currentTimeMillis();
			 computeData=sdf.format(stime);
		} else{
			 computeData=sdf.format(stime);
		}
		
		 String startime=computeData+"-01";
		 String endTime=computeData+"-31";
		System.out.println(startime+ "==工作量计算=========" +endTime);
		// 获取年月形式的格式yyyy-MM
        
		List<EmpTartgetQuality> empTartgetQuality = empQualityWeightService.selectData(null, computeData);
		System.out.println("--empTartgetQuality--" +empTartgetQuality);
		List<EmpQualitySaturability> selectSaturab = empQualityWeightService.selectSaturab(null, startime, endTime);
		System.out.println("--selectSaturab--" +selectSaturab);
		List<EmpQualityWeight> weights = empQualityWeightService.list();
		System.out.println("--selectSaturab--" +weights);

		List<JobTime> job=searchDataServiceImpl.sum("2016-09-01", "2016-09-31");
		System.out.println("--job--" +job );
		
		result = 0;
		int index = 0;
		String lastMailName = "";
		EmpQualityResult empQualityResult = new EmpQualityResult();
		
		//权重表中的每一条记录，代表一个部门
		for (EmpQualityWeight weight : weights) {
			System.out.println("---weight--" +weight);
			
			for (EmpTartgetQuality empTarQua : empTartgetQuality) {
			
				if (Integer.valueOf(empTarQua.getDeptId()).equals(weight.getDeptId())) {
						System.out.println(lastMailName +"---lastMailName---" + empTarQua.getMailName());
						System.out.println(empTarQua.getDeptId()+ "--===" +weight.getDeptId());

						result = 0;
					
					//邮箱发送次数权重1
					if (empTarQua.getTagMc().equalsIgnoreCase("email_times") && empTarQua.getTagValue() != null) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getEmailSendTimesWeight();
					
						//lync通信次数权重2
					} else if (empTarQua.getTagMc().equalsIgnoreCase("lync_times") && empTarQua.getTagValue() != null) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getLyncComuTimesWeight();
					
					 //打电话次数权重3
					} else if (empTarQua.getTagMc().equalsIgnoreCase("ipoffice_times") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getCallPhoneTimesWeight();
				
					//会议时长权重4
					} else if (empTarQua.getTagMc().equalsIgnoreCase("meetting_time") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getMeetingDuraWeight();
					
					//考核得分权重5
					} else if (empTarQua.getTagMc().equalsIgnoreCase("month_KPI") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getExamineScoreWeight();
					}
					lastMailName = empTarQua.getMailName();
					index ++;
					//数据插入  empTarQua.getMailName()
						empQualityResult = new EmpQualityResult(empTarQua.getMailName(), result, computeData);
						empQualityResultService.insert(empQualityResult);
				   }
			 }
			
			for (EmpQualitySaturability empQualitySaturability : selectSaturab) {
				if (Integer.valueOf(empQualitySaturability.getDeptId()).equals(weight.getDeptId())) {
					System.out.println("已在在empQualitySaturability里执行:");
					double saturability = 0;
					double saturabilityAdd = 0;
					double saturabilitySub = 0;
					
					//加法权重
					if ( null !=empQualitySaturability.getSaturabilityAdd() && null !=weight.getWorkSaturationAddWeight()) {
						saturabilityAdd = Double.valueOf(empQualitySaturability.getSaturabilityAdd()); 
						saturability += weight.getWorkSaturationAddWeight() * saturabilityAdd;
						System.out.println("saturabilityAdd---:" + saturability);
					}
					
					//减法权重
					if (null != empQualitySaturability.getSaturabilitySub()&& null !=weight.getWorkSaturationSubWeight()) {
						saturabilitySub = Double.valueOf(empQualitySaturability.getSaturabilitySub()); 
						saturability += weight.getWorkSaturationSubWeight() * saturabilitySub;
						System.out.println("saturabilitySub---:" + saturability);
					}
					
					EmpQualityResult empQualityResult1 = new EmpQualityResult(empQualitySaturability.getMailName(),
							                                               saturability,computeData);
					// 更新数据
					empQualityResultService.updateResult(empQualityResult1);
					System.out.println("已更新一次：" + empQualityResult1);
				}
			}
			
			for (int i = 0; i < job.size(); i++) {
				if (Integer.valueOf(job.get(i).getDepId()).equals(weight.getDeptId())) {
					System.out.println("已在在JobTime里执行:");
					double score = 0;
					double sum = 0;
					double jobTime = 0;
					
					if ( null !=job.get(i).getSum() &&null !=weight.getKeyWordWeight()) {
						 sum = Double.valueOf(job.get(i).getSum()); 
						 score+=weight.getKeyWordWeight()* sum;
						 System.out.println("--weight.getKeyWordWeight()* sum--" + score);
					}
					
					if ( null !=job.get(i).getJobTime() &&null !=weight.getJobTimeWeight()) {
						jobTime = Double.valueOf(job.get(i).getJobTime()); 
						 score+=weight.getJobTimeWeight()* jobTime;
						 System.out.println("--weight.getJobTimeWeight()* jobTime--" + score);
					}
					
					EmpQualityResult empQualityResult1 = new EmpQualityResult(job.get(i).getAccount(),score,computeData);
					// 更新数据
					 int num= empQualityResultService.updateResult(empQualityResult1);
					System.out.println(num+ "--jobTime and key work  --"+ empQualityResult1);
					
		      }
			}
		  }
		} catch (Exception e) {
              e.printStackTrace();
		}
	}
}
