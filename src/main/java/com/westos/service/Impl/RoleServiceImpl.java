package com.westos.service.Impl;

import com.westos.dao.RoleDao;
import com.westos.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements com.westos.service.RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        List<Role> roles = roleDao.findAll();
        return roles;
    }

    @Override
    public List<Role> findByUserId(int userId) {
        List<Role> roleList = roleDao.findByUserId(userId);
        return roleList;
    }

    @Override
    public void deleteRoleModule(int roleId) {
        roleDao.deleteRoleModule(roleId);
    }

    @Override
    public void modifyRoleModule(int roleId, int[] moduleId) {
        roleDao.deleteRoleModule(roleId);
        for (int i : moduleId) {
            roleDao.insertRoleModule(roleId,i);
        }
    }
}
