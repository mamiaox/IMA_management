package cn.albumenj.view.staffpage;

import cn.albumenj.model.UserModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class ListStaffPage extends Method {
    @Override
    public void page(){
        System.out.print("请输入要查询人员学号：");
        UserModel userModel = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(userModel.getID() + " " +
                userModel.getName() + " " + userModel.getPhone() + " " +
                userModel.getQq()+ " " + userModel.getPermission());

        System.out.println();
        RequestEnter.requestContinue();
    }
}
