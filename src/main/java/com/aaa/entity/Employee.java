package com.aaa.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Employee {
    private Integer empId;         // 主键 emp_id
    private String empName;         // emp_name 姓名
    private String gender;          // gender 性别
    private Integer age;            // age 年龄
    private String dept;            // dept 部门
    private String job;             // job 岗位
    private BigDecimal salary;      // salary 薪资（小数用BigDecimal，不要double）
    private Date hiredate;          // hire_date 入职日期（属性名与 resultMap 的 property="hiredate" 一致）
    private String phone;           // phone 手机号
    private String email;           // email 邮箱


    public Employee(String empName, String dept, String gender, Integer age) {
        this.empName = empName;
        this.dept = dept;
        this.gender = gender;
        this.age = age;

}

    //无参构造必须保留！MyBatis默认需要无参构造
    public Employee(){}

    //getter setter
}