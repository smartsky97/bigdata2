package com.pl.web.dao;

import java.util.List;

import com.pl.web.model.Menu;
import org.apache.ibatis.annotations.Param;


/**
 * 菜单管理
 * @author Administrator
 *
 */
public interface IMenuDao {

	public List<Menu> mainMenufindByUser(@Param("username") String username);
	
	public List<Menu> menuSourceFindById(@Param("id") Integer id);
	
}
