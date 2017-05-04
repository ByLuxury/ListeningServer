package com.icooer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhoushuai on 28/03/2017.
 */
public class JDBCUtil {
    private static String url;
    private static String driver;
    private static String username;
    private static String password;
    static {
        url = "jdbc:mysql://localhost:3306/listening?characterEncoding=utf8&&useSSL=true";
        driver = "com.mysql.jdbc.Driver";
        username = "root";
        password = "mysql";

    }

    /**
     *
     * 打开连接
     * @return
     */
    public static Connection openConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
