package cn.albumenj.view.departmentpage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class ModifyDepartmentPage extends Method {
    @Override
    public void page(){
        System.out.print("请输入要查询部门编号：");
        DepartmentModel departmentModel = departmentService.fetchDepartmentByID(RequestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        System.out.println();

        if(RequestEnter.requestContinueDo()) {
            System.out.print("请输入修改后部门编号：");
            departmentModel.setID(RequestEnter.requestInt());
            System.out.print("请输入修改后部门名称：");
            departmentModel.setName(RequestEnter.requestString());

            boolean ret = departmentService.modify(departmentModel);
            resultOutput(ret,cn.albumenj.view.Method.method.MODIFY);
        }
    }
}
