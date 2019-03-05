package com.westos.domain;

import com.westos.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.*;

/**
 * 用户类
 *
 * @author yihang
 */
@SuppressWarnings("serial")
public class User implements Serializable {
    /**
     * 用户编号
     */
    private int id;

    /**
     * 用户登录名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 角色集合
     */
    private List<Role> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Integer> getModules() {
        List<Integer> all = new ArrayList<>();
        for (Role role : roles) {
            List<Module> moduleList = role.getModules();
            for (Module module : moduleList) {
                all.add(module.getId());
            }
        }
        return all;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public Set<Integer> getParModules(){
            Set<Integer> all = new HashSet<>();
            for (Role role : roles) {
                List<Module> moduleList = role.getModules();
                for (Module module : moduleList) {
                    all.add(module.getPid());
                }
            }
            return  all;

    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
