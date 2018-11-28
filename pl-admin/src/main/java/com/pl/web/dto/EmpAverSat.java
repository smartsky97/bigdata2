package com.pl.web.dto;

public class EmpAverSat {
	/*
	 * 员工姓名
	 */
	private String mailname;
	/*
	 * 日期
	 */
	private String date;
	/*
	 * 工作饱和度加法
	 */
	private String saturabilityAdd;
	/*
	 * 工作饱和度减法
	 */
	private String saturabilityDown;
	
	public EmpAverSat(){
		
	}
	public String getMailname() {
		return mailname;
	}

	public void setMailname(String mailname) {
		this.mailname = mailname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSaturabilityAdd() {
		return saturabilityAdd;
	}

	public void setSaturabilityAdd(String saturabilityAdd) {
		this.saturabilityAdd = saturabilityAdd;
	}

	public String getSaturabilityDown() {
		return saturabilityDown;
	}

	public void setSaturabilityDown(String saturabilityDown) {
		this.saturabilityDown = saturabilityDown;
	}

	@Override
	public String toString() {
		return "EmpAverSat [mailname=" + mailname + ", date=" + date
				+ ", saturabilityAdd=" + saturabilityAdd
				+ ", saturabilityDown=" + saturabilityDown + "]";
	}
	
		
	
}
