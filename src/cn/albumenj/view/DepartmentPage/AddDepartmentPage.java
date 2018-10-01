package cn.albumenj.view.DepartmentPage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.CommandLineUtil.FlushPage;
import cn.albumenj.util.CommandLineUtil.PrintLine;
import cn.albumenj.util.CommandLineUtil.RequestEnter;

public class AddDepartmentPage {
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        DepartmentModel addDepartmentModel = new DepartmentModel();
        System.out.print("请输入增加部门的编号：");
        addDepartmentModel.setID(RequestEnter.requestInt());

        System.out.print("请输入增加部门的名字：");
        addDepartmentModel.setName(RequestEnter.requestString());

        System.out.println("正在添加请等待！");
        boolean ret = departmentService.add(addDepartmentModel);

        if(ret)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");

        PrintLine.print();
    }
}
