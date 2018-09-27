package cn.albumenj.view.StaffPage;

import cn.albumenj.Application;
import cn.albumenj.model.department;
import cn.albumenj.model.user;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.passwordDecode;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

import java.util.List;

public class AddStaffPage {
    private Application application;
    private UserService userService;
    private DepartmentService departmentService;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void show(){
        flushPage.flush();
        printLine.print();

        user addUser = new user();
        System.out.print("请输入增加人员的学号：");
        addUser.setID(requestEnter.requestInt());

        System.out.print("请输入增加人员的密码：");
        addUser.setPassword(passwordDecode.EncoderByMd5(requestEnter.requestString()));

        System.out.print("请输入增加人员的姓名：");
        addUser.setName(requestEnter.requestString());

        System.out.print("请输入增加人员的电话号码：");
        addUser.setPhone(requestEnter.requestString());

        System.out.print("请输入增加人员的QQ：");
        addUser.setQq(requestEnter.requestString());


        List<department> departments = departmentService.fetchAllDepartment();
        System.out.println("部门编号如下");
        System.out.println("   编号     名字 ");

        for (department department : departments) {
            System.out.println(department.getID() + " " + department.getName());
        }

        System.out.print("请输入增加人员的部门：");
        addUser.setDepartment(requestEnter.requestInt());

        System.out.println("权限编号如下如下");
        System.out.println("1   会长");
        System.out.println("2   部长");
        System.out.println("3   普通成员");

        System.out.print("请输入增加人员的权限：");
        addUser.setPermission(requestEnter.requestInt());

        System.out.println("正在添加请等待！");
        boolean ret = userService.add(addUser);

        if(ret)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");

        printLine.print();
    }

}
