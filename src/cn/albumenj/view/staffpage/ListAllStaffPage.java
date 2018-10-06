package cn.albumenj.view.staffpage;

import cn.albumenj.model.UserModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

import java.util.List;

/**
 * @author Albumen
 */
public class ListAllStaffPage extends Method {
    @Override
    public void page(){
        List<UserModel> userModels = userService.fetchAllUser();

        System.out.println("   学号     姓名     电话     QQ    权限");
        for (UserModel userModel : userModels) {
            System.out.println(userModel.getID() + " " +
                    userModel.getName() + " " + userModel.getPhone() + " " +
                    userModel.getQq()+ " " + userModel.getPermission());
        }

        System.out.println();
        RequestEnter.requestContinue();
    }
}
