package com.aaa.dao;

import com.aaa.entity.Dept;
import com.aaa.util.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对部门表操作的类（DAO：Data Access Object）。
 * <p>
 * 改造点：用 try-with-resources 代替教程里的「三段嵌套 try/finally」。
 * 它的好处：
 * 1. 连接、语句、结果集都会自动关闭，关闭顺序是反的（rs -> ps -> con）；
 * 2. 关闭时如果真的抛异常，也会被加到主异常的 suppressed 列表里，不会吞掉原始错误；
 * 3. 代码量从 20 行缩到 1 行。
 */
public class DeptDao {

    /** 新增部门，返回影响行数 */
    public int insert(String name) {
        String sql = "insert into dept(name) values(?)";
        try (Connection con = DriverManager.getConnection(DbConfig.url(), DbConfig.user(), DbConfig.password());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** 删除部门，返回影响行数 */
    public int delete(int id) {
        String sql = "delete from dept where id=?";
        try (Connection con = DriverManager.getConnection(DbConfig.url(), DbConfig.user(), DbConfig.password());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** 修改部门名称，返回影响行数 */
    public int update(int id, String name) {
        String sql = "update dept set name=? where id=?";
        try (Connection con = DriverManager.getConnection(DbConfig.url(), DbConfig.user(), DbConfig.password());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** 根据主键查询单个部门，查不到返回 null */
    public Dept findById(int id) {
        String sql = "select id, name from dept where id=?";
        try (Connection con = DriverManager.getConnection(DbConfig.url(), DbConfig.user(), DbConfig.password());
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Dept(rs.getInt("id"), rs.getString("name"));
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** 查询全部部门 */
    public List<Dept> findAll() {
        String sql = "select id, name from dept order by id";
        List<Dept> depts = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DbConfig.url(), DbConfig.user(), DbConfig.password());
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Dept d = new Dept();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                depts.add(d);
            }
            return depts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
