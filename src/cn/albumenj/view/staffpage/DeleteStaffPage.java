package cn.albumenj.view.staffpage;

import cn.albumenj.model.UserModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class DeleteStaffPage extends Method {
    @Override
    public void page(){
        System.out.print("请输入要删除人员学号：");
        UserModel deleteUserModel = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(deleteUserModel.getID() + " " +
                deleteUserModel.getName() + " " + deleteUserModel.getPhone() + " " +
                deleteUserModel.getQq()+ " " + deleteUserModel.getPermission());
        System.out.println();

        if(RequestEnter.requestContinueDo()) {
            userService.delete(deleteUserModel);
        }
    }
}
