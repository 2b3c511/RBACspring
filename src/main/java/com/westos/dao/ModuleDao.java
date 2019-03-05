package com.westos.dao;

import com.westos.domain.Module;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yihang
 */
public interface ModuleDao {

    /**
     * 查询所有模块
     * @return 模块集合
     */
    @Select("select * from rbac_module")
    List<Module> findAll();

    /**
     * 查询某一角色的模块
     * @param roleId 角色编号
     * @return 模块集合
     */
    @Select("select * from rbac_role_module a inner join rbac_module b on a.module_id = b.id where a.role_id=#{roleId}" )
    List<Module> findByRoleId(int roleId);


}
