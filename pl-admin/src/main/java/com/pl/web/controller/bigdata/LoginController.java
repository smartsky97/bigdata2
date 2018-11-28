package com.pl.web.controller.bigdata;

import com.pl.web.model.User;
import com.pl.web.service.impl.UserServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录Ctrl层
 * @author root
 *
 */
@Controller
public class LoginController  {
	
	//Service实现类注入.
	@Autowired
	private UserServiceIMP userServiceIMP;
	
	//前段用户登录与后台交互.
	@RequestMapping(value="login1") 
    public ModelAndView login(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {  
        // TODO Auto-generated method stub  
        String name=request.getParameter("username");  
        String password=request.getParameter("password");  
        User user=new User();
        user.setName(name);  
        user.setPwd(password); 
        Map<String, Object> model=new HashMap<String, Object>();  
        if( null == name || "".equals(name)){
//        	model.put("error", "用户名为空！");  
            return new ModelAndView("login",model);
        }
        if( null == password || "".equals(password)){
//        	model.put("error", "密码为空！");  
            return new ModelAndView("login",model);
        }
        if(userServiceIMP.login(user)!=null){  
            user=userServiceIMP.login(user);  
            model.put("user", user);  
            return new ModelAndView("index",model);  
        }else{  
            model.put("error", "用户名或密码错误！");  
            return new ModelAndView("login",model);
        }     
    }  
}
