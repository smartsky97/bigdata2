package com.pl.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 文件下载
 * @author huangjz
 * @version 2015-11-30
 */
public class FilesDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void fileOutputStream(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String fileName = req.getParameter("fileName");
		//fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		String path ="E:/";
		String downloadPath = this.getServletContext().getRealPath("/WEB-INF/Download");
		downloadPath = String.format("%s%s%s", downloadPath, "\\", fileName);
		
		try {
			File file = new File(downloadPath);
			if (!file.exists()) {
				logger.error(String.format("找不到下载文件，URL地址为：%s。", downloadPath));
				return;
			}
			
			fileName = fileName.substring(fileName.lastIndexOf('\\') + 1);
			resp.reset();
			resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName.substring(0, fileName.indexOf('_')) + ".zip", "UTF-8"));
			resp.setHeader("Content-Type", "application/zip");
			resp.setContentType("application/force-download");
			FileInputStream inputStream = new FileInputStream(downloadPath);
			OutputStream outputStream = resp.getOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, len);
			}
			inputStream.close();
			outputStream.close();
		} catch(Exception exception) {
			logger.error(String.format("下载文件失败，URL地址为：%s。", downloadPath), exception);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		fileOutputStream(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		fileOutputStream(req, resp);
	}
}
