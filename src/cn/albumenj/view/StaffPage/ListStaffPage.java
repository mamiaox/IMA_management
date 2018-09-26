package cn.albumenj.view.StaffPage;

import cn.albumenj.model.user;
import cn.albumenj.service.User.fetchUser;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

import java.util.List;

public class ListStaffPage {

    public void showALL(){
        flushPage.flush();
        printLine.print();

        List<user> users = new fetchUser().fetchAllUser();

        System.out.println("   学号     姓名     电话     QQ    权限");
        for (user user:users) {
            System.out.println(user.getID() + " " +
                    user.getName() + " " + user.getPhone() + " " +user.getQq()+ " " +user.getPermission());
        }

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        requestEnter.requestString();
        printLine.print();
    }

    public void show(){
        flushPage.flush();
        printLine.print();

        System.out.print("请输入要查询人员学号：");
        user user = new fetchUser().fetchUserByID(requestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(user.getID() + " " +
                    user.getName() + " " + user.getPhone() + " " +user.getQq()+ " " +user.getPermission());

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        requestEnter.requestString();
        printLine.print();
    }
}
