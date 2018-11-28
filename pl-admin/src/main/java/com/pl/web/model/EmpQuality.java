package com.pl.web.model;


/**
 * 工作量类
 * 
 * @author huangjz
 *
 */
public class EmpQuality {
    
	/**
	 * 部门id
	 */
	private String id;
	private String deptId;
	private String department;
	private String mailName;
	private String chinaName;
	
	/**
	 * 关键字,(关键字:)
	 */
	private String keyWord;
	
	/**
	 * 任务时长
	 */
	private String jobTime;

	/**
	 * 考核得分
	 */
	private String examineScore;
	/**
	 * 月度文件增长量
	 */
	private String monthFileGrowth;
	
	/**
	 * 键盘敲击量
	 */
	private String keyboardClick;
	
	
	/**
	 * 鼠标敲击量
	 */
	private String mouseClick;
	
	/**
	 * 工作饱和度(加法)
	 */
	private String workSaturationAdd;
	/**
	 * 工作饱和度(减法)
	 */
	private String workSaturationSub;
	/**
	 * 邮件发送次数
	 */
	private String emailSendTimes;
	/**
	 * lync通信次数
	 */
	private String lyncComuTimes;
	/**
	 * 会议时长
	 */
	private String meetingDura;
	/**
	 * 打电话次数的
	 */
	private String callPhoneTimes;
	/**
	 *审批次数
	 */
	private String approveTimes;
	/**
	 * 平均审批效率
	 */
	private String approveAvailTime;
	/**
	 * 统计时间
	 */
	private String computeDate;
	
	
	
	
	@Override
	public String toString() {
		return "EmpQuality [id=" + id + ", deptId=" + deptId + ", department=" + department + ", mailName=" + mailName
				+ ", chinaName=" + chinaName + ", keyWord=" + keyWord + ", jobTime=" + jobTime + ", examineScore="
				+ examineScore + ", monthFileGrowth=" + monthFileGrowth + ", keyboardClick=" + keyboardClick
				+ ", mouseClick=" + mouseClick + ", workSaturationAdd=" + workSaturationAdd + ", workSaturationSub="
				+ workSaturationSub + ", emailSendTimes=" + emailSendTimes + ", lyncComuTimes=" + lyncComuTimes
				+ ", meetingDura=" + meetingDura + ", callPhoneTimes=" + callPhoneTimes + ", approveTimes="
				+ approveTimes + ", approveAvailTime=" + approveAvailTime + ", computeDate=" + computeDate + "]";
	}



	public EmpQuality() {
		super();
	}
	
	
	
	public EmpQuality(String id, String deptId, String department, String mailName, String chinaName, String keyWord,
			String jobTime, String examineScore, String monthFileGrowth, String keyboardClick, String mouseClick,
			String workSaturationAdd, String workSaturationSub, String emailSendTimes, String lyncComuTimes,
			String meetingDura, String callPhoneTimes, String approveTimes, String approveAvailTime,
			String computeDate) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.department = department;
		this.mailName = mailName;
		this.chinaName = chinaName;
		this.keyWord = keyWord;
		this.jobTime = jobTime;
		this.examineScore = examineScore;
		this.monthFileGrowth = monthFileGrowth;
		this.keyboardClick = keyboardClick;
		this.mouseClick = mouseClick;
		this.workSaturationAdd = workSaturationAdd;
		this.workSaturationSub = workSaturationSub;
		this.emailSendTimes = emailSendTimes;
		this.lyncComuTimes = lyncComuTimes;
		this.meetingDura = meetingDura;
		this.callPhoneTimes = callPhoneTimes;
		this.approveTimes = approveTimes;
		this.approveAvailTime = approveAvailTime;
		this.computeDate = computeDate;
	}



	public String getApproveTimes() {
		return approveTimes;
	}



	public void setApproveTimes(String approveTimes) {
		this.approveTimes = approveTimes;
	}



	public String getApproveAvailTime() {
		return approveAvailTime;
	}



	public void setApproveAvailTime(String approveAvailTime) {
		this.approveAvailTime = approveAvailTime;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMailName() {
		return mailName;
	}
	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	public String getChinaName() {
		return chinaName;
	}
	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getJobTime() {
		return jobTime;
	}
	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}
	public String getExamineScore() {
		return examineScore;
	}
	public void setExamineScore(String examineScore) {
		this.examineScore = examineScore;
	}
	public String getMonthFileGrowth() {
		return monthFileGrowth;
	}
	public void setMonthFileGrowth(String monthFileGrowth) {
		this.monthFileGrowth = monthFileGrowth;
	}
	public String getKeyboardClick() {
		return keyboardClick;
	}
	public void setKeyboardClick(String keyboardClick) {
		this.keyboardClick = keyboardClick;
	}
	public String getMouseClick() {
		return mouseClick;
	}
	public void setMouseClick(String mouseClick) {
		this.mouseClick = mouseClick;
	}
	public String getWorkSaturationAdd() {
		return workSaturationAdd;
	}
	public void setWorkSaturationAdd(String workSaturationAdd) {
		this.workSaturationAdd = workSaturationAdd;
	}
	public String getWorkSaturationSub() {
		return workSaturationSub;
	}
	public void setWorkSaturationSub(String workSaturationSub) {
		this.workSaturationSub = workSaturationSub;
	}
	public String getEmailSendTimes() {
		return emailSendTimes;
	}
	public void setEmailSendTimes(String emailSendTimes) {
		this.emailSendTimes = emailSendTimes;
	}
	public String getLyncComuTimes() {
		return lyncComuTimes;
	}
	public void setLyncComuTimes(String lyncComuTimes) {
		this.lyncComuTimes = lyncComuTimes;
	}
	public String getMeetingDura() {
		return meetingDura;
	}
	public void setMeetingDura(String meetingDura) {
		this.meetingDura = meetingDura;
	}
	public String getCallPhoneTimes() {
		return callPhoneTimes;
	}
	public void setCallPhoneTimes(String callPhoneTimes) {
		this.callPhoneTimes = callPhoneTimes;
	}
	public String getComputeDate() {
		return computeDate;
	}
	public void setComputeDate(String computeDate) {
		this.computeDate = computeDate;
	}
	
}
