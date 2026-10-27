package com.aaa.util;

/**
 * JDBC 连接参数统一放在这里，改密码只改这一处。
 */
public final class DbConfig {

    /** 数据库地址：127.0.0.1 而不是 localhost，避免 Windows 解析到 IPv6 ::1 */
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/day02"
                    + "?useUnicode=true"
                    + "&characterEncoding=UTF-8"
                    + "&serverTimezone=Asia/Shanghai"
                    + "&useSSL=false"
                    + "&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private DbConfig() {
    }

    public static String url() {
        return URL;
    }

    public static String user() {
        return USER;
    }

    public static String password() {
        return PASSWORD;
    }
}
