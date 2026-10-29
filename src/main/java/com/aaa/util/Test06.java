package com.aaa.util;

import com.aaa.dao.EmployeeDao;
import com.aaa.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test06 {
    //删除
//    @Test
//    public void testBatchDelete() throws Exception{
//        Reader reader = Resources.getResourceAsReader("conf.xml");
//        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session=sessionFactory.openSession();
//        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
//
//        List<Integer> ids = Arrays.asList(1);
//        int rows = mapper.batchDelete(ids);
//        System.out.println("删除行数："+rows);
//        session.commit(); // 删除、修改必须提交事务！
//        session.close();
//    }

    //添加
//    @Test
//    public void testBatchAdd() throws Exception{
//        Reader reader = Resources.getResourceAsReader("conf.xml");
//        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session=sessionFactory.openSession();
//        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
//
//        List<Employee> empList = new ArrayList<>();
//        empList.add(new Employee("张三","研发部","男",22));
//        empList.add(new Employee("李四","市场部","女",24));
//
//        int rows = mapper.batchAdd(empList);
//        System.out.println("新增行数："+rows);
//        session.commit(); // 新增也要提交事务
//        session.close();
//    }


    //修改
    @Test
    public void testUpdate() throws Exception{
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);

        Employee emp = new Employee();
        emp.setEmpId(2); // 必须指定要修改哪一条
        emp.setEmpName("王大锤");
        emp.setDept("黑室部");
        // 不想改的字段，不set就行

        int rows = mapper.updateByCondition(emp);
        System.out.println("修改行数："+rows);
        session.commit(); // 修改必须提交事务！
        session.close();



    }
}
