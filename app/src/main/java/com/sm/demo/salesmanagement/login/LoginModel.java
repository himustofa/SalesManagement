package com.sm.demo.salesmanagement.login;

import java.sql.Timestamp;

public class LoginModel {

    private int loginId;
    private String userName;
    private String passWord;
    private String loginTime;

    public LoginModel(int loginId, String userName, String passWord, String loginTime) {
        this.loginId = loginId;
        this.userName = userName;
        this.passWord = passWord;
        this.loginTime = loginTime;
    }

    public LoginModel(String userName, String passWord, String loginTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.loginTime = loginTime;
    }

    public LoginModel(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
}
