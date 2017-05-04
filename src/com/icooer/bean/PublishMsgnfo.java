package com.icooer.bean;

/**
 * Created by zhoushuai on 01/05/2017.
 */
public class PublishMsgnfo {
    private String phone;
    private String msg;

    public PublishMsgnfo() {
    }

    public PublishMsgnfo(String phone, String msg) {
        this.phone = phone;
        this.msg = msg;
    }

    public String getPhone() {
        return phone;
    }

    public String getMsg() {
        return msg;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
