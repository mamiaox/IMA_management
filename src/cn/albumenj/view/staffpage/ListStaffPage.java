package cn.albumenj.view.staffpage;

import cn.albumenj.model.UserModel;
import cn.albumenj.service.UserService;
import cn.albumenj.util.commandlineutil.FlushPage;
import cn.albumenj.util.commandlineutil.PrintLine;
import cn.albumenj.util.commandlineutil.RequestEnter;

import java.util.List;

/**
 * @author Albumen
 */
public class ListStaffPage {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void showALL(){
        FlushPage.flush();
        PrintLine.print();

        List<UserModel> userModels = userService.fetchAllUser();

        System.out.println("   学号     姓名     电话     QQ    权限");
        for (UserModel userModel : userModels) {
            System.out.println(userModel.getID() + " " +
                    userModel.getName() + " " + userModel.getPhone() + " " +
                    userModel.getQq()+ " " + userModel.getPermission());
        }

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        RequestEnter.requestString();
        PrintLine.print();
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要查询人员学号：");
        UserModel userModel = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(userModel.getID() + " " +
                userModel.getName() + " " + userModel.getPhone() + " " +
                userModel.getQq()+ " " + userModel.getPermission());

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        RequestEnter.requestString();
        PrintLine.print();
    }
}
