package cn.albumenj.model;

import cn.albumenj.Application;

import java.util.Date;

/**
 * @author Albumen
 */
public class LogModel {
    private UserModel userModel;
    private String action;
    private String time;

    public LogModel(String action) {
        setAction(action);
        setUserModel(Application.loginedUserModel);
        setTime();
    }

    private void setTime() {
        this.time = new Date().toString();
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

    private void setAction(String action) {
        this.action = action;
    }

    private void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
