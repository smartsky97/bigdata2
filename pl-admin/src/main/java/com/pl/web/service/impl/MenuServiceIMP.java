package com.pl.web.service.impl;

import com.pl.web.dao.IMenuDao;
import com.pl.web.model.Menu;
import com.pl.web.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceIMP implements IMenuService {

	@Autowired
	private IMenuDao iMenuDao;

	@Override
	public List<Menu> mainMenufindByUser(String username) {
		
		return this.iMenuDao.mainMenufindByUser(username);
	}

	@Override
	public List<Menu> menuSourceFindById(Integer id) {
		// TODO Auto-generated method stub
		return this.iMenuDao.menuSourceFindById(id);
	}
	
	

}
