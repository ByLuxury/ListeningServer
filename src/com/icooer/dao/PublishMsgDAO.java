package com.icooer.dao;

import com.icooer.bean.PublishMsgnfo;
import com.icooer.bean.SenderAndMsg;
import com.icooer.myservlet.Config;
import com.icooer.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoushuai on 01/05/2017.
 */
public class PublishMsgDAO {

    private static Connection conn;

    static {
        conn = JDBCUtil.openConnection();
    }

    /**
     * 发布消息
     *
     * @param publishMsgnfo
     * @return
     */

    public static boolean publishMsg(PublishMsgnfo publishMsgnfo) {

        String sql = "insert into publish_msg_table(phone,msg) values(?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, publishMsgnfo.getPhone());
            pstmt.setString(2, publishMsgnfo.getMsg());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询信息
     */
    public static List<SenderAndMsg> queryMsg(String phone) {
        String sql = "select nickname,msg from teacher_table t," +
                "publish_msg_table p where t.phone=p.phone AND p.phone=?";
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,phone);
            rs = pstmt.executeQuery();
            List<SenderAndMsg> senderAndMsgList = new ArrayList<>();
            while (rs.next()) {
                SenderAndMsg senderAndMsg = new SenderAndMsg();
                senderAndMsg.setNickname(rs.getString(Config.NICKNAME));
                senderAndMsg.setMsg(rs.getString(Config.MSG));
                senderAndMsgList.add(senderAndMsg);
            }
            return senderAndMsgList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
