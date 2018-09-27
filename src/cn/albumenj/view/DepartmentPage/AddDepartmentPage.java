package cn.albumenj.view.DepartmentPage;

import cn.albumenj.Application;
import cn.albumenj.model.department;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

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
        flushPage.flush();
        printLine.print();

        department addDepartment = new department();
        System.out.print("请输入增加部门的编号：");
        addDepartment.setID(requestEnter.requestInt());

        System.out.print("请输入增加部门的名字：");
        addDepartment.setName(requestEnter.requestString());

        System.out.println("正在添加请等待！");
        boolean ret = departmentService.add(addDepartment);

        if(ret)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");

        printLine.print();
    }
}
