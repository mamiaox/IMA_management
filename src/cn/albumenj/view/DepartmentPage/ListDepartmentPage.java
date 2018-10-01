package cn.albumenj.view.DepartmentPage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.CommandLineUtil.FlushPage;
import cn.albumenj.util.CommandLineUtil.PrintLine;
import cn.albumenj.util.CommandLineUtil.RequestEnter;

import java.util.List;

public class ListDepartmentPage {

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void showALL() {
        FlushPage.flush();
        PrintLine.print();

        List<DepartmentModel> departmentModels = departmentService.fetchAllDepartment();

        System.out.println("   编号     名字 ");

        for (DepartmentModel departmentModel : departmentModels) {
            System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        }

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        RequestEnter.requestString();
        PrintLine.print();
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要查询部门编号：");
        DepartmentModel departmentModel = departmentService.fetchDepartmentByID(RequestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        System.out.println();

        System.out.println();
        System.out.println("请输入任意内容以返回。");
        RequestEnter.requestString();
        PrintLine.print();
    }
}
