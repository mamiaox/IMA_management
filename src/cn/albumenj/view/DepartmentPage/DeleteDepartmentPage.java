package cn.albumenj.view.DepartmentPage;

import cn.albumenj.Application;
import cn.albumenj.model.department;
import cn.albumenj.model.user;
import cn.albumenj.service.Department.deleteDepartment;
import cn.albumenj.service.Department.fetchDepartment;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

public class DeleteDepartmentPage {
    private Application application;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void show(){
        flushPage.flush();
        printLine.print();

        System.out.print("请输入要删除部门编号：");
        department department = new fetchDepartment().fetchDepartmentByID(requestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(department.getID() + " " + department.getName());
        System.out.println();

        System.out.print("是否删除（是 1 /否 2）：");
        switch (requestEnter.requestInt()){
            case 1:
                boolean ret = new deleteDepartment().delete(department);
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
