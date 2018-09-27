package cn.albumenj;
import cn.albumenj.dao.mysqlConnect;
import cn.albumenj.model.*;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.view.DepartmentPage.AddDepartmentPage;
import cn.albumenj.view.DepartmentPage.DeleteDepartmentPage;
import cn.albumenj.view.DepartmentPage.ListDepartmentPage;
import cn.albumenj.view.DepartmentPage.ModifyDepartmentPage;
import cn.albumenj.view.MenuPage.DepartmentManagePage;
import cn.albumenj.view.MenuPage.LoginPage;
import cn.albumenj.view.MenuPage.MenuPage;
import cn.albumenj.view.MenuPage.StaffManagePage;
import cn.albumenj.view.StaffPage.*;

public class Application {
    public user loginedUser;

    public static void main(String[] args) {

        mysqlConnect.connect();
        //Login Page
        Application app = new Application();
        UserService userService = new UserService();
        DepartmentService departmentService = new DepartmentService();
        LoginPage loginPage = new LoginPage();
        loginPage.setApplication(app);
        loginPage.setUserService(userService);
        if(loginPage.show()){
            //Login Success

            while(true) {
                MenuPage menuPage = new MenuPage();
                menuPage.setApplication(app);
                int method = menuPage.show(); //获取进入选项
                switch (method) {
                    case 1:
                        StaffManagePage staffManagePage = new StaffManagePage();
                        staffManagePage.setApplication(app);
                        int methodStaff = staffManagePage.show();
                        if(app.loginedUser.getPermission()==1
                            ||app.loginedUser.getPermission()==2)
                            //会长及部长
                            switch (methodStaff){
                                case 1:
                                    ListStaffPage listStaffPage1 = new ListStaffPage();
                                    listStaffPage1.setUserService(userService);
                                    listStaffPage1.showALL();
                                    break;
                                case 2:
                                    ListStaffPage listStaffPage2 = new ListStaffPage();
                                    listStaffPage2.setUserService(userService);
                                    listStaffPage2.show();
                                    break;
                                case 3:
                                    AddStaffPage addStaffPage = new AddStaffPage();
                                    addStaffPage.setApplication(app);
                                    addStaffPage.setUserService(userService);
                                    addStaffPage.setDepartmentService(departmentService);
                                    addStaffPage.show();
                                    break;
                                case 4:
                                    DeleteStaffPage deleteStaffPage = new DeleteStaffPage();
                                    deleteStaffPage.setApplication(app);
                                    deleteStaffPage.setUserService(userService);
                                    deleteStaffPage.show();
                                    break;
                                case 5:
                                    ModifyStaffPage modifyStaffPage = new ModifyStaffPage();
                                    modifyStaffPage.setApplication(app);
                                    modifyStaffPage.setUserService(userService);
                                    modifyStaffPage.show();
                                    break;
                                case 6:
                                    break;
                                default:
                                    break;
                            }
                            else{
                                //普通成员
                                switch (methodStaff){
                                    case 1:
                                        ListStaffPage listStaffPage1 = new ListStaffPage();
                                        listStaffPage1.setUserService(userService);
                                        listStaffPage1.showALL();
                                        break;
                                    case 2:
                                        ListStaffPage listStaffPage2 = new ListStaffPage();
                                        listStaffPage2.setUserService(userService);
                                        listStaffPage2.show();
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        break;
                                }
                        }
                        break;
                    case 2:
                        DepartmentManagePage departmentManagePage = new DepartmentManagePage();
                        departmentManagePage.setApplication(app);
                        int methodDepartment = departmentManagePage.show();

                        if(app.loginedUser.getPermission()==1)
                            //会长
                            switch (methodDepartment){
                                case 1:
                                    ListDepartmentPage listDepartmentPage1 = new ListDepartmentPage();
                                    listDepartmentPage1.setDepartmentService(departmentService);
                                    listDepartmentPage1.showALL();
                                    break;
                                case 2:
                                    ListDepartmentPage listDepartmentPage2 = new ListDepartmentPage();
                                    listDepartmentPage2.setDepartmentService(departmentService);
                                    listDepartmentPage2.show();
                                    break;
                                case 3:
                                    AddDepartmentPage addDepartmentPage = new AddDepartmentPage();
                                    addDepartmentPage.setApplication(app);
                                    addDepartmentPage.setDepartmentService(departmentService);
                                    addDepartmentPage.show();
                                    break;
                                case 4:
                                    DeleteDepartmentPage deleteDepartmentPage = new DeleteDepartmentPage();
                                    deleteDepartmentPage.setApplication(app);
                                    deleteDepartmentPage.setDepartmentService(departmentService);
                                    deleteDepartmentPage.show();
                                    break;
                                case 5:
                                    ModifyDepartmentPage modifyDepartmentPage = new ModifyDepartmentPage();
                                    modifyDepartmentPage.setApplication(app);
                                    modifyDepartmentPage.setDepartmentService(departmentService);
                                    modifyDepartmentPage.show();
                                    break;
                                case 6:
                                    break;
                                default:
                                    break;
                            }
                        else {
                            //其他成员
                            switch (methodDepartment) {
                                case 1:
                                    ListDepartmentPage listDepartmentPage1 = new ListDepartmentPage();
                                    listDepartmentPage1.setDepartmentService(departmentService);
                                    listDepartmentPage1.showALL();
                                    break;
                                case 2:
                                    ListDepartmentPage listDepartmentPage2 = new ListDepartmentPage();
                                    listDepartmentPage2.setDepartmentService(departmentService);
                                    listDepartmentPage2.show();
                                    break;
                                case 3:
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        return;
                    default:
                        break;
                }
            }

        }
    }
}
