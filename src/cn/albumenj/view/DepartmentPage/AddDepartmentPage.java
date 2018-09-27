package cn.albumenj.view.DepartmentPage;

import cn.albumenj.Application;
import cn.albumenj.model.department;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.FlushPage;
import cn.albumenj.util.PrintLine;
import cn.albumenj.util.RequestEnter;

public class AddDepartmentPage {

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

        department addDepartment = new department();
        System.out.print("请输入增加部门的编号：");
        addDepartment.setID(RequestEnter.requestInt());

        System.out.print("请输入增加部门的名字：");
        addDepartment.setName(RequestEnter.requestString());

        System.out.println("正在添加请等待！");
        boolean ret = departmentService.add(addDepartment);

        if(ret)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");

        PrintLine.print();
    }
}
