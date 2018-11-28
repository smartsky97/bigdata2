package com.pl.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.pl.common.config.Global;

/**   
 * CSV操作(导出和导入)
 *
 * @author huangjz
 * @version 1.0  1204, 2015 4:30:58 PM   
 */
public class CSVUtils {
    
	static  String ip=Global.getConfig("mysql.ip");
    private static Logger log = LoggerFactory.getLogger(CSVUtils.class);
	static Gson gson=new Gson();
 	static  List<String> dataList=new ArrayList<String>();
	static List<String> twList;
	
	
	public static boolean genCsv(String file, List<String> dataList) throws Exception {
		{
			FileWriter fw = new FileWriter(file);
			try {
				for (int i = 0; i < dataList.size(); i++) {
					StringBuffer str = new StringBuffer();
					System.out.println("*dataList.get(i)---"+dataList.get(i));
					 str.append(dataList.get(i) +"\r");
					fw.write(str.toString());
				 }
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}finally{
				fw.flush();
				fw.close();
				log.info(file);
			}
		}
		return true;
	}
	


    /**
     * 导出
     * 
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataBw 数据
     * @return
     * @throws Exception 
     */
	public static boolean exportCsv(File file, List<String> dataList) throws Exception{
		   File fi2 = new File(file.getName());
		    if(fi2.exists()){
		     boolean d = file.delete();
		     if(d){
		        System.out.print("文件存在，删除文件");
		      }else{
		         System.out.print("文件不存在，新建文件");
		       }
		    }
		    
		    FileOutputStream out=null;
	        OutputStreamWriter osw=null;
	        BufferedWriter bw=null;
	        	//文件输出流
	            out = new FileOutputStream(file);
	            osw = new OutputStreamWriter(out, "UTF-8");
	            bw =new BufferedWriter(osw);
		    
	   try {
		   if (dataList.size()==1) {
			   
			  
			 String str= (dataList+"");
			 
			 String[]  arr=str.split("],");
			 
			 for (int i = 0; i < arr.length-1; i++) {
			   if (null !=arr[i]) {
				   String tmp=arr[i].substring(arr[i].indexOf("[")+1 , arr[i].length());
				   bw.append(tmp).append("\r");
				   System.out.println( i+"----"+ tmp);
      			}	 
			 }
			 
			 System.out.println(arr[arr.length-1]);
			 String tmp=arr[arr.length-1].substring(arr[arr.length-1].indexOf("[")+1,  arr[arr.length-1].length() -3);
			 bw.append(tmp).append("\r");
			 
	  	 }else{
        boolean isSucess=false;
        List<String> dataBw=new ArrayList<String>();
        dataBw=dataList;
        	//文件输出流
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out, "UTF-8");
            bw =new BufferedWriter(osw);
            System.out.println(dataBw);
            
            if (isSucess) {
				
			}
            
            
            if(dataBw!=null && !dataBw.isEmpty()){
                for(String data : dataBw){
                	System.out.println(data);
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
            
        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
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
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }        
        log.info("--exportCsv--" +file.getName());
		return false;
    }
    
    /**
     * 导入
     * 
     * @param file csv文件(路径+文件)
     * @return
     */
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
    
    public static void main(String[] args) throws Exception {

        List<String> dataList=new ArrayList<String>();
        dataList.add("[EmpQuality [id=null, deptId=010110, department=null, mailName=caor, chinaName=曹蕤, keyWord=null, "
        		+ "jobTime=null, examineScore=0, monthFileGrowth=null, keyboardClick=null, mouseClick=null, workSaturationAdd=null, workSaturationSub=null, emailSendTimes=56, lyncComuTimes=27, meetingDura=21600, callPhoneTimes=12, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=chengyh, chinaName=陈艳辉, keyWord=null, jobTime=null, examineScore=0, monthFileGrowth=null, keyboardClick=null, mouseClick=null, workSaturationAdd=0.394047619047619, workSaturationSub=0.7329464285714284, emailSendTimes=14, lyncComuTimes=26, meetingDura=7200, callPhoneTimes=6, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=chenpei, chinaName=陈沛, keyWord=499, jobTime=40284, examineScore=0, monthFileGrowth=null, keyboardClick=8871, mouseClick=91, workSaturationAdd=0.3639947089947096, workSaturationSub=0.8155291005291003, emailSendTimes=243, lyncComuTimes=16, meetingDura=21600, callPhoneTimes=1, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=huangdn, chinaName=黄冬娜, keyWord=672, jobTime=24807, examineScore=0, monthFileGrowth=null, keyboardClick=7739, mouseClick=837, workSaturationAdd=0.47533189033188883, workSaturationSub=0.8037351190476189, emailSendTimes=77, lyncComuTimes=14, meetingDura=28800, callPhoneTimes=7, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=hulj, chinaName=胡礼杰, keyWord=440, jobTime=21208, examineScore=0, monthFileGrowth=null, keyboardClick=3396, mouseClick=56, workSaturationAdd=0.24973544973544984, workSaturationSub=0.7766936507936492, emailSendTimes=166, lyncComuTimes=17, meetingDura=28800, callPhoneTimes=10, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=lirz, chinaName=李如振, keyWord=392, jobTime=38130, examineScore=0, monthFileGrowth=null, keyboardClick=4294666552, mouseClick=4294684781, workSaturationAdd=0.5735044642857148, workSaturationSub=1.0345592403628108, emailSendTimes=344, lyncComuTimes=14, meetingDura=21600, callPhoneTimes=9, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=lixiao, chinaName=黎潇, keyWord=510, jobTime=14335, examineScore=0, monthFileGrowth=null, keyboardClick=2130304100, mouseClick=2130567200, workSaturationAdd=0.4088596491228067, workSaturationSub=0.7673065476190477, emailSendTimes=131, lyncComuTimes=14, meetingDura=21600, callPhoneTimes=4, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=shenfh, chinaName=沈芳华, keyWord=399, jobTime=10505, examineScore=0, monthFileGrowth=null, keyboardClick=2147331006, mouseClick=2147348583, workSaturationAdd=0.5965476190476188, workSaturationSub=1.0148591909882205, emailSendTimes=90, lyncComuTimes=139, meetingDura=28800, callPhoneTimes=30, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=shengll, chinaName=盛璐璐, keyWord=null, jobTime=null, examineScore=0, monthFileGrowth=null, keyboardClick=2130298780, mouseClick=2130567787, workSaturationAdd=0.6454067460317455, workSaturationSub=1.0689393939393932, emailSendTimes=211, lyncComuTimes=124, meetingDura=21600, callPhoneTimes=2, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=wangdan1, chinaName=王丹, keyWord=null, jobTime=null, examineScore=0, monthFileGrowth=null, keyboardClick=4260603958, mouseClick=4261134706, workSaturationAdd=0.4132718253968251, workSaturationSub=0.8116223155929054, emailSendTimes=33, lyncComuTimes=31, meetingDura=21600, callPhoneTimes=3, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=zhanghj, chinaName=张涵婧, keyWord=null, jobTime=null, examineScore=0, monthFileGrowth=null, keyboardClick=2147364443, mouseClick=2147316428, workSaturationAdd=0.5010410830999079, workSaturationSub=0.9511534391534409, emailSendTimes=91, lyncComuTimes=64, meetingDura=21600, callPhoneTimes=21, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=zhangn, chinaName=张旎, keyWord=null, jobTime=null, examineScore=0, monthFileGrowth=null, keyboardClick=null, mouseClick=null, workSaturationAdd=0.2961416361416357, workSaturationSub=0.8468568121693107, emailSendTimes=155, lyncComuTimes=54, meetingDura=21600, callPhoneTimes=27, computeDate=null], EmpQuality [id=null, deptId=010110, department=null, mailName=zhongyf, chinaName=钟玉凡, keyWord=434, jobTime=17572, examineScore=0, monthFileGrowth=null, keyboardClick=null, mouseClick=null, workSaturationAdd=0.30750793650793656, workSaturationSub=0.7403287981859428, emailSendTimes=214, lyncComuTimes=11, meetingDura=21600, callPhoneTimes=6, computeDate=null]]");
       boolean bb= CSVUtils.exportCsv(new File("E:/1122.csv"), dataList);
	    
       System.out.println("=---bbb---" +bb);
    	
    	/* int isSuccess=CSVUtils.writeChina("D://12"+ ne.nextInt(9000) +"12G.csv",
        		"SELECT * FROM GuangX_CHN_CO_SchoolsStatistics limit 1 "
    		    , "GuangX_CHN_CO_SchoolsStatistics", "D://"+ne.nextInt(9000) + "s.zip", "45");
        System.out.println(isSuccess);*/
	}
}