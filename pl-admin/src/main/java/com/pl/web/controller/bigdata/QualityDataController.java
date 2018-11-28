package com.pl.web.controller.bigdata;

import com.pl.common.config.Global;
import com.pl.web.dto.EmpQualitySaturability;
import com.pl.web.dto.EmpTartgetQuality;
import com.pl.web.model.*;
import com.pl.web.service.IEmpQualityResultService;
import com.pl.web.service.IEmpQualityWeightService;
import com.pl.web.service.impl.DepartmentServiceIMP;
import com.pl.web.service.impl.SearchDataServiceImpl;
import com.pl.web.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工作量计算controller
 * @author huangjz
 *
 */
@Controller
public class QualityDataController {
	@Autowired
    private SearchDataServiceImpl searchDataServiceImpl;
	
    Map<String, Object> model=new HashMap<String, Object>();  
    Map<String, Object>  map=new HashMap<String, Object>();  
    
	private static PrintWriter writer = null;


	@Autowired
	private IEmpQualityWeightService empQualityWeightService;
	@Autowired
	private IEmpQualityResultService empQualityResultService;
	
	@Autowired
    private DepartmentServiceIMP departmentServiceIMP;

	
	@RequestMapping("lisQaulity.do")
	public String lisQaulity(Model model,HttpServletRequest request, HttpServletResponse response) {
		List<Department> depts = departmentServiceIMP.getDepartments();
		String allId=request.getParameter("allId");
      String department_id=request.getParameter("department_id");
	 String computeDate=request.getParameter("computeDate");
	 String fileName ="";
	
	 List<EmpQuality> empQuality =new ArrayList<EmpQuality>();
     
	 if (null == computeDate) {
		 computeDate=null;
	  }
	 if ("".equals(department_id)) {
		 department_id=null;
	}
	 
	if (null == allId && null ==department_id) {
//		 department_id="010110"; // 财务部
		 System.out.println( "-- no department ---");
	 }
	
	try {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		 
		 String text="";

//		 String computeDate="2016-10";
//		 String computeDate="2016-08";

		 String mailName=request.getParameter("mailName");

		//http://localhost:8080/fantasia.draw.web/lisQaulity.do?department_id=10110 
		
		 
		 if (null == computeDate ||"".equals(computeDate)) {
			 computeDate=sdf.format( System.currentTimeMillis());
			 System.out.println("---computeDate--" +computeDate);
		} else{
			 System.out.println("---computeDate--" +computeDate);
		  }
		 
		 
		 String startime=null;
		 String endTime=null;
		 
		 if (null !=computeDate) {
			 startime=computeDate+"-01";
			  endTime=computeDate+"-31";
		}
		  
		
//		 String startime="2016-01-01";
//		 String endTime="2016-10-31";
		
		System.out.println("工作量计算=========");
		// 获取年月形式的格式yyyy-MM
        

		List<EmpTartgetQuality> empTartgetQuality = empQualityWeightService.selectDaByDept(mailName, department_id,computeDate);
		System.out.println("--empTartgetQuality--" +empTartgetQuality);
		
		List<EmpQualitySaturability> selectSaturab = empQualityWeightService.selectSaturabByDept(mailName, department_id,startime, endTime);

		
		System.out.println("--selectSaturab--" +selectSaturab);
		
		
		List<JobTime> job=searchDataServiceImpl.sum(computeDate+"-01", computeDate+"-31");
		
		System.out.println("--job--" +job );
		
		
	    EmpQuality qua= new EmpQuality();
		int z=0;
		
		int index = 0;
		double result = 0;

		for (int i = 0; i < empTartgetQuality.size(); i++) {
           if (null !=qua.getMailName() &&!empTartgetQuality.get(i).getMailName().equals(qua.getMailName())) {
	   			System.out.println(z++ + "---qua--" +qua);
	   			empQuality.add(qua);
	   			qua= new EmpQuality();
		    }
			
			qua.setChinaName(empTartgetQuality.get(i).getChinaName());
			qua.setMailName(empTartgetQuality.get(i).getMailName());
            qua.setDeptId(empTartgetQuality.get(i).getDeptId());
            qua.setComputeDate(empTartgetQuality.get(i).getComputeDate());
            
            for (int j = 0; j < depts.size(); j++) {
	        	if (null != empTartgetQuality.get(i).getDeptId() && empTartgetQuality.get(i).getDeptId().equals(depts.get(j).getId()) ) {
	        		qua.setDepartment(depts.get(j).getDepartment());
				}
			}
			 
			//邮箱发送次数权重1
			if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("email_times") && empTartgetQuality.get(i).getTagValue() != null) {
				qua.setEmailSendTimes(empTartgetQuality.get(i).getTagValue());
				
			//lync通信次数权重2
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("lync_times") && empTartgetQuality.get(i).getTagValue() != null) {
				qua.setLyncComuTimes (empTartgetQuality.get(i).getTagValue());
				
			 //打电话次数权重3
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("ipoffice_times") && empTartgetQuality.get(i).getTagValue() != null ) {
				qua.setCallPhoneTimes (empTartgetQuality.get(i).getTagValue());

			//会议时长权重4
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("meetting_time") && empTartgetQuality.get(i) != null ) {
				qua.setMeetingDura (empTartgetQuality.get(i).getTagValue());

			//考核得分权重5
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("month_KPI") && empTartgetQuality.get(i) != null ) {
				qua.setExamineScore(empTartgetQuality.get(i).getTagValue());

		    //键盘点击次数6
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("key_press_count") && empTartgetQuality.get(i) != null ) {
				qua.setKeyboardClick (empTartgetQuality.get(i).getTagValue());

			//鼠标点击次数8
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("mouse_click_count") && empTartgetQuality.get(i) != null ) {
				qua.setMouseClick (empTartgetQuality.get(i).getTagValue());

			//月度文件增长量权重7  month_file_growth
			  } else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("month_file_growth") && empTartgetQuality.get(i) != null ) {
			    qua.setMonthFileGrowth(empTartgetQuality.get(i).getTagValue());
			
			  //审批次数8   approve_times
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("approve_times") && empTartgetQuality.get(i) != null ) {
				qua.setApproveTimes(empTartgetQuality.get(i).getTagValue());
				
			  //平均审批效率9  approve_availTime
			} else if (empTartgetQuality.get(i).getTagMc().equalsIgnoreCase("approve_availTime") && empTartgetQuality.get(i) != null ) {
				qua.setApproveAvailTime(empTartgetQuality.get(i).getTagValue());
			}
			
			for (int j = 0; j < selectSaturab.size(); j++) {
				
				if (null!=empTartgetQuality.get(i).getMailName()
						 &&selectSaturab.get(j).getMailName().equals(empTartgetQuality.get(i).getMailName())
						 &&selectSaturab.get(j).getComputeDate().equals(empTartgetQuality.get(i).getComputeDate())) {
//				    qua.setMonthFileGrowth(empTartgetQuality.get(i).getTagValue());
				    qua.setWorkSaturationAdd(selectSaturab.get(j).getSaturabilityAdd());
				    qua.setWorkSaturationSub(selectSaturab.get(j).getSaturabilitySub());
				}
			}
			
			
			for (int j = 0; j < job.size(); j++) {
				if (null!=job.get(j).getName()
						&&job.get(j).getName().equals(empTartgetQuality.get(i).getChinaName())) {
					qua.setKeyWord(job.get(j).getSum()); 
				    qua.setJobTime(job.get(j).getJobTime()); 
				}
			}
			
			index ++;
			if (index == empTartgetQuality.size() &&  null !=qua.getMailName()) {
				System.out.println(z++ + "---qua--" +qua);
	   		 	empQuality.add(qua);
			   }
		}
		
