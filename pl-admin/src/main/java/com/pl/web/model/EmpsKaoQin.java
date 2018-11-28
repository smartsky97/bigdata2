package com.pl.web.model;
/**
 * 员工考勤率Bean类
 * @author root
 *
 */
public class EmpsKaoQin {
    
	private String mailnickname;

    private String cnName;

    private String department;
	
	private Double perAttendance;

    private Integer attendanceDays;

    private String date;

    public Double getPerAttendance() {
        return perAttendance;
    }

    public void setPerAttendance(Double perAttendance) {
        this.perAttendance = perAttendance;
    }

    public Integer getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(Integer attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
    
    public String getMailnickname() {
        return mailnickname;
    }

    public void setMailnickname(String mailnickname) {
        this.mailnickname = mailnickname == null ? null : mailnickname.trim();
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}