package com.icooer.myservlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhoushuai on 30/04/2017.
 */
public class DealRequest {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public DealRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;
    }

    public void delAction() {
        String action = request.getParameter(Config.ACTION);
        switch (action) {
            case Config.LOGIN:
                LoginDeal.login(request, response);//登录
                break;
            case Config.REGISTER:
                new RegisterDeal(request, response).register();
                break;
            case Config.PUBLISH:
                new PublishDeal(request, response).publish();
                break;
        }

    }




}
