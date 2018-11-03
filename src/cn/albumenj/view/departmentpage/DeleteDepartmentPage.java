package cn.albumenj.view.departmentpage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class DeleteDepartmentPage extends Method {
    @Override
    public void page() {
        System.out.print("请输入要删除部门编号：");
        DepartmentModel departmentModel = departmentService.fetchDepartmentByID(RequestEnter.requestInt());

        System.out.println("   编号     名字 ");
        System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        System.out.println();

        if(RequestEnter.requestContinueDo()) {
            boolean ret = departmentService.delete(departmentModel);
            resultOutput(ret, method.DELETE);
        }
    }
}
