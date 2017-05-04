package com.icooer.myservlet;

import com.google.gson.Gson;
import com.icooer.bean.SenderAndMsg;
import com.icooer.dao.PublishMsgDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhoushuai on 02/05/2017.
 */
public class RefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        String phone = request.getParameter(Config.PHONE_NUM);
        List<SenderAndMsg> list = PublishMsgDAO.queryMsg(phone);
        for(int i=0;i<list.size();i++){
            Gson gson = new Gson();
            pw.write(gson.toJson(list));
            pw.flush();
        }

        System.out.print(list.size());


    }
}
