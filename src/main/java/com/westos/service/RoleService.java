package com.westos.service;

import com.westos.domain.Role;

import java.util.List;

/**
 * @author yihang
 */
public interface RoleService {
    /**
     * 查询所有角色
     *
     * @return 角色集合
     */
    List<Role> findAll();

    /**
     * 查询某一用户的角色
     * @param userId 用户编号
     * @return 角色集合
     */
    List<Role> findByUserId(int userId);
    /**
     * 删除某角色的所有模块
     * @param roleId 角色编号
     */
    void deleteRoleModule(int roleId);
    /**
     * 为某一角色添加模块
     * @param roleId 角色编号
     * @param moduleIds 要添加的模块编号
     */
    void modifyRoleModule(int roleId, int[] moduleIds);
}
