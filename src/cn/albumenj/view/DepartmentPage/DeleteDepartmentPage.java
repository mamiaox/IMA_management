package cn.albumenj.view.DepartmentPage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.CommandLineUtil.FlushPage;
import cn.albumenj.util.CommandLineUtil.PrintLine;
import cn.albumenj.util.CommandLineUtil.RequestEnter;

public class DeleteDepartmentPage {
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要删除部门编号：");
        DepartmentModel departmentModel = departmentService.fetchDepartmentByID(RequestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        System.out.println();

        System.out.print("是否删除（是 1 /否 2）：");
        switch (RequestEnter.requestInt()){
            case 1:
                boolean ret = departmentService.delete(departmentModel);
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
