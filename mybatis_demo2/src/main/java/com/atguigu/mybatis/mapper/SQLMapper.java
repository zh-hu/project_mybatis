package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-20 19:48
 */
public interface SQLMapper {
    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);
    /**
     * 查询指定表中的数据
     * @param tableName
     * @return
     */
    List<User> getUserByTable(@Param("tableName") String tableName);
    /**
     *  根据id批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);
    /**
     *  根据用户名进行模糊查询
     * @param username
     * @return
     */
    List<User> getUserByLike(@Param("username") String username);
}

