package com.westos.service.Impl;

import com.westos.dao.UserDao;
import com.westos.domain.Module;
import com.westos.domain.Role;
import com.westos.domain.User;
import com.westos.service.ModuleService;
import com.westos.service.RoleService;
import com.westos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements com.westos.service.UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ModuleService moduleService;
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if(user!=null){
            List<Role> roleList = roleService.findByUserId(user.getId());
            user.setRoles(roleList);
            for (Role role : roleList) {
                List<Module> moduleList = moduleService.findByRoleId(role.getId());
                role.setModules(moduleList);
            }
        }
        return user;
    }

    @Override
    public User findById(int userId) {
        User user = userDao.findById(userId);
        user.setRoles(roleService.findByUserId(userId));
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public List<User> findByPage(int page, int rows ) {
        int i = (page-1)*rows;
        List<User> byPage = userDao.findByPage(i, rows);
        return byPage;
    }

    @Override
    public int findCount() {
        int count = userDao.findCount();
        return count;
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Override
    public void modifyRoles(int userId, Integer[] roleIds) {
        userDao.deleteUserRole(userId);
        for (int roleId : roleIds) {
            userDao.insertUserRole(userId,roleId);
        }

    }
}
