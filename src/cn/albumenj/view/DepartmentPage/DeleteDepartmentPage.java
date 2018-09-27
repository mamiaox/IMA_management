package cn.albumenj.view.DepartmentPage;

import cn.albumenj.Application;
import cn.albumenj.model.department;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.FlushPage;
import cn.albumenj.util.PrintLine;
import cn.albumenj.util.RequestEnter;

public class DeleteDepartmentPage {
    private Application application;
    private DepartmentService departmentService;

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要删除部门编号：");
        department department = departmentService.fetchDepartmentByID(RequestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(department.getID() + " " + department.getName());
        System.out.println();

        System.out.print("是否删除（是 1 /否 2）：");
        switch (RequestEnter.requestInt()){
            case 1:
                boolean ret = departmentService.delete(department);
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
