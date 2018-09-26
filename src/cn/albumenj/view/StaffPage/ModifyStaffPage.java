package cn.albumenj.view.StaffPage;

import cn.albumenj.Application;
import cn.albumenj.model.user;
import cn.albumenj.service.User.fetchUser;
import cn.albumenj.service.User.modifyUser;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

public class ModifyStaffPage {
    private Application application;

    public void setApplication(Application application) {
        this.application = application;
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

        System.out.print("是否修改（是 1 /否 2）：");
        switch (requestEnter.requestInt()){
            case 1:
                System.out.print("请输入修改后人员的学号：");
                user.setID(requestEnter.requestInt());

                System.out.print("请输入修改后人员的姓名：");
                user.setName(requestEnter.requestString());

                System.out.print("请输入修改后人员的电话号码：");
                user.setPhone(requestEnter.requestString());

                System.out.print("请输入修改后人员的QQ：");
                user.setQq(requestEnter.requestString());

                System.out.print("请输入修改后人员的部门：");
                user.setQq(requestEnter.requestString());

                System.out.print("请输入修改后人员的权限：");
                user.setPermission(requestEnter.requestInt());

                boolean ret = new modifyUser().modify(user);
                if(ret)
                    System.out.println("修改成功！");
                else
                    System.out.println("修改失败！");
                break;
            case 2:
                break;
            default:
                break;
        }
        printLine.print();
    }
}
