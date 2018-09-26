package cn.albumenj.view.StaffPage;

import cn.albumenj.Application;
import cn.albumenj.model.user;
import cn.albumenj.service.User.fetchUser;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;
import cn.albumenj.service.User.deleteUser;

public class DeleteStaffPage {
    private Application application;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void show(){
        flushPage.flush();
        printLine.print();

        System.out.print("请输入要删除人员学号：");
        user user = new fetchUser().fetchUserByID(requestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(user.getID() + " " +
                user.getName() + " " + user.getPhone() + " " +user.getQq()+ " " +user.getPermission());
        System.out.println();

        System.out.print("是否删除（是 1 /否 2）：");
        switch (requestEnter.requestInt()){
            case 1:
                boolean ret = new deleteUser().delete(user);
                if(ret)
                    System.out.println("删除成功！");
                else
                    System.out.println("删除失败！");
                break;
            case 2:
                break;
            default:
                break;
        }
        printLine.print();
    }
}