package com.pl.web.dao;

import com.pl.web.model.ActionDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工详细信息Dao层接口类.
 * @author root
 *
 */
public interface IActionDetailsDao {
   /*
    * 名字和时间作为条件查询详细信息.
    */
	 public List<ActionDetails> geDetails(@Param("mailname") String mailname, @Param("date") String date);
}