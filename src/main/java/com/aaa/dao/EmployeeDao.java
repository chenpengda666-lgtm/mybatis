package com.aaa.dao;

import com.aaa.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

    // 多条件模糊查询
    public List<Employee> selectByCondition(Employee employee);


    // ========== 这里新增三个方法 ==========
    //删除
    int batchDelete(List<Integer> ids);

    //添加
    int batchAdd(List<Employee> emps);

    //修改
    int updateByCondition(Employee emp);


    // 第一个方法
    List<Employee> selectByName(String name);

    //分页查询方法
    List<Employee> selectPage();

    //一级缓存
    public List<Employee> selectById(int id);

}
