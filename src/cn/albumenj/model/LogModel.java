package cn.albumenj.model;

import cn.albumenj.Application;

import java.util.Date;

public class LogModel {
    private UserModel userModel;
    private String action;
    private String time;

    public LogModel(String action) {
        setAction(action);
        setUserModel(Application.loginedUserModel);
        setTime();
    }

    public void setTime() {
        String time = new Date().toString();
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
