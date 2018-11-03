package cn.albumenj.view.departmentpage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class AddDepartmentPage extends Method {
    @Override
    public void page(){
        DepartmentModel addDepartmentModel = new DepartmentModel();
        System.out.print("请输入增加部门的编号：");
        addDepartmentModel.setID(RequestEnter.requestInt());

        System.out.print("请输入增加部门的名字：");
        addDepartmentModel.setName(RequestEnter.requestString());

        System.out.println("正在添加请等待！");
        boolean ret = departmentService.add(addDepartmentModel);
        resultOutput(ret, method.ADD);
    }
}
