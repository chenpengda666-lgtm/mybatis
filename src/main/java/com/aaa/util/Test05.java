package com.aaa.util;

import com.aaa.dao.ClazzDao;
import com.aaa.dao.EmployeeDao;
import com.aaa.entity.Clazz;
import com.aaa.entity.Employee;
import com.aaa.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;
import java.util.Arrays;
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

//        List<Employee> list= mapper.selectByName("AAA' or '1'='1");
//        System.out.println(list);
//        session.commit();

        PageHelper.startPage(8, 5);
        List<Employee> list= mapper.selectPage();
//前端显示： 总条数  当前的页码  我们可以吧查询的结果封装到PageInfo类中。 自动包总条数  当前页码  当前页的数据
        PageInfo<Employee> pageInfo = new PageInfo<>(list); //响应给前端。
        System.out.println("总条数:"+pageInfo.getTotal());
        System.out.println("当前页的数据:"+pageInfo.getList());
        System.out.println("总页码:"+pageInfo.getPages());
        System.out.println("页码序列:"+ Arrays.toString(pageInfo.getNavigatepageNums()));
        session.commit();
//select * from employee where 1=1

    }
    }

