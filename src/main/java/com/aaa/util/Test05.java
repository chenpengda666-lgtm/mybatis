package com.aaa.util;

import com.aaa.dao.ClazzDao;
import com.aaa.dao.EmployeeDao;
import com.aaa.entity.Clazz;
import com.aaa.entity.Employee;
import com.aaa.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class Test05 {
    @Test
    public void test1() throws Exception{
//1.读取配置文件---解析配置文件. mybatis知道连接的数据库和账号密码。 知道映射文件中内。
        Reader reader = Resources.getResourceAsReader("conf.xml");
//2.获取SqlSessionFactory对象
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//1. 获取SqlSession对象----理解为: Connection对象。类中包含对表的各种操作方法。
        SqlSession session=sessionFactory.openSession();
//2.获取UsersDao的代理实现类对象。
       EmployeeDao mapper=session.getMapper(EmployeeDao.class);
       Employee employee=new Employee();
//       employee.setDept("研发部");
//       employee.setEmpName("王浩");
       List<Employee> employees = mapper.selectByCondition(employee);
        System.out.println(employees);


        }
    }

