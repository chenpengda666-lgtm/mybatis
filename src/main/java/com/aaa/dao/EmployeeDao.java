package com.aaa.dao;

import com.aaa.entity.Employee;

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
}