		//计算部门平均值
	    EmpQuality depAvg= new EmpQuality();
	    
	    for (int j = 0; j < empQuality.size(); j++) {
			int y=0;
			
	    	if (null != empQuality.get(j).getEmailSendTimes()) {
				y++;
			}
		  }
	    
//        boolean bb= CSVUtils.genCsv("E:/11.csv", dataList);
         
         FileOutputStream out=null;
         OutputStreamWriter osw=null;
         BufferedWriter bw=null;
         boolean isSucess;
		try {
			
			if (File.separator.equals("\\")) {
				String name= Global.getConfig("download");
				fileName = name +File.separator+"QualityData.csv";
			}else{
				//进入 linux环境的路径
				String name= Global.getConfig("downloadLinux");
				fileName = name +File.separator+"QualityData.csv";
			}
			
			//文件输出流
             out = new FileOutputStream(fileName);
             osw = new OutputStreamWriter(out, "UTF-8");
             bw =new BufferedWriter(osw);
             bw.append("姓名,关键字总数,月度关键字工作时间和,考核得分,月度文件增长量,键盘敲击量总,鼠标敲击量,工作饱和度(加法),工作饱和度(减法),邮箱发送次数,lync通信次数,会议时长,打电话次数,审批次数,平均审批效率,统计时间").append("\r");
             for (int j = 0; j < empQuality.size(); j++) {
            	 String line=empQuality.get(j).getChinaName()+","
                         +empQuality.get(j).getKeyWord()+","
            			 +empQuality.get(j).getJobTime()+","
                         +empQuality.get(j).getExamineScore()+","
            			 +empQuality.get(j).getMonthFileGrowth()+","
            			 +empQuality.get(j).getKeyboardClick()+","
    					 +empQuality.get(j).getMouseClick()+","
            			 +empQuality.get(j).getWorkSaturationAdd()+","
            		     +empQuality.get(j).getWorkSaturationSub()+","
                         +empQuality.get(j).getEmailSendTimes()+","
                		 +empQuality.get(j).getLyncComuTimes()+","
            			 +empQuality.get(j).getMeetingDura()+","
    					 +empQuality.get(j).getCallPhoneTimes()+","
    					 +empQuality.get(j).getApproveTimes()+","
    					 +empQuality.get(j).getApproveAvailTime()+","
            			 +empQuality.get(j).getComputeDate();
            	 bw.append(line.replace("null", "0")).append("\r");
				
			  }
             System.out.println("--文件完成了--" +fileName);
             isSucess=true;
         } catch (Exception e) {
             isSucess=false;
         }finally{
             if(bw!=null){
                 try {
                     bw.close();
                     bw=null;
                 } catch (IOException e) {
                     e.printStackTrace();
                 } 
             }
             if(osw!=null){
                 try {
                     osw.close();
                     osw=null;
                 } catch (Exception e) {
                     e.printStackTrace();
                 } 
             }
             if(out!=null){
                 try {
                     out.close();
                     out=null;
                 } catch (Exception e) {
                     e.printStackTrace();
                 } 
             }
         }
	    
		} catch (Exception e) {
              e.printStackTrace();
		}
    	model.addAttribute("fileName",fileName);
 	    model.addAttribute("depts",depts);
		model.addAttribute("department_id",department_id);
		model.addAttribute("list",empQuality);
		model.addAttribute("computeDate",computeDate);

		return "quality/value";
	}
	
	@RequestMapping("fileQaulity.do")
	public void computeQaulityWeight(HttpServletRequest request, HttpServletResponse response) {
	  try {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		 
		 String text="";

//		 String computeDate="2016-10";
//		 String computeDate="2016-08";
		 String computeDate="2016-09";
//		 String computeDate=request.getParameter("computeDate");
		 String mailName=request.getParameter("mailName");
		 String department_id=request.getParameter("department_id");
		 
		 if (null ==mailName) {
			System.out.println( "-- wrong ---");
		}
		 
		 if (null == computeDate ||"".equals(computeDate)) {
			 computeDate=sdf.format( System.currentTimeMillis());
			 System.out.println("---computeDate--" +computeDate);
		} else{
			 System.out.println("---computeDate--" +computeDate);
		  }
		 
		 String startime=computeDate+"-01";
		 String endTime=computeDate+"-31";
		
		
		System.out.println("工作量计算=========");
		// 获取年月形式的格式yyyy-MM
        
		List<EmpTartgetQuality> empTartgetQuality = empQualityWeightService.selectData(mailName,computeDate);
		System.out.println("--empTartgetQuality--" +empTartgetQuality);
		
		text+= computeDate+":"+empTartgetQuality.get(0).getChinaName() ;
				
		List<EmpQualitySaturability> selectSaturab = empQualityWeightService.selectSaturab(mailName,startime, endTime);
		System.out.println("--selectSaturab--" +selectSaturab);
		List<EmpQualityWeight> weights = empQualityWeightService.list();
		System.out.println("--bdweights--" +weights);

		List<JobTime> job=searchDataServiceImpl.sum(computeDate+"-01", computeDate+"-31");
		System.out.println("--job--" +job );
		
		double result = 0;
		String  conten = "";
		int index = 0;
		String lastMailName = "";
		EmpQualityResult empQualityResult = new EmpQualityResult();
		
		//权重表中的每一条记录，代表一个部门
		for (EmpQualityWeight weight : weights) {
			System.out.println("---weight--" +weight);
			
			for (EmpTartgetQuality empTarQua : empTartgetQuality) {
			
				if (Integer.valueOf(empTarQua.getDeptId()).equals(weight.getDeptId())) {
						
//					text+=empTarQua +""+weight;
					System.out.println("--text--"+ text);
					
					if (!lastMailName.equals(empTarQua.getMailName()) && index != 0 && 0!=result)  {
					   System.out.println(lastMailName +"---lastMailName---" + empTarQua.getMailName());
						empQualityResult = new EmpQualityResult(lastMailName, result, computeDate);
//						empQualityResultService.insert(empQualityResult);
						result = 0;
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
					index ++;
					//数据插入  empTarQua.getMailName()
					if (index == empTartgetQuality.size() && 0!=result) {
						empQualityResult = new EmpQualityResult(empTarQua.getMailName(), result, computeDate);
						empQualityResultService.insert(empQualityResult);
					   }
					}
			 }
			
			

			for (int i = 0; i < job.size(); i++) {
				if (Integer.valueOf(job.get(i).getDepId()).equals(weight.getDeptId())
						 &&null!= mailName&&job.get(i).getAccount().equals(mailName)) {
					System.out.println("已在在JobTime里执行:"+job.get(i).getAccount());
					double score = 0;
					double sum = 0;
					double jobTime = 0;
					
					if ( null !=job.get(i).getSum() &&null !=weight.getKeyWordWeight()) {
						 sum = Double.valueOf(job.get(i).getSum()); 
						 score+=weight.getKeyWordWeight()* sum;
					   text+="关键词数量"+"(" +job.get(i).getSum() + "*" +weight.getKeyWordWeight() + ") + ";

						 System.out.println("--weight.getKeyWordWeight()* sum--" + score);
					}
					
					if ( null !=job.get(i).getJobTime() &&null !=weight.getJobTimeWeight()) {
						jobTime = Double.valueOf(job.get(i).getJobTime()); 
						 score+=weight.getJobTimeWeight()* jobTime;
						
						 text+="月度任务关键字时间"+"(" +job.get(i).getJobTime() + "*" +weight.getKeyWordWeight() + ") + ";
						 System.out.println("--weight.getJobTimeWeight()* jobTime--" + score);
					}
					
					EmpQualityResult empQualityResult1 = new EmpQualityResult(i, job.get(i).getAccount(),score,computeDate);
					// 更新数据
//					 int num= empQualityResultService.updateResult(empQualityResult1);
					System.out.println("--jobTime and key work  --"+ empQualityResult1);
					text+=(result +score);
					System.out.println("--text--" +text);
		      }
			}
			
			
			System.out.println(  "---selectSaturab--" +selectSaturab);
			if (1!=selectSaturab.size() && null!=selectSaturab&&selectSaturab.toString().length() >15) {
				System.out.println(  "---selectSaturab.size()--" +selectSaturab.size());
			for (EmpQualitySaturability empQualitySaturability : selectSaturab) {
				
				
				if (null ==empQualitySaturability.getDeptId() || null ==weight.getDeptId()) {
					System.out.println("---部门 为空-");
					continue;
				}
				Integer  depid =Integer.valueOf(empQualitySaturability.getDeptId());
				Integer  depWId =weight.getDeptId();
				
				System.out.println(depid  +"--depid--" + depWId);
				if (Integer.valueOf(empQualitySaturability.getDeptId()).equals(weight.getDeptId()) &&computeDate.equals(empQualitySaturability.getComputeDate())) {
					System.out.println(computeDate+"---" + empQualitySaturability.getComputeDate());
					System.out.println("已在在empQualitySaturability里执行:");
					double saturability = 0;
					double saturabilityAdd = 0;
					double saturabilitySub = 0;
					
					System.out.println("--text--"+ text+"-"+empQualitySaturability);

					
					//加法权重
					if ( null !=empQualitySaturability.getSaturabilityAdd() && null !=weight.getWorkSaturationAddWeight()) {
						saturabilityAdd = Double.valueOf(empQualitySaturability.getSaturabilityAdd()); 
						saturability += weight.getWorkSaturationAddWeight() * saturabilityAdd;
						
						text+="工作饱和度加法"+"(" +saturabilityAdd + "*" +weight.getWorkSaturationAddWeight()  + ")+";

						System.out.println("saturabilityAdd---:" + saturability);
					}
					
					//减法权重
					if (null != empQualitySaturability.getSaturabilitySub()&& null !=weight.getWorkSaturationSubWeight()) {
						saturabilitySub = Double.valueOf(empQualitySaturability.getSaturabilitySub()); 
						saturability += weight.getWorkSaturationSubWeight() * saturabilitySub;
						text+="工作饱和度减法"+"(" +saturabilitySub + "*" +weight.getWorkSaturationSubWeight()  + ")+";

						System.out.println("saturabilitySub---:" + saturability);
					}
					
					EmpQualityResult empQualityResult1 = new EmpQualityResult(empQualitySaturability.getMailName(),
							                                               saturability,computeDate);
					// 更新数据
//					empQualityResultService.updateResult(empQualityResult1);
					System.out.println("已更新一次：" + empQualityResult1);
				}
			  }
			}	
			
			String fileName=Global.getConfig("download");
			
			String path= FileUtil.contentToTxtCover(fileName +lastMailName, text);
			
			System.out.println( "---path--" +path);
			response.setCharacterEncoding("UTF-8"); // 防止乱码
			response.setContentType("application/json;charset=utf-8");
			writer = response.getWriter();
			
			writer.write("下载" +"${pageContext.request.contextPath}/files/servlet/filesDownloadServlet");
			System.out.println("json字符串:" + text);
			writer.flush();
			writer.close();

		  }
		} catch (Exception e) {
              e.printStackTrace();
		}
	}
}
