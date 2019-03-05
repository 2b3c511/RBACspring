package com.westos.controller;

import com.westos.domain.Module;
import com.westos.domain.Role;
import com.westos.domain.User;
import com.westos.service.ModuleService;
import com.westos.service.RoleService;
import com.westos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModuleService moduleService;


    @RequestMapping("/system/user/tomodifyrole")
    public String toModifyRole(Integer userId,
                               Model model){
        //用户id
        User user = userService.findById(userId);
        //所有角色
        List<Role> allroleslist = roleService.findAll();
        //用户角色
        List<Role> roleList = roleService.findByUserId(userId);
        model.addAttribute("roles",allroleslist);
        model.addAttribute("userRoles",roleList);
        model.addAttribute("userId",userId);
        return "/system/user/tomodifyrole";
    }


    @RequestMapping("/system/user/tomodifyrole2")
    public String toModifyRole2(Integer userId, Integer[] roles) {
        userService.modifyRoles(userId,roles);
        return "redirect:/system/user/page";
    }
    @RequestMapping("/system/role/tomodifymodule")
    public String toModifymodule(Integer userId, Model model) {
        List<Role> roles = roleService.findByUserId(userId);
        List<Module> list = new ArrayList<>();
//        System.out.println("用户的module");
        for (Role role : roles) {
            List<Module> modulelist = moduleService.findByRoleId(role.getId());
            list.addAll(modulelist);
//            for (Module module : modulelist) {
//                System.out.print(module.getName()+" ");
//            }
        }
//        System.out.println();
        List<Module> all = moduleService.findAll();
//        for (Module module : all) {
//            System.out.print(module.getName()+"  ");
//        }
        model.addAttribute("userId",userId);
        model.addAttribute("allModules",all);
        model.addAttribute("roleModules",list);
        return "system/role/tomodifymodule";
    }

    @RequestMapping("/system/role/modifymodule")
    public String Modifymodule(Integer roleId,int[]  moduleId) {
//        List<Module> listmodule = moduleService.findByRoleId(roleId);
//        for (Module module : listmodule) {
//            System.out.println(module.getName());
//        }
        //roleService.deleteRoleModule(roleId);
        //for (Module module : listmodule) {
            roleService.modifyRoleModule(roleId,moduleId);
        //}
        return "redirect:/system/user/page";
    }
}
