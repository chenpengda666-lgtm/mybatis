package com.aaa.util;

import com.aaa.dao.ClazzDao;
import com.aaa.dao.OrdersDao;
import com.aaa.entity.Clazz;
import com.aaa.entity.Orders;
import com.aaa.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class AppTest04 {

    @Test
    public void test1() throws Exception{
//1.读取配置文件---解析配置文件. mybatis知道连接的数据库和账号密码。 知道映射文件中内。
        Reader reader = Resources.getResourceAsReader("conf.xml");
//2.获取SqlSessionFactory对象
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//1. 获取SqlSession对象----理解为: Connection对象。类中包含对表的各种操作方法。
        SqlSession session=sessionFactory.openSession();
//2.获取UsersDao的代理实现类对象。
        ClazzDao mapper = session.getMapper(ClazzDao.class);
        Clazz clazz = mapper.getById(2);
        System.out.println("班级:"+clazz.getCname()+"下的所有学生如下:");
        for(Student s:clazz.getStudents()){
            System.out.println("学号:"+s.getSid()+";名字:"+s.getSname());
        }
    }

}


