package cn.albumenj.view.DepartmentPage;

import cn.albumenj.model.department;
import cn.albumenj.model.user;
import cn.albumenj.service.Department.fetchDepartment;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

import java.util.List;

public class ListDepartmentPage {

    public void showALL(){
        flushPage.flush();
        printLine.print();

        List<department> departments = new fetchDepartment().fetchAllDepartment();

        System.out.println("   编号     名字 ");

        for(department department:departments) {
            System.out.println(department.getID() + " " + department.getName());
            System.out.println();
        }

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        requestEnter.requestString();
        printLine.print();
    }

    public void show(){
        flushPage.flush();
        printLine.print();

        System.out.print("请输入要查询部门编号：");
        department department = new fetchDepartment().fetchDepartmentByID(requestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(department.getID() + " " + department.getName());
        System.out.println();

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        requestEnter.requestString();
        printLine.print();
    }
}