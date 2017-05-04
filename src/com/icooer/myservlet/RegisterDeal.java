package com.icooer.myservlet;

import com.icooer.bean.TeacherInfo;
import com.icooer.dao.TeacherOperateDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by zhoushuai on 30/04/2017.
 */
public class RegisterDeal {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String phone;
    private String nickname,newNickname;
    private String password ;
    private String circle,newCircle;
    private String school,newSchool;
    private TeacherInfo teacherInfo;

    public RegisterDeal(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

    }


    public void register() {
        phone = request.getParameter(Config.PHONE_NUM);
        nickname = request.getParameter(Config.NICKNAME);
        password = request.getParameter(Config.PASSWORD);
        circle = request.getParameter(Config.CIRCLE);
        school = request.getParameter(Config.SCHOOL);
        try {
            //中文转码
            newNickname = new String(nickname.getBytes(Config.ISO_8859_1), Config.UTF_8);
            newCircle = new String(circle.getBytes(Config.ISO_8859_1), Config.UTF_8);
            newSchool = new String(school.getBytes(Config.ISO_8859_1), Config.UTF_8);
            teacherInfo = new TeacherInfo(phone,
                    newNickname, password, newCircle, newSchool);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        TeacherInfo teacherInfo = new TeacherInfo(phone,
//                nickname, password, circle, school);
        boolean isAdd = TeacherOperateDAO.addUser(teacherInfo);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isAdd) {

            System.out.print("注册成功");
            try {
                System.out.print(new String(nickname.getBytes("iso-8859-1"), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            pw.println(Config.RETURN_RESULT_SUCCESS_STATUS);  //注册成功返回1

        } else {
            System.out.print("注册失败");
            pw.println(Config.RETURN_RESULT_FAIL_STATUS);//失败为0
        }


    }
}
