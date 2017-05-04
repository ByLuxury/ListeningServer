package com.icooer.bean;

/**
 * Created by zhoushuai on 28/03/2017.
 */
public class TeacherInfo {
    private String username;
    private String nickname;
    private String password;
    private String serial;
    private String phone;
    private String school;
    private String email;
    private String rank;
    private String circle;

    public String getCircle() {
        return circle;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public TeacherInfo(String name, String password) {

    }

    /**
     * 初始化进入
     *
     * @param phone
     * @param nickname
     * @param password
     */
    public TeacherInfo(String phone, String nickname, String password,String circle,String school) {
        this.phone = phone;
        this.password = password;
        this.nickname = nickname;
        this.circle=circle;
        this.school=school;
    }

    public TeacherInfo(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSerial() {
        return serial;
    }

    public String getPhone() {
        return phone;
    }

    public String getSchool() {
        return school;
    }

    public String getEmail() {
        return email;
    }

    public String getRank() {
        return rank;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
