package com.pl.web.controller.bigdata;

import com.pl.web.model.User;
import com.pl.web.service.impl.UserServiceIMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户列表Ctrl类.
 * @author root
 *
 */
@Controller
public class UserListCtrl {
	private static Logger logger= LoggerFactory.getLogger(UserListCtrl.class);
	//Service实现类注入.
	@Autowired
	private UserServiceIMP userServiceIMP;
	
	/*
	 * 前段用户列表与后台交互.
	 */
	@RequestMapping("listCtrl")
	public String list(ModelMap mm){
		mm.put("list", userServiceIMP.list());
		return "user/list";
	}
	/*
	 * 删除用户
	 */
	@RequestMapping("del")
	public String delete(User user,ModelMap mm,HttpServletRequest request){
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		boolean result=this.userServiceIMP.del(id1);
		 if(result){
	        	System.out.println("删除成功");
	        }
		return list(mm);
	}
	/*
	 * 添加用户
	 */
	@RequestMapping("add")
	public String add(User user,ModelMap mm){
		boolean result=this.userServiceIMP.adduser(user);
		if(result){
			System.out.println("添加成功");
		}
		return list(mm);
	}
	/*
	 * 更新
	 */
	@RequestMapping("update")
	public String update(User user,ModelMap mm){
		boolean result=this.userServiceIMP.update(user);
		if(result){
			System.out.println("更新成功");
		}
		return list(mm);
	}
	
	@RequestMapping("updateuserUI") 
    public String updateuserUI(ModelMap mm,HttpServletRequest request) throws Exception {  
        // TODO Auto-generated method stub 
		String id=request.getParameter("id");
        	User us=this.userServiceIMP.getUserById(id);
        	mm.put("user", us);
    		return "user/listinfo";
    }
	
	@RequestMapping("updatePermission")
	public String updatePermission(ModelMap mm,HttpServletRequest request){
		String id1 =request.getParameter("id");
		System.out.println("id1="+id1);
		int id =Integer.parseInt(id1);
		String level1 =request.getParameter("levelid");
		System.out.println("level1="+level1);
		int level =Integer.parseInt(level1);
		int result =this.userServiceIMP.updatePermission(id, level);
		if(result!=0){
			System.out.println("权限分配成功!");
		}
		return list(mm);
	}
}
