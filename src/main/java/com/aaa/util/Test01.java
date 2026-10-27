package com.aaa.util;

import com.aaa.dao.DeptDao;
import com.aaa.entity.Dept;

import java.util.List;

/**
 * 测试入口：验证 增 / 删 / 改 / 查 四个方法。
 */
public class Test01 {

    public static void main(String[] args) {
        DeptDao deptDao = new DeptDao();

        System.out.println("===== 1. 初始数据 =====");
        printAll(deptDao);

        System.out.println();
        System.out.println("===== 2. 新增部门 =====");
        int row = deptDao.insert("研发部");
        System.out.println(row > 0 ? "添加成功，影响 " + row + " 行" : "添加失败");
        printAll(deptDao);

        System.out.println();
        System.out.println("===== 3. 修改部门 =====");
        List<Dept> list = deptDao.findAll();
        if (!list.isEmpty()) {
            Dept last = list.get(list.size() - 1);
            row = deptDao.update(last.getId(), "研发中心");
            System.out.println(row > 0 ? "修改成功：id=" + last.getId() : "修改失败");
        }
        printAll(deptDao);

        System.out.println();
        System.out.println("===== 4. 按 id 查单个 =====");
        Dept d = deptDao.findById(1);
        System.out.println(d == null ? "没有 id=1 的记录" : d);

        System.out.println();
        System.out.println("===== 5. 删除部门 =====");
        if (!list.isEmpty()) {
            Dept last = list.get(list.size() - 1);
            row = deptDao.delete(last.getId());
            System.out.println(row > 0 ? "删除成功：id=" + last.getId() : "删除失败");
        }
        printAll(deptDao);
    }

    private static void printAll(DeptDao dao) {
        List<Dept> all = dao.findAll();
        System.out.println("共 " + all.size() + " 条：");
        for (Dept dept : all) {
            System.out.println("  " + dept);
        }
    }
}
