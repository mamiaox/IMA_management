package cn.albumenj.view.DepartmentPage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.CommandLineUtil.FlushPage;
import cn.albumenj.util.CommandLineUtil.PrintLine;
import cn.albumenj.util.CommandLineUtil.RequestEnter;

public class ModifyDepartmentPage {
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要查询部门编号：");
        DepartmentModel departmentModel = departmentService.fetchDepartmentByID(RequestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        System.out.println();

        System.out.print("是否修改（是 1 /否 2）：");
        switch (RequestEnter.requestInt()){
            case 1:
                System.out.print("请输入修改后部门编号：");
                departmentModel.setID(RequestEnter.requestInt());

                System.out.print("请输入修改后部门名称：");
                departmentModel.setName(RequestEnter.requestString());

                boolean ret = departmentService.modify(departmentModel);
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
        PrintLine.print();
    }
}
