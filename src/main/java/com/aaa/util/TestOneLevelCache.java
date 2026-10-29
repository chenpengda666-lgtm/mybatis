package com.aaa.util;

import com.aaa.dao.DeptMapper;
import com.aaa.entity.Dept;
import org.junit.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestOneLevelCache {

    @Test
    public void testOneLevelCache(){
        // 调用工具类，获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        // 打开第一个SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println("----------------第1次查询----------------");
        DeptMapper deptDao1 = sqlSession.getMapper(DeptMapper.class);
        Dept dept1 = deptDao1.queryById(101);
        if(dept1!=null){
            System.out.println(dept1);
        }

        System.out.println("----------------第2次查询----------------");
        DeptMapper deptDao2 = sqlSession.getMapper(DeptMapper.class);
        Dept dept2 = deptDao2.queryById(101);
        if(dept2!=null){
            System.out.println(dept2);
        }
        System.out.println("两次查询是否是同一个对象：" + (dept1 == dept2));

        // 新开一个SqlSession
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        System.out.println("----------------第3次查询（新session）----------------");
        DeptMapper deptDao3 = sqlSession2.getMapper(DeptMapper.class);
        Dept dept3 = deptDao3.queryById(101);
        if(dept3!=null){
            System.out.println(dept3);
        }
        System.out.println("不同session查询是否是同一个对象：" + (dept1 == dept3));

        // 更新操作，更新会清空当前session的一级缓存
        System.out.println("----------------执行修改操作----------------");
        DeptMapper deptDao5 = sqlSession2.getMapper(DeptMapper.class);
        deptDao5.update(new Dept(101,"开发部"));
        sqlSession2.commit();

        System.out.println("----------------第4次查询（更新后，sqlSession2）----------------");
        DeptMapper deptDao6 = sqlSession2.getMapper(DeptMapper.class);
        Dept dept6 = deptDao6.queryById(101);
        if(dept6!=null){
            System.out.println(dept6);
        }

        System.out.println("----------------第7次查询===== 不会执行语句----------------");
        DeptMapper deptDao7 = sqlSession2.getMapper(DeptMapper.class);
        Dept dept7 = deptDao7.queryById(101);
        if(dept7!=null){
            System.out.println(dept7);
        }

        System.out.println("----------------第7次和第8次查询中，执行清空缓存----------------");
        sqlSession2.clearCache();

        System.out.println("----------------第8次查询===== 因为缓存被清空，会执行sql----------------");
        DeptMapper deptDao8 = sqlSession2.getMapper(DeptMapper.class);
        Dept dept8 = deptDao8.queryById(101);
        if(dept8!=null){
            System.out.println(dept8);
        }

        System.out.println("----------------第9次查询=====不会执行语句----------------");
        DeptMapper deptDao9 = sqlSession2.getMapper(DeptMapper.class);
        Dept dept9 = deptDao9.queryById(101);
        if(dept9!=null){
            System.out.println(dept9);
        }

        // 关闭会话
        sqlSession.close();
        sqlSession2.close();
    }
}
