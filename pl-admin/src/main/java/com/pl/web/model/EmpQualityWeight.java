package com.pl.web.model;


/**
 * 工作量权重类
 * 
 * @author songwb
 *
 */
public class EmpQualityWeight {
    
	public EmpQualityWeight() {
	}
	



	/**
	 * 部门id
	 */
	private Integer id;
	private Integer deptId;
	private String department;
	/**
	 * 关键字权重,(关键字:权重)
	 */
	private Double keyWordWeight;
	
	/**
	 * 任务时长权重
	 */
	private Double jobTimeWeight;

	/**
	 * 考核得分权重
	 */
	private Double examineScoreWeight;
	/**
	 * 月度文件增长量权重
	 */
	private Double monthFileGrowthWeight;
	
	/**
	 * 键盘敲击量权重
	 */
	private Double keyboardClickWeight;
	
	
	/**
	 * 鼠标敲击量权重
	 */
	private Double mouseClickWeight;
	
	/**
	 * 工作饱和度(加法权重)
	 */
	private Double workSaturationAddWeight;
	/**
	 * 工作饱和度(减法权重)
	 */
	private Double workSaturationSubWeight;
	/**
	 * 邮件发送次数权重
	 */
	private Double emailSendTimesWeight;
	/**
	 * lync通信次数权重
	 */
	private Double lyncComuTimesWeight;
	/**
	 * 会议时长权重
	 */
	private Double meetingDuraWeight;
	/**
	 * 打电话次数的权重
	 */
	private Double callPhoneTimesWeight;
	/**
	 * 权重开始时间
	 */
	private String startTime;
	/**
	 * 权重结束时间
	 */
	private String endTime;

	public EmpQualityWeight(Integer id, Integer deptId, Double keyWordWeight, Double jobTimeWeight,
			Double examineScoreWeight, Double monthFileGrowthWeight, Double keyboardClickWeight,
			Double mouseClickWeight, Double workSaturationAddWeight, Double workSaturationSubWeight,
			Double emailSendTimesWeight, Double lyncComuTimesWeight, Double meetingDuraWeight,
			Double callPhoneTimesWeight, String startTime, String endTime) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.keyWordWeight = keyWordWeight;
		this.jobTimeWeight = jobTimeWeight;
		this.examineScoreWeight = examineScoreWeight;
		this.monthFileGrowthWeight = monthFileGrowthWeight;
		this.keyboardClickWeight = keyboardClickWeight;
		this.mouseClickWeight = mouseClickWeight;
		this.workSaturationAddWeight = workSaturationAddWeight;
		this.workSaturationSubWeight = workSaturationSubWeight;
		this.emailSendTimesWeight = emailSendTimesWeight;
		this.lyncComuTimesWeight = lyncComuTimesWeight;
		this.meetingDuraWeight = meetingDuraWeight;
		this.callPhoneTimesWeight = callPhoneTimesWeight;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Double getJobTimeWeight() {
		return jobTimeWeight;
	}

	public void setJobTimeWeight(Double jobTimeWeight) {
		this.jobTimeWeight = jobTimeWeight;
	}

	@Override
	public String toString() {
		return "EmpQualityWeight [id=" + id + ", deptId=" + deptId + ", keyWordWeight=" + keyWordWeight
				+ ", jobTimeWeight=" + jobTimeWeight + ", examineScoreWeight=" + examineScoreWeight
				+ ", monthFileGrowthWeight=" + monthFileGrowthWeight + ", keyboardClickWeight=" + keyboardClickWeight
				+ ", mouseClickWeight=" + mouseClickWeight + ", workSaturationAddWeight=" + workSaturationAddWeight
				+ ", workSaturationSubWeight=" + workSaturationSubWeight + ", emailSendTimesWeight="
				+ emailSendTimesWeight + ", lyncComuTimesWeight=" + lyncComuTimesWeight + ", meetingDuraWeight="
				+ meetingDuraWeight + ", callPhoneTimesWeight=" + callPhoneTimesWeight + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Double getKeyWordWeight() {
		return keyWordWeight;
	}
	public void setKeyWordWeight(Double keyWordWeight) {
		this.keyWordWeight = keyWordWeight;
	}
	public Double getExamineScoreWeight() {
		return examineScoreWeight;
	}
	public void setExamineScoreWeight(Double examineScoreWeight) {
		this.examineScoreWeight = examineScoreWeight;
	}
	public Double getMonthFileGrowthWeight() {
		return monthFileGrowthWeight;
	}
	public void setMonthFileGrowthWeight(Double monthFileGrowthWeight) {
		this.monthFileGrowthWeight = monthFileGrowthWeight;
	}
	public Double getKeyboardClickWeight() {
		return keyboardClickWeight;
	}
	public void setKeyboardClickWeight(Double keyboardClickWeight) {
		this.keyboardClickWeight = keyboardClickWeight;
	}
	public Double getWorkSaturationAddWeight() {
		return workSaturationAddWeight;
	}
	public void setWorkSaturationAddWeight(Double workSaturationAddWeight) {
		this.workSaturationAddWeight = workSaturationAddWeight;
	}
	public Double getWorkSaturationSubWeight() {
		return workSaturationSubWeight;
	}
	public void setWorkSaturationSubWeight(Double workSaturationSubWeight) {
		this.workSaturationSubWeight = workSaturationSubWeight;
	}
	
	public Double getEmailSendTimesWeight() {
		return emailSendTimesWeight;
	}

	public void setEmailSendTimesWeight(Double emailSendTimesWeight) {
		this.emailSendTimesWeight = emailSendTimesWeight;
	}

	public Double getLyncComuTimesWeight() {
		return lyncComuTimesWeight;
	}
	public void setLyncComuTimesWeight(Double lyncComuTimesWeight) {
		this.lyncComuTimesWeight = lyncComuTimesWeight;
	}
	public Double getMeetingDuraWeight() {
		return meetingDuraWeight;
	}
	public void setMeetingDuraWeight(Double meetingDuraWeight) {
		this.meetingDuraWeight = meetingDuraWeight;
	}
	public Double getCallPhoneTimesWeight() {
		return callPhoneTimesWeight;
	}
	public void setCallPhoneTimesWeight(Double callPhoneTimesWeight) {
		this.callPhoneTimesWeight = callPhoneTimesWeight;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
	public Double getMouseClickWeight() {
		return mouseClickWeight;
	}

	public void setMouseClickWeight(Double mouseClickWeight) {
		this.mouseClickWeight = mouseClickWeight;
	}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
