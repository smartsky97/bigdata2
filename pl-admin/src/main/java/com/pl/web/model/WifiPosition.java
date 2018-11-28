package com.pl.web.model;
/*
 * 地理位置和采集设备mac地址
 */
public class WifiPosition {
	/*
     * id
     */
	private Integer id;
	/*
	 * 坐标
	 */
    private String number;
    /*
     * 位置坐标x
     */
    private Integer x;
    /*
     * 位置坐标y
     */
    private Integer y;
    /*
     * 位置
     */
    private String place;
    /*
     * mac地址
     */
    private String mac;
    /*
     * 默认构造方法
     */
    public WifiPosition (){
    	
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	@Override
	public String toString() {
		return "WifiPosition [id=" + id + ", number=" + number + ", x=" + x
				+ ", y=" + y + ", place=" + place + ", mac=" + mac + "]";
	}
  
   
}