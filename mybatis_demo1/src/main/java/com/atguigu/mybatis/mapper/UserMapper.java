package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-20 12:49
 */
public interface UserMapper {
    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 删除用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据用户id查询用户信息
     * @return
     */
    User getUserById();

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();
}
