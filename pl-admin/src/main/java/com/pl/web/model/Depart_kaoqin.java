package com.pl.web.model;
/**
 * 部门流程数据
 * @author root
 *
 */
public class Depart_kaoqin {
    /*
     * 流程效率
     */
	private Double departAttendance;
	/*
	 * 考勤天数
	 */
    private Long attendanceDays;
    /*
     * 月份
     */
    private String date;
    /*
     * 部门
     */
    private String department;

    public Depart_kaoqin(){
    	
    }

	public Double getDepartAttendance() {
		return departAttendance;
	}

	public void setDepartAttendance(Double departAttendance) {
		this.departAttendance = departAttendance;
	}

	public Long getAttendanceDays() {
		return attendanceDays;
	}

	public void setAttendanceDays(Long attendanceDays) {
		this.attendanceDays = attendanceDays;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Depart_kaoqin [departAttendance=" + departAttendance
				+ ", attendanceDays=" + attendanceDays + ", date=" + date
				+ ", department=" + department + "]";
	}
    
}