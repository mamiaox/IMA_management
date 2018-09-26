package cn.albumenj;
import cn.albumenj.model.*;
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

        //Login Page
        Application app = new Application();
        LoginPage loginPage = new LoginPage();
        loginPage.setApplication(app);
        while(loginPage.show()==true){
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
                                    new ListStaffPage().showALL();
                                    break;
                                case 2:
                                    new ListStaffPage().show();
                                    break;
                                case 3:
                                    AddStaffPage addStaffPage = new AddStaffPage();
                                    addStaffPage.setApplication(app);
                                    addStaffPage.show();
                                    break;
                                case 4:
                                    DeleteStaffPage deleteStaffPage = new DeleteStaffPage();
                                    deleteStaffPage.setApplication(app);
                                    deleteStaffPage.show();
                                    break;
                                case 5:
                                    ModifyStaffPage modifyStaffPage = new ModifyStaffPage();
                                    modifyStaffPage.setApplication(app);
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
                                        new ListStaffPage().showALL();
                                        break;
                                    case 2:
                                        new ListStaffPage().show();
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
                                    new ListDepartmentPage().showALL();
                                    break;
                                case 2:
                                    new ListDepartmentPage().show();
                                    break;
                                case 3:
                                    AddDepartmentPage addDepartmentPage = new AddDepartmentPage();
                                    addDepartmentPage.setApplication(app);
                                    addDepartmentPage.show();
                                    break;
                                case 4:
                                    DeleteDepartmentPage deleteDepartmentPage = new DeleteDepartmentPage();
                                    deleteDepartmentPage.setApplication(app);
                                    deleteDepartmentPage.show();
                                    break;
                                case 5:
                                    ModifyDepartmentPage modifyDepartmentPage = new ModifyDepartmentPage();
                                    modifyDepartmentPage.setApplication(app);
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
                                    new ListDepartmentPage().showALL();
                                    break;
                                case 2:
                                    new ListDepartmentPage().show();
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
