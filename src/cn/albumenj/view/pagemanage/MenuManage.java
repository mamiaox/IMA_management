package cn.albumenj.view.pagemanage;

import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.view.Manage;
import cn.albumenj.view.Menu;
import cn.albumenj.view.menupage.MenuPage;

/**
 * @author Albumen
 */
public class MenuManage extends Manage {
    @Override
    public void show(){
        Menu menuPage = new MenuPage();
        //获取进入选项
        int method = menuPage.show();
        switch (method) {
            case 1:
                //人员管理
                StaffManage staffManage = new StaffManage();
                staffManage.setDepartmentService(departmentService);
                staffManage.setUserService(userService);
                staffManage.show();
                show();
                break;
            case 2:
                //部门管理
                DepartmentManage departmentManage = new DepartmentManage();
                departmentManage.setDepartmentService(departmentService);
                departmentManage.show();
                show();
                break;
            case 3:
                //退出
                return;
            default:
                break;
        }
    }
}
