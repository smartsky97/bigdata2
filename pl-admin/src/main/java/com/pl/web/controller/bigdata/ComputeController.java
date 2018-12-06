package com.pl.web.controller.bigdata;

import com.pl.web.dto.EmpQualitySaturability;
import com.pl.web.dto.EmpTartgetQuality;
import com.pl.web.model.EmpQualityResult;
import com.pl.web.model.EmpQualityWeight;
import com.pl.web.model.JobTime;
import com.pl.web.service.IEmpQualityResultService;
import com.pl.web.service.IEmpQualityWeightService;
import com.pl.web.service.impl.SearchDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 工作量计算controller
 * @author huangjz
 *
 */
@Controller
public class ComputeController {
	@Autowired
    private SearchDataServiceImpl searchDataServiceImpl;
	
    Map<String, Object> model=new HashMap<String, Object>();  

	@Autowired
	private IEmpQualityWeightService empQualityWeightService;
	@Autowired
	private IEmpQualityResultService empQualityResultService;
	
	
	
	@RequestMapping("bigdata/jobData/computeQaulity")
//	@Scheduled(cron="0 0 0 * * ?")
//	@Scheduled(fixedRate=2000)
	public void computeQaulityWeight(HttpServletRequest request) {
	  try {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

//		 String computeData="2016-10";
//		 String computeData="2016-08";
		 String computeData="2016-09";
//		 String computeData=request.getParameter("computeData");
		 if (null == computeData ||"".equals(computeData)) {
			 computeData=sdf.format( System.currentTimeMillis());
			 System.out.println("---computeData--" +computeData);
		} else{
			 System.out.println("---computeData--" +computeData);
		  }
		 
		 String startime=computeData+"-01";
		 String endTime=computeData+"-31";
		
		System.out.println("工作量计算=========");
		// 获取年月形式的格式yyyy-MM
        
		List<EmpTartgetQuality> empTartgetQuality = empQualityWeightService.selectData(null,computeData);
		
		
		System.out.println("--empTartgetQuality--" +empTartgetQuality);
		List<EmpQualitySaturability> selectSaturab = empQualityWeightService.selectSaturab(null,startime ,endTime);
		System.out.println("--selectSaturab--" +selectSaturab);
		List<EmpQualityWeight> weights = empQualityWeightService.list();
		System.out.println("--selectSaturab--" +weights);

		List<JobTime> job=searchDataServiceImpl.sum(computeData+"-01", computeData+"-31");
		System.out.println("--job--" +job );
		 String text="";

		double result = 0;
		int index = 0;
		String lastMailName = "";
		EmpQualityResult empQualityResult = new EmpQualityResult();
		
		//权重表中的每一条记录，代表一个部门
		for (EmpQualityWeight weight : weights) {
			
			System.out.println("---weight--" +weight);
			
			for (EmpTartgetQuality empTarQua : empTartgetQuality) {
			
			
				if (Integer.valueOf(empTarQua.getDeptId()).equals(weight.getDeptId())) {
					if (!lastMailName.equals(empTarQua.getMailName()) && index != 0 && 0!=result)  {
					   System.out.println(lastMailName +"---lastMailName---" + empTarQua.getMailName());
						empQualityResult = new EmpQualityResult(lastMailName, result, computeData);
						empQualityResultService.insert(empQualityResult);
						result = 0;
						text = "";
					}	
					
					//邮箱发送次数权重1
					if (empTarQua.getTagMc().equalsIgnoreCase("email_times") && empTarQua.getTagValue() != null) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getEmailSendTimesWeight();
					  text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getEmailSendTimesWeight() + ")+";
						
						//lync通信次数权重2
					} else if (empTarQua.getTagMc().equalsIgnoreCase("lync_times") && empTarQua.getTagValue() != null) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getLyncComuTimesWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getLyncComuTimesWeight() + ")+";

						
					 //打电话次数权重3
					} else if (empTarQua.getTagMc().equalsIgnoreCase("ipoffice_times") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getCallPhoneTimesWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getCallPhoneTimesWeight() + ")+";

					//会议时长权重4
					} else if (empTarQua.getTagMc().equalsIgnoreCase("meetting_time") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getMeetingDuraWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getMeetingDuraWeight() + ")+";

					//考核得分权重5
					} else if (empTarQua.getTagMc().equalsIgnoreCase("month_KPI") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getExamineScoreWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getExamineScoreWeight() + ")+";

				    //键盘点击次数6
					} else if (empTarQua.getTagMc().equalsIgnoreCase("key_press_count") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getKeyboardClickWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getKeyboardClickWeight() + ")+";
                    
					//鼠标点击次数8
					} else if (empTarQua.getTagMc().equalsIgnoreCase("mouse_click_count") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getMouseClickWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getMouseClickWeight() + ")+";
		
					//月度文件增长量权重7
					  } else if (empTarQua.getTagMc().equalsIgnoreCase("month_file_growth") && empTarQua.getTagValue() != null ) {
						result += Double.valueOf(empTarQua.getTagValue()) * weight.getMonthFileGrowthWeight();
						text+=empTarQua.getTagName()+"(" + empTarQua.getTagValue()+ "*" +weight.getMonthFileGrowthWeight() + ")+";

					}
					
					
					lastMailName = empTarQua.getMailName();
					
					for (int i = 0; i < job.size(); i++) {
						if (Integer.valueOf(job.get(i).getDepId()).equals(weight.getDeptId())
								 &&null!= lastMailName&&job.get(i).getAccount().equals(lastMailName)) {
							System.out.println("已在在JobTime里执行:"+job.get(i).getAccount());
//							double score = 0;
							double sum = 0;
							double jobTime = 0;
							
							if ( null !=job.get(i).getSum() &&null !=weight.getKeyWordWeight()) {
								 sum = Double.valueOf(job.get(i).getSum()); 
								 result+=weight.getKeyWordWeight()* Double.valueOf(job.get(i).getSum());
							   text+="关键词数量"+"(" +job.get(i).getSum() + "*" +weight.getKeyWordWeight() + ") + ";

								 System.out.println("关键词数量"+"(" +job.get(i).getSum() + "*" 
								 +weight.getKeyWordWeight() + ") + " +"--weight.getKeyWordWeight()* sum--" + result);
							}
							
							if ( null !=job.get(i).getJobTime() &&null !=weight.getJobTimeWeight()) {
								jobTime = Double.valueOf(job.get(i).getJobTime()); 
								result+=weight.getJobTimeWeight()*  Double.valueOf(job.get(i).getJobTime());
								
								 text+="月度任务关键字时间"+"(" +job.get(i).getJobTime() + "*" +weight.getKeyWordWeight() + ") + ";
								 System.out.println("月度任务关键字时间"+"(" +job.get(i).getJobTime()
										 + "*" +weight.getKeyWordWeight() + ") + "+ "--weight.getJobTimeWeight()* jobTime--" + result);
							}
							System.out.println(text);
							
//							EmpQualityResult empQualityResult1 = new EmpQualityResult(i, job.get(i).getAccount(),score,computeData);
							// 更新数据
//							 int num= empQualityResultService.updateResult(empQualityResult1);
							
				      }
					}
					
					index ++;
					//数据插入  empTarQua.getMailName()
					if (index == empTartgetQuality.size() && 0!=result) {
						empQualityResult = new EmpQualityResult(empTarQua.getMailName(), result, computeData);
						empQualityResultService.insert(empQualityResult);
					   }

					}
			 }
			
			for (EmpQualitySaturability empQualitySaturability : selectSaturab) {
				
				if (null ==empQualitySaturability.getDeptId() || null ==weight.getDeptId()) {
					System.out.println("---部门 为空-");
					continue;
				}
				Integer  depid =Integer.valueOf(empQualitySaturability.getDeptId());
				Integer  depWId =weight.getDeptId();
			
				
				System.out.println(depid  +"--depid--" + depWId);
				if ((depid).equals(depWId) &&computeData.equals(empQualitySaturability.getComputeDate())) {
					System.out.println(computeData+"---" + empQualitySaturability.getComputeDate());
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
					
					text+="--工作饱和度分数--"+ saturability;
					text= computeData+":"+ lastMailName  +"-" +text;
					// 更新数据
					empQualityResultService.updateResult(empQualityResult1);
					System.out.println("已更新一次：" + empQualityResult1);
				}
			}
			
		
			System.out.println("--text--" +text);
			
			/*
			for (int i = 0; i < job.size(); i++) {
				if (Integer.valueOf(job.get(i).getDepId()).equals(weight.getDeptId())) {
					System.out.println("已在在JobTime里执行:"+job.get(i).getAccount());
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
					
					EmpQualityResult empQualityResult1 = new EmpQualityResult(i, job.get(i).getAccount(),score,computeData);
					// 更新数据
					 int num= empQualityResultService.updateResult(empQualityResult1);
					System.out.println(num+ "--jobTime and key work  --"+ empQualityResult1);
					
		      }
			}*/
		  }
		} catch (Exception e) {
              e.printStackTrace();
		}
	}
}
