package com.icooer.bean;

import java.util.List;

/**
 * Created by zhoushuai on 02/05/2017.
 */
public class SenderAndMsg {
    private String phone;
    private String nickname;
    private String msg;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private List<SenderAndMsg> senderAndMsgList;

    public List<SenderAndMsg> getSenderAndMsgList() {
        return senderAndMsgList;
    }

    public void setSenderAndMsgList(List<SenderAndMsg> senderAndMsgList) {
        this.senderAndMsgList = senderAndMsgList;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMsg() {
        return msg;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
