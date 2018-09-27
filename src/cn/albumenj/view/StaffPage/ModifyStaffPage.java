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

public class ModifyStaffPage {
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

        System.out.print("请输入要查询人员学号：");
        user user = userService.fetchUserByID(requestEnter.requestInt());

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

                System.out.print("请输入增加人员的密码：");
                user.setPassword(passwordDecode.EncoderByMd5(requestEnter.requestString()));

                System.out.print("请输入修改后人员的电话号码：");
                user.setPhone(requestEnter.requestString());

                System.out.print("请输入修改后人员的QQ：");

                user.setQq(requestEnter.requestString());
                List<department> departments = departmentService.fetchAllDepartment();
                System.out.println("部门编号如下");
                System.out.println("   编号     名字 ");

                for (department department : departments) {
                    System.out.println(department.getID() + " " + department.getName());
                }

                System.out.print("请输入修改后人员的部门：");
                user.setDepartment(requestEnter.requestInt());

                System.out.println("权限编号如下如下");
                System.out.println("1   会长");
                System.out.println("2   部长");
                System.out.println("3   普通成员");

                System.out.print("请输入修改后人员的权限：");
                user.setPermission(requestEnter.requestInt());

                boolean ret = userService.modify(user);
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
