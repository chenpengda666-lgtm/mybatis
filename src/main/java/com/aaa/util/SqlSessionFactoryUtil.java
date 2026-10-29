package com.aaa.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory factory = null;
        try {
            // 加载resources下的conf.xml
            InputStream inputStream = Resources.getResourceAsStream("conf.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
