package com.pl.web.model;

public class EmpLabel {
	private int id;
	private String userId;
	private int labelId;
	private String coputeDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getCoputeDate() {
		return coputeDate;
	}
	public void setCoputeDate(String coputeDate) {
		this.coputeDate = coputeDate;
	}
	@Override
	public String toString() {
		return "EmpLabel [id=" + id + ", userId=" + userId + ", labelId=" + labelId + ", coputeDate=" + coputeDate
				+ "]";
	}

	
}
