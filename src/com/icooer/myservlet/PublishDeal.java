package com.icooer.myservlet;

import com.icooer.bean.PublishMsgnfo;
import com.icooer.dao.PublishMsgDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhoushuai on 01/05/2017.
 */
public class PublishDeal {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String phone;

    public PublishDeal() {

    }

    public PublishDeal(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void publish() {
        PrintWriter pw;
        String phone = request.getParameter(Config.PHONE_NUM);
        String msg = null;

        try {
            msg = new String(request.getParameter(Config.MSG).getBytes(Config.ISO_8859_1),
                    Config.UTF_8);//中文转码
            pw = response.getWriter();
            pw.println(Config.RETURN_RESULT_SUCCESS_STATUS);

            System.out.println("发布消息成功,msg=" + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PublishMsgnfo publishMsgnfo = new PublishMsgnfo(phone, msg);
        boolean isSuccess = PublishMsgDAO.publishMsg(publishMsgnfo);//tianjiadao数据库
        if (isSuccess) {
            this.phone = phone;
            System.out.print("添加消息到数据库成功");
        } else {
            System.out.print("添加消息到数据库失败");
        }
    }

    /**
     * 获取发送的消息
     *
     * @return
     */

    public PublishMsgnfo getSenderMsg() {
        PublishMsgnfo publishMsgnfo = new PublishMsgnfo();
        publishMsgnfo.setPhone(phone);

        return publishMsgnfo;
    }


}
