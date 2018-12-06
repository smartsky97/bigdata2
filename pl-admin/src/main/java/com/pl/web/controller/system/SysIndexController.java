package com.pl.web.controller.system;

import com.pl.common.config.Global;
import com.pl.framework.web.base.BaseController;
import com.pl.system.domain.SysMenu;
import com.pl.system.domain.SysUser;
import com.pl.system.service.ISysMenuService;
import com.pl.web.service.impl.DepartmentServiceIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private DepartmentServiceIMP departmentServiceIMP;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        mmap.put("depts",departmentServiceIMP.getDepartments(getUserId()));
        return "main";
    }
}
