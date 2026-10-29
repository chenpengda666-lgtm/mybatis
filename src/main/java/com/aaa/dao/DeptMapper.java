package com.aaa.dao;
import com.aaa.entity.Dept;
public interface DeptMapper {
    Dept queryById(Integer id);
    int update(Dept dept);
}
