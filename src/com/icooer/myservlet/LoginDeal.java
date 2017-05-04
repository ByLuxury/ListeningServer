package com.icooer.myservlet;

import com.icooer.dao.TeacherOperateDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhoushuai on 30/04/2017.
 */
public class LoginDeal {

    public static void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setCharacterEncoding(Config.UTF_8);
            PrintWriter pw = response.getWriter();
            String phone = request.getParameter(Config.PHONE_NUM);
            String password = request.getParameter(Config.PASSWORD);
            String queryData = TeacherOperateDAO.queryData(phone, password);//数据库中查找
            if (queryData == null) {
                pw.print(Config.RETURN_RESULT_FAIL_STATUS);
                return;
            }
            switch (queryData) {
                case Config.NO_USER:
                    pw.print(Config.RETURN_RESULT_NO_USER_STATUS);
                    break;
                case Config.ERROR_PASSWORD:
                    pw.print(Config.RETURN_RESULT_ERROR_PWD_STATUS);
                    break;
                default:
                    pw.println("{\"status\":1,\"token\":\"zhoushuai\",\"nickname\":" + "\""+queryData +"\"}");
                    break;
            }
            System.out.print(request.getParameter("phone"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

