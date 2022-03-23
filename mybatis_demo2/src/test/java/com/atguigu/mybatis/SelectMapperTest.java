package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author zhanghu
 * @create 2022-03-20 18:52
 */
public class SelectMapperTest {
    /**
     * 1. 如果查询出的数据只有一条，可以通过
     *    1. 实体类对象接收
     *    2. List集合接收
     *    3. Map集合接收，结果`{password=123456, sex=男, id=1, age=23, username=admin}`
     * 2. 如果查询出的数据有多条，一定不能用实体类对象接收，会抛异常TooManyResultsException，可以通过
     *    1. 实体类类型的LIst集合接收
     *    2. Map类型的LIst集合接收
     *    3. 在mapper接口的方法上添加@MapKey注解
     * 3.将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，
     *   并且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，
     *   值是每条数据所对应的map集合
     */
    @Test
    public void testAllUserByIdMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
    @Test
    public void testUserByIdMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserToMap(3));
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserList());
    }

    @Test
    public void testUserById(){
            SqlSession sqlSession = SqlSessionUtils.getSqlSession();
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));
    }


}
