package com.pl.web.service;


import com.pl.web.model.Lables;

import java.util.List;
/**
 * 指标管理Service接口层
 * @author lihao
 *
 */
public interface ILablesService {
	/*
	 * 查询指标
	 */
	public Lables selectLable(Lables lable);
	/*
	 * 插入指标
	 */
    public int insertLable(Lables lable);
    /*
     * 更新指标
     */
    public int updateLable(Lables lable);
    /*
     * 通过Id删除
     */
    public int deleteLableById(int lable_id);
    /*
     * 查询指标列表
     */
    List<Lables> list(int fromIndex, int pageSize);
    public int getLabelSize();
}
