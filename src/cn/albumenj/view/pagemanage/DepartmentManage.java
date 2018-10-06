package cn.albumenj.view.pagemanage;

import cn.albumenj.service.DepartmentService;
import cn.albumenj.view.Manage;
import cn.albumenj.view.Menu;
import cn.albumenj.view.Method;
import cn.albumenj.view.departmentpage.*;
import cn.albumenj.view.menupage.DepartmentManagePage;

/**
 * @author Albumen
 */
public class DepartmentManage extends Manage {
    @Override
    public void show() {
        //部门管理
        Menu departmentManagePage = new DepartmentManagePage();
        int methodDepartment = departmentManagePage.show();

        if (cn.albumenj.Application.loginedUserModel.isChairman()) {
            //会长权限
            switch (methodDepartment) {
                case 1:
                    //列出所有部门
                    Method listAllDepartmentPage = new ListAllDepartmentPage();
                    listAllDepartmentPage.setDepartmentService(departmentService);
                    listAllDepartmentPage.show();
                    break;
                case 2:
                    //查询指定部门
                    Method listDepartmentPage = new ListDepartmentPage();
                    listDepartmentPage.setDepartmentService(departmentService);
                    listDepartmentPage.show();
                    break;
                case 3:
                    //增加部门
                    Method addDepartmentPage = new AddDepartmentPage();
                    addDepartmentPage.setDepartmentService(departmentService);
                    addDepartmentPage.show();
                    break;
                case 4:
                    //删除部门
                    Method deleteDepartmentPage = new DeleteDepartmentPage();
                    deleteDepartmentPage.setDepartmentService(departmentService);
                    deleteDepartmentPage.show();
                    break;
                case 5:
                    //修改部门信息
                    Method modifyDepartmentPage = new ModifyDepartmentPage();
                    modifyDepartmentPage.setDepartmentService(departmentService);
                    modifyDepartmentPage.show();
                    break;
                case 6:
                    //返回
                    break;
                default:
                    break;
            }
        } else {
            //其他成员权限
            switch (methodDepartment) {
                case 1:
                    //列出所有部门
                    Method listAllDepartmentPage = new ListAllDepartmentPage();
                    listAllDepartmentPage.setDepartmentService(departmentService);
                    listAllDepartmentPage.show();
                    break;
                case 2:
                    //查询指定部门
                    Method listDepartmentPage = new ListDepartmentPage();
                    listDepartmentPage.setDepartmentService(departmentService);
                    listDepartmentPage.show();
                    break;
                case 3:
                    //返回
                    break;
                default:
                    break;
            }
        }
    }
}
