package com.pl.web.service;

import com.pl.web.model.Menu;

import java.util.List;


public interface IMenuService {

	public List<Menu> mainMenufindByUser(String username);
	
	public List<Menu> menuSourceFindById(Integer id);
}
