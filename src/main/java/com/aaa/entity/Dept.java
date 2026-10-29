package com.aaa.entity;

/**
 * 表示部门的实体类（对应 day02.dept 表）
 */
public class Dept  {
    private Integer id;
    private String name;

    public Dept(int i, String 开发部, String 上海) {
    }

    public Dept(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
