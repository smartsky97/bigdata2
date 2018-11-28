package com.pl.web.model;

/*
 * 
   月度关键字总数，月度目标使用时间
 * @author huangjz
 */
public class JobTime {
    private String account;
    private String name;
    private String jobTime;
    private String sum;
    private String content;
    private String depart;
    private String depId;
    
	public JobTime() {
		super();
	}

	@Override
	public String toString() {
		return "JobTime [account=" + account + ", name=" + name + ", jobTime=" + jobTime + ", sum=" + sum + ", content="
				+ content + ", depart=" + depart + ", depId=" + depId + "]";
	}

	public JobTime(String account, String name, String jobTime, String sum, String content, String depart,
			String depId) {
		super();
		this.account = account;
		this.name = name;
		this.jobTime = jobTime;
		this.sum = sum;
		this.content = content;
		this.depart = depart;
		this.depId = depId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

}
