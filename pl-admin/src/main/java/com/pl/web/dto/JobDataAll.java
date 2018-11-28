package com.pl.web.dto;

import com.pl.common.annotation.Excel;

public class JobDataAll {
	/*
	 * 集团指标数据导出
	 */
	//姓名
	@Excel(name = "姓名")
	private String cn_name;
	//日期
	@Excel(name = "月份")
	private String month ;
	//迟到次数.
	@Excel(name = "迟到次数")
	private String chidaoTimes;
	//早退次数
	@Excel(name = "早退次数")
	private String zaoTuiTimes;
	//邮件次数
	@Excel(name = "邮件次数")
	private String emailTimes;
	//Lync通信次数
	@Excel(name = "Lync通信次数")
	private String lyncTimes;
	//Ip电话次数
	@Excel(name = "IP电话次数")
	private String ipPhoneTimes;
	//迟到时长(单位/S)
	@Excel(name = "迟到时长/S")
	private String chidaoLength;
	//早退时长(单位/S)
	@Excel(name = "早退时长/S")
	private String zaotuiLength;
	//考勤次数
	@Excel(name = "考勤天数")
	private String kaoqinTimes;
	//IP电话时长(单位/S)
	@Excel(name = "IP电话时长/S")
	private String ipPhoneLength;
	//鼠标点击量
	@Excel(name = "鼠标点击量")
	private String mouse_click;
	//键盘敲击量
	@Excel(name = "键盘敲击量")
	private String key_press;
	//考勤时长
	@Excel(name = "考勤时长/H")
	private String kaoqinLength;
	//考勤率
	@Excel(name = "考勤率")
	private String kaoqinlv;
	//饱和度加法a(8:30-17:30)
	@Excel(name = "工作饱和度(加法A)")
	private String saturabilityA;
	//会议时长(单位/H)
	@Excel(name = "会议时长/H")
	private String meetingTime;
	//文件量
	@Excel(name = "文件量")
	private String fileAppend;
	//非工作占比
	@Excel(name = "非工作占比")
	private String no_worklv;
	
	public JobDataAll(){
		
	}
	
	public String getCn_name() {
		return cn_name;
	}

	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getChidaoTimes() {
		return chidaoTimes;
	}

	public void setChidaoTimes(String chidaoTimes) {
		this.chidaoTimes = chidaoTimes;
	}

	public String getZaoTuiTimes() {
		return zaoTuiTimes;
	}

	public void setZaoTuiTimes(String zaoTuiTimes) {
		this.zaoTuiTimes = zaoTuiTimes;
	}

	public String getEmailTimes() {
		return emailTimes;
	}

	public void setEmailTimes(String emailTimes) {
		this.emailTimes = emailTimes;
	}

	public String getLyncTimes() {
		return lyncTimes;
	}

	public void setLyncTimes(String lyncTimes) {
		this.lyncTimes = lyncTimes;
	}

	public String getIpPhoneTimes() {
		return ipPhoneTimes;
	}

	public void setIpPhoneTimes(String ipPhoneTimes) {
		this.ipPhoneTimes = ipPhoneTimes;
	}

	public String getChidaoLength() {
		return chidaoLength;
	}

	public void setChidaoLength(String chidaoLength) {
		this.chidaoLength = chidaoLength;
	}

	public String getZaotuiLength() {
		return zaotuiLength;
	}

	public void setZaotuiLength(String zaotuiLength) {
		this.zaotuiLength = zaotuiLength;
	}

	public String getKaoqinTimes() {
		return kaoqinTimes;
	}

	public void setKaoqinTimes(String kaoqinTimes) {
		this.kaoqinTimes = kaoqinTimes;
	}

	public String getIpPhoneLength() {
		return ipPhoneLength;
	}

	public void setIpPhoneLength(String ipPhoneLength) {
		this.ipPhoneLength = ipPhoneLength;
	}

	public String getMouse_click() {
		return mouse_click;
	}

	public void setMouse_click(String mouse_click) {
		this.mouse_click = mouse_click;
	}

	public String getKey_press() {
		return key_press;
	}

	public void setKey_press(String key_press) {
		this.key_press = key_press;
	}

	public String getKaoqinLength() {
		return kaoqinLength;
	}

	public void setKaoqinLength(String kaoqinLength) {
		this.kaoqinLength = kaoqinLength;
	}

	public String getKaoqinlv() {
		return kaoqinlv;
	}

	public void setKaoqinlv(String kaoqinlv) {
		this.kaoqinlv = kaoqinlv;
	}

	public String getSaturabilityA() {
		return saturabilityA;
	}

	public void setSaturabilityA(String saturabilityA) {
		this.saturabilityA = saturabilityA;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	public String getFileAppend() {
		return fileAppend;
	}

	public void setFileAppend(String fileAppend) {
		this.fileAppend = fileAppend;
	}

	public String getNo_worklv() {
		return no_worklv;
	}

	public void setNo_worklv(String no_worklv) {
		this.no_worklv = no_worklv;
	}

	@Override
	public String toString() {
		return "JobDataAll [cn_name=" + cn_name + ", month=" + month
				+ ", chidaoTimes=" + chidaoTimes + ", zaoTuiTimes="
				+ zaoTuiTimes + ", emailTimes=" + emailTimes + ", lyncTimes="
				+ lyncTimes + ", ipPhoneTimes=" + ipPhoneTimes
				+ ", chidaoLength=" + chidaoLength + ", zaotuiLength="
				+ zaotuiLength + ", kaoqinTimes=" + kaoqinTimes
				+ ", ipPhoneLength=" + ipPhoneLength + ", mouse_click="
				+ mouse_click + ", key_press=" + key_press + ", kaoqinLength="
				+ kaoqinLength + ", kaoqinlv=" + kaoqinlv + ", saturabilityA="
				+ saturabilityA + ", meetingTime=" + meetingTime
				+ ", fileAppend=" + fileAppend + ", no_worklv=" + no_worklv
				+ "]";
	}

}
