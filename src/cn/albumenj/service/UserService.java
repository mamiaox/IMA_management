package cn.albumenj.service;

import cn.albumenj.dao.mysqlConnect;
import cn.albumenj.model.user;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserService {
    private static List<user> userData;

    public boolean add(user addUser){
        return mysqlConnect.insert("users",userToData(addUser));
    }

    public user check(user loginUser){
        flashUserData();
        for(user user:userData)
            if(user.getID()==loginUser.getID()
                    &&user.getPassword().compareTo(loginUser.getPassword())==0)
                return user;
        return null;
    }

    public boolean delete(user deleteUser){
        return mysqlConnect.delete("users",deleteUser.getNo());
    }

    public List<user> fetchAllUser(){
        flashUserData();
        return userData;
    }

    public user fetchUserByID(int ID){
        flashUserData();
        for(user user:userData) {
            if (user.getID() == ID)
                return user;
        }
        return new user();
    }
    public boolean modify(user modifyUser){
        return mysqlConnect.update("users",modifyUser.getNo(),userToData(modifyUser));
    }

    private user dataTOUser(Map<String,String> data){
        user user = new user();
        user.setNo(Integer.parseInt(data.get("no")));
        user.setID(Integer.parseInt(data.get("id")));
        user.setPassword(data.get("password"));
        user.setName(data.get("name"));
        user.setPhone(data.get("phone"));
        user.setQq(data.get("qq"));
        user.setDepartment(Integer.parseInt(data.get("department")));
        user.setPermission(Integer.parseInt(data.get("permission")));
        return user;
    }

    private List<user> dataListToUser(List<Map<String,String>> dataList){
        List<user> userList = new LinkedList<>();
        for(Map<String,String> data:dataList)
            userList.add(dataTOUser(data));
        return userList;
    }

    private void flashUserData(){
        userData = dataListToUser(mysqlConnect.select("users"));
    }

    private Map<String,String> userToData(user user){
        Map<String,String> data = new LinkedHashMap<>();
        data.put("id",user.getID()+"");
        data.put("password",user.getPassword());
        data.put("name",user.getName());
        data.put("phone",user.getPhone());
        data.put("qq",user.getQq());
        data.put("department",user.getDepartment()+"");
        data.put("permission",user.getPermission()+"");
        return data;
    }
}
