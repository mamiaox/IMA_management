package cn.albumenj.service;

import cn.albumenj.dao.SqlCommit;
import cn.albumenj.model.SqlCommitModel;
import cn.albumenj.model.UserModel;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Albumen
 */
public class UserService {
    public boolean add(UserModel addUserModel){
        SqlCommitModel sqlCommitModel = new SqlCommitModel();
        sqlCommitModel.setTable("users");
        sqlCommitModel.setData(userToData(addUserModel));
        return SqlCommit.insert(sqlCommitModel);
    }

    public UserModel check(UserModel loginUserModel){
        Map<String,String> condition = new LinkedHashMap<>();
        condition.put("id",loginUserModel.getID()+"");
        List<UserModel> result = selectUserData(condition);

        for(UserModel UserModel : result) {
            if (UserModel.getID() == loginUserModel.getID()
                    && UserModel.getPassword().compareTo(loginUserModel.getPassword()) == 0) {
                return UserModel;
            }
        }
        return null;
    }

    public boolean delete(UserModel deleteUserModel){
        SqlCommitModel sqlCommitModel = new SqlCommitModel();
        sqlCommitModel.setTable("users");
        sqlCommitModel.setNo(deleteUserModel.getNo());
        return SqlCommit.delete(sqlCommitModel);
    }

    public List<UserModel> fetchAllUser(){
        Map<String,String> condition = new LinkedHashMap<>();
        return selectUserData(condition);
    }

    public UserModel fetchUserByID(int ID){
        Map<String,String> condition = new LinkedHashMap<>();
        condition.put("id",ID+"");
        List<UserModel> result = selectUserData(condition);

        for(UserModel UserModel : result) {
            if (UserModel.getID() == ID) {
                return UserModel;
            }
        }
        return new UserModel();
    }
    public boolean modify(UserModel modifyUserModel){
        SqlCommitModel sqlCommitModel = new SqlCommitModel();
        sqlCommitModel.setTable("users");
        sqlCommitModel.setNo(modifyUserModel.getNo());
        sqlCommitModel.setData(userToData(modifyUserModel));
        return SqlCommit.update(sqlCommitModel);
    }

    private UserModel dataTOUser(Map<String,String> data){
        UserModel UserModel = new UserModel();
        UserModel.setNo(Integer.parseInt(data.get("no")));
        UserModel.setID(Integer.parseInt(data.get("id")));
        UserModel.setPassword(data.get("password"));
        UserModel.setName(data.get("name"));
        UserModel.setPhone(data.get("phone"));
        UserModel.setQq(data.get("qq"));
        UserModel.setDepartment(Integer.parseInt(data.get("department")));
        UserModel.setPermission(Integer.parseInt(data.get("permission")));
        return UserModel;
    }

    private List<UserModel> dataListToUser(List<Map<String,String>> dataList){
        List<UserModel> userModelList = new LinkedList<>();
        for(Map<String,String> data:dataList) {
            userModelList.add(dataTOUser(data));
        }
        return userModelList;
    }

    private List<UserModel> selectUserData(Map<String,String> condition){
        SqlCommitModel sqlCommitModel = new SqlCommitModel();
        sqlCommitModel.setTable("users");
        sqlCommitModel.setCondition(condition);
        return dataListToUser(SqlCommit.selectWhere(sqlCommitModel));
    }

    private Map<String,String> userToData(UserModel UserModel){
        Map<String,String> data = new LinkedHashMap<>();
        data.put("id", UserModel.getID()+"");
        data.put("password", UserModel.getPassword());
        data.put("name", UserModel.getName());
        data.put("phone", UserModel.getPhone());
        data.put("qq", UserModel.getQq());
        data.put("DepartmentModel", UserModel.getDepartment()+"");
        data.put("permission", UserModel.getPermission()+"");
        return data;
    }
}
