package com.westos.controller;

import com.westos.domain.Role;
import com.westos.domain.User;
import com.westos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.westos.util.Md5Util.md5;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/system/user/page")
    public String findByPage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "5") Integer rows,
                             Model model){
        List<User> list = userService.findByPage(page, rows);
        //总记录数
        int count = userService.findCount();
        //总页数
        int total = (count - 1)/rows +1;
        //将数据放入模型
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute("total",total);
        return "/system/user/page";
    }


    @RequestMapping("/system/user/toadd")
    public String insert(String username,String password,String orgId){
        User user = new User();
        user.setUsername(username);
        String passwordnew = md5(password);
        user.setPassword(passwordnew);
        userService.insert(user);
        return "redirect:/system/user/page";
    }

    @RequestMapping("/system/user/toupdate")
    public String update(Integer userId,Model model){
        model.addAttribute("userId",userId);
        return "/system/user/toupdate";
    }

    @RequestMapping("/system/user/toupdate2")
    public String update(String username,String password,String orgId,Model model){
        User user = new User();
        user.setUsername(username);
        user.setPassword(md5(password));
        userService.update(user);
        return "redirect:/system/user/page";
    }

    @RequestMapping("/system/user/delete")
    public String delete(Integer userId){
        userService.delete(userId);
        return "redirect:/system/user/page";
    }

    @RequestMapping("/system/email")
    public String email(){
        return "/system/email/email";
    }

    @RequestMapping("/system/sms")
    public String sms(){
        return "/system/sms/sms";
    }

    @RequestMapping("/system/user")
    public String user(){
        return "redirect:/system/user/page";
    }

    @RequestMapping("/system/role")
    public String role(Model model,Integer userId){
        User user = userService.findById(userId);
        List<Role> roleList = user.getRoles();
        System.out.println(userId);
        for (Role role : roleList) {
            System.out.println(role.getName());
        }
        model.addAttribute("roles",roleList);
        return "/system/role/all";
    }

}
