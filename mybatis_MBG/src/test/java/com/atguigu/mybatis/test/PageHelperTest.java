package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-21 18:47
 */
public class PageHelperTest {

    /**
     * limit index pageSize
     * index：当前页的起始索引
     * pageNum：当前页的页码
     * pageSize：每页显示的条数
     * size：当前页显示的真实条数
     * total：总记录数
     * pages：总页数
     * prePage：上一页的页码
     * nextPage：下一页的页码
     * isFirstPage/isLastPage：是否为第一页/最后一页
     * hasPreviousPage/hasNextPage：是否存在上一页/下一页
     * navigatePages：导航分页的页码数
     * navigatePageNums：导航分页的页码，\[1,2,3,4,5]
     * index = （pageNum - 1）*pageSize
     *
     *
     * @throws IOException
     */

    @Test
    public void testPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //访问第一页，每页四条数据
        PageHelper.startPage(1,4);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);
    }


    @Test
    public void testPageHelperOne() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //访问第一页，每页四条数据
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        //在查询到List集合后，打印分页数据
        System.out.println(page);
    }


    /**
     * 在查询获取list集合之后，使用`PageInfo<T> pageInfo = new PageInfo<>(List<T> list, intnavigatePages)`获取分页相关数据
     * list：分页之后的数据
     *   - navigatePages：导航分页的页码数
     * @throws IOException
     */
    @Test
    public void testPageHelperTwo() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<>(emps,5);
        System.out.println(page);
    }
}
