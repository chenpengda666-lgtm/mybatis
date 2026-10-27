package org.example;

import com.aaa.dao.UsersDao;
import com.aaa.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class AppTest02 {

    @Test  //查询
    public void test1() throws Exception{
        //1.读取配置文件---解析配置文件. mybatis知道连接的数据库和账号密码。 知道映射文件中内。
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //1. 获取SqlSession对象----理解为: Connection对象。类中包含对表的各种操作方法。
        SqlSession session=sessionFactory.openSession();
        //2.获取UsersDao的代理实现类对象。
        UsersDao mapper = session.getMapper(UsersDao.class);
        List<Users> all = mapper.get_all();
        System.out.println(all);
    }

    @Test  //添加
//    public void test2() throws Exception{
//        //1.读取配置文件---解析配置文件. mybatis知道连接的数据库和账号密码。 知道映射文件中内。
//        Reader reader = Resources.getResourceAsReader("conf.xml");
//        //2.获取SqlSessionFactory对象
//        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//        //1. 获取SqlSession对象----理解为: Connection对象。类中包含对表的各种操作方法。
//        SqlSession session=sessionFactory.openSession();
//        //2.获取UsersDao的代理实现类对象。
//        UsersDao mapper = session.getMapper(UsersDao.class);
//        Users user=new Users();
//        user.setName("fhd");
//        user.setAge(22);
//        int row=mapper.insert(user);
//        session.commit();
//    }

         //删除
//    public void test3() throws Exception{
//        //1.读取配置文件---解析配置文件. mybatis知道连接的数据库和账号密码。 知道映射文件中内。
//        Reader reader = Resources.getResourceAsReader("conf.xml");
//        //2.获取SqlSessionFactory对象
//        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//        //1. 获取SqlSession对象----理解为: Connection对象。类中包含对表的各种操作方法。
//        SqlSession session=sessionFactory.openSession();
//        //2.获取UsersDao的代理实现类对象。
//        UsersDao mapper = session.getMapper(UsersDao.class);
//        int row=mapper.delete(13);
//        session.commit();
//    }


              //修改
    public void test4() throws Exception{
        //1.读取配置文件---解析配置文件. mybatis知道连接的数据库和账号密码。 知道映射文件中内。
        Reader reader = Resources.getResourceAsReader("conf.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
        //1. 获取SqlSession对象----理解为: Connection对象。类中包含对表的各种操作方法。
        SqlSession session=sessionFactory.openSession();
        //2.获取UsersDao的代理实现类对象。
        UsersDao mapper = session.getMapper(UsersDao.class);
        Users user=new Users();
        user.setId(11);
        user.setName("冯浩东");
        user.setAge(1);
        int row= mapper.update(user);
        session.commit();
    }

}
