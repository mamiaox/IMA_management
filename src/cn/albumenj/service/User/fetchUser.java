package cn.albumenj.service.User;

import cn.albumenj.model.user;

import java.util.LinkedList;
import java.util.List;

public class fetchUser {
    public List<user> fetchAllUser(){
        List<user> users = new LinkedList<>();
        return  users;
    }

    public user fetchUserByID(int ID){
        user user = new user();
        return user;
    }
}
