package cn.albumenj.view.StaffPage;

import cn.albumenj.Application;
import cn.albumenj.model.user;
import cn.albumenj.service.UserService;
import cn.albumenj.util.FlushPage;
import cn.albumenj.util.PrintLine;
import cn.albumenj.util.RequestEnter;

public class DeleteStaffPage {
    private Application application;
    private UserService userService;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要删除人员学号：");
        user user = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(user.getID() + " " +
                user.getName() + " " + user.getPhone() + " " +user.getQq()+ " " +user.getPermission());
        System.out.println();

        System.out.print("是否删除（是 1 /否 2）：");
        switch (RequestEnter.requestInt()){
            case 1:
                boolean ret = userService.delete(user);
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
        PrintLine.print();
    }
}
