package com.pl.web.controller.bigdata;

import com.pl.web.model.Menu;
import com.pl.web.model.User;
import com.pl.web.service.impl.MenuServiceIMP;
import com.pl.web.service.impl.UserServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginCtrl {
	
	@Autowired
	private UserServiceIMP userServiceIMP;
	
	@Autowired
	private MenuServiceIMP menuServiceIMP;
	
	@RequestMapping("login")
	public String login(ModelMap mm,HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("username");  
        String password=request.getParameter("password");  
        User user=new User();
        user.setName(name);  
        user.setPwd(password);
		boolean flag =this.userServiceIMP.Login(user);
		if (flag){
			List<Menu> list =this.menuServiceIMP.mainMenufindByUser(user.getName());
			String menuString="";
			for (Menu menu : list){
				String menuStr ="<li class=\"treeview\"><a href=\"#\" target=\"menuFrame\"><i class=\"%s\"></i> <span> %s</span> <i class=\"fa fa-angle-left pull-right\"></i> </a>%s</li>";
				List<Menu> childs =this.menuServiceIMP.menuSourceFindById(menu.getCode());
				String ChildMenu="<ul class=\"treeview-menu\">%s</ul>";
				String cmenu ="<li><a href=\"%s\" target=\"menuFrame\"><i class=\"fa fa-circle-o\"></i> %s</a></li>";
				String m ="";
				//String str =String.format(menuStr,menu.getShap(),menu.getName());
				for(Menu  child:childs){
					m =m+String.format(cmenu,child.getUrl(),child.getAttr());
				}
				ChildMenu =String.format(ChildMenu, m);
				if(childs ==null || childs.size()==0){
					menuStr =String.format(menuStr,menu.getShap(),"");
				}else{
					menuStr =String.format(menuStr,menu.getShap(),menu.getName(),ChildMenu);
				}
				menuString =menuString+menuStr;
			}
			//System.out.println(menuString);
				mm.put("menu", menuString);
				request.setAttribute("user", user);
				return "WEB-INF/index";
		} else{
			mm.put("error", "用户名或密码错误！");
			return "login";
		}
	}
	
}
