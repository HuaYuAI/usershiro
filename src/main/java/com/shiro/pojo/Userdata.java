package com.shiro.pojo;

public class Userdata {
    private String uid;

    private Integer userstatus;

    private String username;

    private String password;

    private String usersort;

    private String registertime;

    private String connecttime;

    private String usertoken;

    private String tokencreattime;

    private String logouttime;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsersort() {
        return usersort;
    }

    public void setUsersort(String usersort) {
        this.usersort = usersort == null ? null : usersort.trim();
    }

    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime == null ? null : registertime.trim();
    }

    public String getConnecttime() {
        return connecttime;
    }

    public void setConnecttime(String connecttime) {
        this.connecttime = connecttime == null ? null : connecttime.trim();
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken == null ? null : usertoken.trim();
    }

    public String getTokencreattime() {
        return tokencreattime;
    }

    public void setTokencreattime(String tokencreattime) {
        this.tokencreattime = tokencreattime == null ? null : tokencreattime.trim();
    }

    public String getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(String logouttime) {
        this.logouttime = logouttime == null ? null : logouttime.trim();
    }
}