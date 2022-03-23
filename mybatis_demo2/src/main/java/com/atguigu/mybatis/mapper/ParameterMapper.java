package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhanghu
 * @create 2022-03-20 15:45
 */
public interface ParameterMapper {

    /**
     * 验证登录（使用@param）
     * @param username
     * @param password
     * @return
     */
    User CheckLoginByParam(@Param("username") String username,@Param("password") String password);
    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);
    /**
     * 验证登录（以map形式）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);
    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByIdUsername(String username);

}
