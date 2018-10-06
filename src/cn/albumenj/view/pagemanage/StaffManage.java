package cn.albumenj.view.pagemanage;

import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.view.Manage;
import cn.albumenj.view.Menu;
import cn.albumenj.view.Method;
import cn.albumenj.view.menupage.StaffManagePage;
import cn.albumenj.view.staffpage.*;

/**
 * @author Albumen
 */
public class StaffManage extends Manage {
    @Override
    public void show(){
        Menu staffManagePage = new StaffManagePage();
        int methodStaff = staffManagePage.show();
        if (cn.albumenj.Application.loginedUserModel.isAdmin()) {
            //会长及部长权限
            switch (methodStaff) {
                case 1:
                    //列出所有人员
                    Method listAllStaffPage = new ListAllStaffPage();
                    listAllStaffPage.setUserService(userService);
                    listAllStaffPage.show();
                    break;
                case 2:
                    //查询指定人员
                    Method listStaffPage = new ListStaffPage();
                    listStaffPage.setUserService(userService);
                    listStaffPage.show();
                    break;
                case 3:
                    //增加人员
                    Method addStaffPage = new AddStaffPage();
                    addStaffPage.setUserService(userService);
                    addStaffPage.setDepartmentService(departmentService);
                    addStaffPage.show();
                    break;
                case 4:
                    //删除人员
                    Method deleteStaffPage = new DeleteStaffPage();
                    deleteStaffPage.setUserService(userService);
                    deleteStaffPage.show();
                    break;
                case 5:
                    //修改人员信息
                    Method modifyStaffPage = new ModifyStaffPage();
                    modifyStaffPage.setUserService(userService);
                    modifyStaffPage.setDepartmentService(departmentService);
                    modifyStaffPage.show();
                    break;
                case 6:
                    //返回
                    break;
                default:
                    break;
            }
        } else {
            //普通成员权限
            switch (methodStaff) {
                case 1:
                    //列出所有人员
                    Method listAllStaffPage = new ListAllStaffPage();
                    listAllStaffPage.setUserService(userService);
                    listAllStaffPage.show();
                    break;
                case 2:
                    //查询所有人员
                    Method listStaffPage = new ListStaffPage();
                    listStaffPage.setUserService(userService);
                    listStaffPage.show();
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
