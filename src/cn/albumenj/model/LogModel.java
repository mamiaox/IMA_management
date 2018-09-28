package cn.albumenj.model;

import java.util.Date;

public class LogModel {
    private user user;
    private String action;
    private String time;

    public LogModel(user user,String action){
        setAction(action);
        setUser(user);
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

    public cn.albumenj.model.user getUser() {
        return user;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setUser(cn.albumenj.model.user user) {
        this.user = user;
    }
}
