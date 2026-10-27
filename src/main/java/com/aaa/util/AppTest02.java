package com.aaa.util;

import com.aaa.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class AppTest02
{
    @Test
    public void test01() throws Exception{
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        Users user= session.selectOne("aaa.UserDao.get_id",2);
        System.out.println(user);
        session.close();
    }

    @Test
    public void test02() throws Exception{
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        List<Users> userList = session.selectList("aaa.UserDao.get_all");
        System.out.println(userList);
        session.close();
    }

//    @Test
//    public void test03() throws Exception{
//        Reader reader = Resources.getResourceAsReader("conf.xml");
//        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session=sessionFactory.openSession();
//        Users user=new Users();
//        user.setName("陈月月");
//        user.setAge(18);
//        int row=session.insert("aaa.UserDao.add",user);
//        System.out.println("新增行数："+row);
//        session.commit();
//        session.close();
//    }

    @Test
    public void test04() throws Exception{
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        int row=session.delete("aaa.UserDao.delete",5);
        System.out.println("删除行数："+row);
        session.commit();
        session.close();
    }

    @Test
    public void test05() throws Exception{
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sessionFactory.openSession();
        Users user=new Users();
        user.setId(5);
        user.setName("李四");
        user.setAge(88);
        int row=session.update("aaa.UserDao.update",user);
        System.out.println("修改行数："+row);
        session.commit();
        session.close();
    }
}
