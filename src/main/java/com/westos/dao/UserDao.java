package com.westos.dao;


import com.westos.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yihang
 */
public interface UserDao {

    /**
     * 根据用户名查询用户对象
     *
     * @param username 用户名
     * @return 返回用户对象，如果查询不到返回null
     */
   @Select("select * from rbac_user where username=#{username}")
    User findByUsername(String username);

    /**
     * 根据用户id查询
     *
     * @param userId 用户编号
     * @return 返回用户对象
     */
    @Select("select * from rbac_user where id=#{userId}")
    User findById(int userId);

    /**
     * 查询所有用户
     * @return 返回用户集合
     */
    @Select("select * from rbac_user")
    List<User> findAll();

    /**
     * 分页查询用户
     * @param m 下标
     * @param n 每页记录数

     * @return 返回用户集合
     */
    @Select("select * from rbac_user limit #{m},#{n}")
    List<User> findByPage(@Param("m") int m, @Param("n") int n);

    /**
     * 查询用户总数
     * @return 用户总数

     */
    @Select("select count(*) from rbac_user")
    int findCount();

    /**
     * 新增用户
     * @param user 用户对象
     */
   @Insert("insert into rbac_user(id,username,password,org_id,org_ids) values (#{id},#{username},#{password},123,null)")
    void insert(User user);

    /**
     * 修改用户
     * @param user 用户对象
     */
    @Update("update rbac_user set username=#{username} , password=#{password} where id=#{id}")
    void update(User user);

    /**
     * 删除用户
     * @param userId 用户编号
     */
    @Delete("delete from rbac_user where id=#{userId}")
    void delete(int userId);

    /**
     * 删除该用户所有角色
     * @param userId 用户编号
     */
   @Delete("delete from rbac_user_role where user_id=#{userId}")
    void deleteUserRole(int userId);

    /**
     * 为该用户添加角色
     * @param userId 用户编号
     * @param roleId 角色编号
     */
    @Insert("insert into rbac_user_role(user_id,role_id) values(#{userId},#{roleId})")
    void insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);
}
