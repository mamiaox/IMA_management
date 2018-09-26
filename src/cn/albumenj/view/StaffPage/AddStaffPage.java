package cn.albumenj.view.StaffPage;

import cn.albumenj.Application;
import cn.albumenj.model.user;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;
import cn.albumenj.service.User.addUser;

public class AddStaffPage {
    private Application application;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void show(){
        flushPage.flush();
        printLine.print();

        user addUser = new user();
        System.out.print("请输入增加人员的学号：");
        addUser.setID(requestEnter.requestInt());

        System.out.print("请输入增加人员的姓名：");
        addUser.setName(requestEnter.requestString());

        System.out.print("请输入增加人员的电话号码：");
        addUser.setPhone(requestEnter.requestString());

        System.out.print("请输入增加人员的QQ：");
        addUser.setQq(requestEnter.requestString());

        System.out.print("请输入增加人员的部门：");
        addUser.setQq(requestEnter.requestString());

        System.out.print("请输入增加人员的权限：");
        addUser.setPermission(requestEnter.requestInt());

        System.out.println("正在添加请等待！");
        boolean ret = new addUser().add(addUser);

        if(ret)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");

        printLine.print();
        return;
    }

}
