package com.icooer.dao;

import com.icooer.bean.TeacherInfo;
import com.icooer.myservlet.Config;
import com.icooer.util.JDBCUtil;

import java.sql.*;

/**
 * Created by zhoushuai on 28/03/2017.
 */

/**
 * 老师操作类
 */
public class TeacherOperateDAO {
    private static Connection conn;
    private static PreparedStatement pstmt;

    static {
        conn = JDBCUtil.openConnection();
    }

    /**
     * 添加用户
     *
     * @param teacherInfo
     * @return
     */

    public static boolean addUser(TeacherInfo teacherInfo) {

        String sql = "insert into teacher_table(phone,nickname,teacher_pwd,teacher_circle,teacher_school) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacherInfo.getPhone());
            pstmt.setString(2, teacherInfo.getNickname());
            pstmt.setString(3, teacherInfo.getPassword());
            pstmt.setString(4, teacherInfo.getSchool());
            pstmt.setString(5, teacherInfo.getCircle());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 登录查询
     * @param phone 传递进来主键电话码号码
     * @return 返回查找到的用户名
     */
    public static String queryData(String phone,String password) {
        String sql = "select * from teacher_table where phone=? and teacher_pwd=?";
        String nickname ;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, phone);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nickname=rs.getString(Config.NICKNAME);
                System.out.print(rs.getString(Config.PHONE_NUM) + ","
                        + rs.getString(Config.NICKNAME));
                return nickname;
            }
            String userSql="select * from teacher_table where phone=?";
            pstmt=conn.prepareStatement(userSql);
            pstmt.setString(1,phone);
            rs=pstmt.executeQuery();
            if(!rs.next()){
                return  Config.NO_USER;
            }

            String pwdSql="select * from teacher_table where teacher_pwd=?";
            pstmt=conn.prepareStatement(pwdSql);
            pstmt.setString(1,password);
            rs=pstmt.executeQuery();
            if(!rs.next()){
                return  Config.ERROR_PASSWORD;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
