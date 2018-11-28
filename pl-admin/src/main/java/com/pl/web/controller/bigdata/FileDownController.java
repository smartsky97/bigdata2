package com.pl.web.controller.bigdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件下载
 * @author huangjz
 *
 */
@Controller
public class FileDownController {
	@Autowired
	
    Map<String, Object> model=new HashMap<String, Object>();  
    Map<String, Object>  map=new HashMap<String, Object>();  

	@RequestMapping("fileDown.do")
	public void file(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path=request.getParameter("fileName");
		
		if (null ==path) {
			System.out.println("--wrong--");
		}else{
		
	    OutputStream os = new BufferedOutputStream(response.getOutputStream());
	try {
		File file = new File(path);// path是根据路径和文件名拼接出来的
	    String filename = file.getName();// 获取文件名称
	    InputStream fis = new BufferedInputStream(new FileInputStream(path));
	    byte[] buffer = new byte[fis.available()];
	    fis.read(buffer);
	    fis.close();
	    response.reset();    // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
	    response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
	    response.addHeader("Content-Length", "" + file.length());
	    response.setContentType("application/octet-stream");
	    os.write(buffer);// 输出文件
	    
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			os.flush();
			os.close();
		  }
		}
	}
}
