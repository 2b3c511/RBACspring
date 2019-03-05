package com.westos.controller;

import com.westos.dao.UserDao;
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

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.westos.util.Md5Util.md5;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    public String loginin(HttpSession session,String username , String password, Model model){
        User user = userService.findByUsername(username);
        String s = user.getPassword();
        session.setAttribute("user",user);
        List<Module> allModules = moduleService.findAll();
        session.setAttribute("allModules",allModules);
        if(s.equals(md5(password))&&user!=null){
            return "redirect:/system/user/page";
        }
        return "/login";
    }


    @RequestMapping("/logout")
    public String logoutout(HttpSession session,Model model){
        session.invalidate();
        return "/login";
    }

    @RequestMapping("/index")
    public String index(HttpSession session,Model model){
        return "/index";
    }
}
