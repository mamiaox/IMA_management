package cn.albumenj.view.StaffPage;

import cn.albumenj.model.user;
import cn.albumenj.service.UserService;
import cn.albumenj.util.FlushPage;
import cn.albumenj.util.PrintLine;
import cn.albumenj.util.RequestEnter;

import java.util.List;

public class ListStaffPage {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void showALL(){
        FlushPage.flush();
        PrintLine.print();

        List<user> users = userService.fetchAllUser();

        System.out.println("   学号     姓名     电话     QQ    权限");
        for (user user:users) {
            System.out.println(user.getID() + " " +
                    user.getName() + " " + user.getPhone() + " " +user.getQq()+ " " +user.getPermission());
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
        user user = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(user.getID() + " " +
                    user.getName() + " " + user.getPhone() + " " +user.getQq()+ " " +user.getPermission());

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        RequestEnter.requestString();
        PrintLine.print();
    }
}
