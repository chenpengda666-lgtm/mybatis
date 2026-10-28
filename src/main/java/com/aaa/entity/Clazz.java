package com.aaa.entity;

import lombok.Data;

import java.util.List;

@Data
public class Clazz {
    private Integer cid;
    private String cname;
    private Integer teacherId;

    private Teacher teacher;//该班级对应的老师信息。

    //一对多：一个班级下有多个学生
    private List<Student> students;
}
