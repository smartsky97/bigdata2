package com.pl.web.model;
/*
 * wifi定位数据Bean类
 */
public class WifiData {
	/*
	 * 探针编号
	 */
	private String macCode;
	/*
	 * 位置坐标x
	 */
	private Integer x;
	/*
	 * 位置表y
	 */
	private Integer y;
	/*
	 * wifi探针位置
	 */
    private String positionName;
    /*
     * 手机使用Mac
     */
    private String userName;
    /*
     * 平均信号强度
     */
    private Integer avgSig;
    /*
     * 开始时间
     */
    private String startTime;
    /*
     * 结束时间
     */
    private String endTime;
    /*
     * 默认构造方法
     */
    public WifiData(){
    	
    }
	public String getMacCode() {
		return macCode;
	}
	public void setMacCode(String macCode) {
		this.macCode = macCode;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAvgSig() {
		return avgSig;
	}
	public void setAvgSig(Integer avgSig) {
		this.avgSig = avgSig;
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
	
	@Override
	public String toString() {
		return "WifiData [macCode=" + macCode + ", x=" + x + ", y=" + y
				+ ", positionName=" + positionName + ", userName=" + userName
				+ ", avgSig=" + avgSig + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
 
}