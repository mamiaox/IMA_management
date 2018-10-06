package cn.albumenj.view.departmentpage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

import java.util.List;

/**
 * @author Albumen
 */
public class ListAllDepartmentPage extends Method {
    @Override
    public void page(){
        List<DepartmentModel> departmentModels = departmentService.fetchAllDepartment();

        System.out.println("   编号     名字 ");

        for (DepartmentModel departmentModel : departmentModels) {
            System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        }

        System.out.println();
        RequestEnter.requestContinue();
    }
}
