package com.pl.web.test;

import java.io.File;

import com.pl.common.config.Global;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	   FileUtil.contentToTxtCover( "WebRoot/download/n.csv", "hjz232");
		String nn=File.separator;
		System.out.println("---file--" +nn);
		
		String fileName=Global.getConfig("jdbc.type");
		System.out.println("--fileName-" +fileName);
	}
}
