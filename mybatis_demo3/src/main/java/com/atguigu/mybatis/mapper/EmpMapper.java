package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhanghu
 * @create 2022-03-21 10:05
 */
public interface EmpMapper {

    /**
     * 查询所有员工的信息
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应部门信息
     * @return
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第一步：查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第二步：根据部门id查询部门中的所有员工
     * @param did
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

}
