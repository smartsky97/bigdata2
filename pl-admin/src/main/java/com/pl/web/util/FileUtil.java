package com.pl.web.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  FileUtil {
	
	
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
	
	
	/**
	 *获取该文件夹的所有文件
	 * 
	 * @param fileName
	 * @return
	 */
	  public static ArrayList<String>  getAllFileName(String path,ArrayList<String> fileName) {
	        File file = new File(path);
	        File [] files = file.listFiles();
	        String [] names = file.list();
	        if(names != null)
	        fileName.addAll(Arrays.asList(names));
	        for(File a:files)
	        {
	            if(a.isDirectory())
	            {
	                getAllFileName(a.getAbsolutePath(),fileName);
	            }
	        }
			return fileName;
	    }
	  
	  /**
	   * @param folderXls:读取文件夹下的所有文件
	   *
	   */
		public static List folder(String folderXls ){

			 List list = new ArrayList();
			try {
				File file = new File(folderXls);
				File[] tempList = file.listFiles();
				for (int i = 0; i < tempList.length; i++) {
					if (tempList[i].isFile()) {
						list.add(tempList[i]);
					 }
					if (tempList[i].isDirectory()) { 
						list.add(tempList[i]);
					 }
				  }
			   
			    } catch (Exception e) {
			      e.printStackTrace();     
			      return list;
			    }
			return list;
		}
	
	
	
	
	
	/**
	 *获取缓存文件目录 
	 * 
	 * @param fileName
	 * @return
	 */
	public static  String getTempPath(){  
	       //取得根目录路径  
    	   String dir=System.getProperty("user.dir");
	       dir=dir + File.separator + "doc";
	       return dir;         
	   }
	
	/**
	 *获取文件目录 系统路径
	 * 
	 * @param fileName
	 * @return
	 */
	public  String getCurrentPath(){  
	       //取得根目录路径  
	       String rootPath=getClass().getResource("/").getFile().toString();  
	       //当前目录路径  
	       String currentPath1=getClass().getResource(".").getFile().toString();  
	       String currentPath2=getClass().getResource("").getFile().toString();  
	       //当前目录的上级目录路径  
	       String parentPath=getClass().getResource("../").getFile().toString();  
	          
	       return rootPath;         
	   }

	/**
	 * 创建文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean createFile(File fileName) throws Exception {
		boolean flag = false;
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	


	/**
	 * 读TXT文件内容
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readTxtFile(File fileName) throws Exception {
		String result = "";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
				String read = "";
				while ((read = bufferedReader.readLine()) != null) {
					result = result + read + "\r\n";
//					System.out.println(read);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return result;
	}

	public static boolean writeTxtFile(String content, File fileName)
			throws Exception {
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("UTF-8"));
			o.close();
			// mm=new RandomAccessFile(fileName,"rw");
			// mm.writeBytes(content);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
		return flag;
	}

	/*
	 * 如果原来有文件的则保留原来的内容，内容更新
	 */
	public static Boolean contentToTxtUpdate(String filePath, String content) {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		try {
			System.out.println(filePath);
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
//			System.out.println(s1);
			input.close();
			s1 += content;

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * 如果原来有文件的则保留原来的内容，内容更新
	 */
	public static Boolean contentAppend(String filePath, String content) {
		String s1 = new String();// 内容更新
		try {
			System.out.println(filePath);
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath),true));
			writer.append(content);
			writer.flush();//使用Buffered***时一定要先清缓冲区再关闭流
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/*
	 * 如果原来有文件的则保留原来的内容，内容更新,如果目录不存在自带创建目录
	 */
	public static Boolean contentToTxtNew(String path , String filePath, String content) {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		try {
			System.out.println(filePath);
			File pathTmp = new File(path);
			File f = new File(filePath);
			
		   if(!pathTmp.exists()){
			    pathTmp.mkdirs();
		      }
		   
			if (f.exists()) {
				System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
//			System.out.println(s1);
			input.close();
			s1 += content;

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
			System.out.println("--getAbsoluteFile--"+ f.getAbsoluteFile());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * 如果原来有文件的则覆盖更新
	 */
	public static String  contentToTxtCover(String filePath, String content) {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		File f = new File(filePath);
		try {
			if (f.exists()) {
				System.out.println("文件存在，先删除文件");
				f.delete();
				f.createNewFile();
			} else {
				System.out.println("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
			System.out.println(s1);
			input.close();
			s1 += content;

			System.out.println("-getAbsolutePath--"+f.getAbsolutePath());
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			System.out.println(filePath +"---" + content);
			e.printStackTrace();
		}
		return f.getAbsolutePath();
	}
	
	/**
	 * 读R 的 json 文件内容
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readRjson(File fileName) throws Exception {
		String result = "";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
				   if(!"x".equals(read)){
					   result = result + read + "\r\n";
				   }
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		System.out.println("读取出来的文件内容是：" + "\r\n" + result.replace("null", ""));
		return result;
	}
	
	
	 public static void main(String[] args) throws Exception {  
//	    	String dir=System.getProperty("user.dir");
//	    	FileUtil ff=new FileUtil();
//	    	System.out.println(ff.getCurrentPath());
//	    	System.out.println(FileUtil.getTempPath());
//	    	FileUtil.contentToTxtCover(dir+File.separator+"tmp.txt", dir);
//	    	String name=FileUtil.getTempPath()+ File.separator +"multipleRegression.txt";
//	    	System.out.println(name);
//	    	String namRR=readTxtFile(new File(name));
//	    	System.out.println(namRR);
		 
		 
//		 String [] fileName = getFileName("F:\\user");
////	        for(String name:fileName)
////	        {
////	            System.out.println(name);
////	        }
////	        System.out.println("--------------------------------");
//	        ArrayList<String> listFileName = new ArrayList<String>(); 
//	        getAllFileName("F:\\user",listFileName);
//	        for(String name:listFileName)
//	        {
//	        	if (name.contains(".pdf")) {
//	        		System.out.println(name);
//				}
//	        }
//	        
		 
//	    	String fileName=FileUtil.getTempPath()+ File.separator +"rjson.txt";
//			   String R_PATH="---";
		 
//			String fff= FileUtil.readTxtFile(new File("D:/t.csv"));
		   List fff= FileUtil.folder("D:/");
			
		   for (int i = 0; i < fff.size(); i++) {
		    System.out.println(fff.get(i));
		}
			  
			Boolean bb= FileUtil.contentToTxtUpdate("d:/d.csv", "d:/d.csv");
	    }
  }