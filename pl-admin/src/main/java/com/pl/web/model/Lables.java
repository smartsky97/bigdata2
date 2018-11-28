package com.pl.web.model;
/*
 * 员工画像指标Bean类
 */
public class Lables {
    
	/*
	 * 指标Id
	 */
	private Integer id;
	/*
	 * 指标名称
	 */
    private String labelName;
    /*
     * 指标状态
     */
    private Integer status;
    
    public Lables (){
    	
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}