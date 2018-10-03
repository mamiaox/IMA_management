package cn.albumenj;
import cn.albumenj.model.*;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.view.departmentpage.AddDepartmentPage;
import cn.albumenj.view.departmentpage.DeleteDepartmentPage;
import cn.albumenj.view.departmentpage.ListDepartmentPage;
import cn.albumenj.view.departmentpage.ModifyDepartmentPage;
import cn.albumenj.view.menupage.DepartmentManagePage;
import cn.albumenj.view.menupage.LoginPage;
import cn.albumenj.view.menupage.MenuPage;
import cn.albumenj.view.menupage.StaffManagePage;
import cn.albumenj.view.staffpage.*;

/**
 * @author Albumen
 */
public class Application {
    /**
     * 保存已登录用户
     */
    public static UserModel loginedUserModel;

    private Application(){
        //初始化
        loginedUserModel = new UserModel();
    }

    public static void main(String[] args) {
        Application app = new Application();
        UserService userService = new UserService();
        DepartmentService departmentService = new DepartmentService();

        //LoginPage
        LoginPage loginPage = new LoginPage();
        loginPage.setApplication(app);
        loginPage.setUserService(userService);
        if(loginPage.show()){
            //Login Success
            while(true) {
                //menupage
                MenuPage menuPage = new MenuPage();
                menuPage.setApplication(app);
                //获取进入选项
                int method = menuPage.show();
                switch (method) {
                    case 1:
                        //人员管理
                        StaffManagePage staffManagePage = new StaffManagePage();
                        staffManagePage.setApplication(app);
                        int methodStaff = staffManagePage.show();
                        if(cn.albumenj.Application.loginedUserModel.getPermission()==1
                            ||cn.albumenj.Application.loginedUserModel.getPermission()==2) {
                            //会长及部长权限
                            switch (methodStaff) {
                                case 1:
                                    //列出所有人员
                                    ListStaffPage listStaffPage1 = new ListStaffPage();
                                    listStaffPage1.setUserService(userService);
                                    listStaffPage1.showALL();
                                    break;
                                case 2:
                                    //查询指定人员
                                    ListStaffPage listStaffPage2 = new ListStaffPage();
                                    listStaffPage2.setUserService(userService);
                                    listStaffPage2.show();
                                    break;
                                case 3:
                                    //增加人员
                                    AddStaffPage addStaffPage = new AddStaffPage();
                                    addStaffPage.setUserService(userService);
                                    addStaffPage.setDepartmentService(departmentService);
                                    addStaffPage.show();
                                    break;
                                case 4:
                                    //删除人员
                                    DeleteStaffPage deleteStaffPage = new DeleteStaffPage();
                                    deleteStaffPage.setUserService(userService);
                                    deleteStaffPage.show();
                                    break;
                                case 5:
                                    //修改人员信息
                                    ModifyStaffPage modifyStaffPage = new ModifyStaffPage();
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
                        }
                            else{
                                //普通成员权限
                                switch (methodStaff){
                                    case 1:
                                        //列出所有人员
                                        ListStaffPage listStaffPage1 = new ListStaffPage();
                                        listStaffPage1.setUserService(userService);
                                        listStaffPage1.showALL();
                                        break;
                                    case 2:
                                        //查询所有人员
                                        ListStaffPage listStaffPage2 = new ListStaffPage();
                                        listStaffPage2.setUserService(userService);
                                        listStaffPage2.show();
                                        break;
                                    case 3:
                                        //返回
                                        break;
                                    default:
                                        break;
                                }
                        }
                        break;
                    case 2:
                        //部门管理
                        DepartmentManagePage departmentManagePage = new DepartmentManagePage();
                        departmentManagePage.setApplication(app);
                        int methodDepartment = departmentManagePage.show();

                        if(cn.albumenj.Application.loginedUserModel.getPermission()==1) {
                            //会长权限
                            switch (methodDepartment) {
                                case 1:
                                    //列出所有部门
                                    ListDepartmentPage listDepartmentPage1 = new ListDepartmentPage();
                                    listDepartmentPage1.setDepartmentService(departmentService);
                                    listDepartmentPage1.showALL();
                                    break;
                                case 2:
                                    //查询指定部门
                                    ListDepartmentPage listDepartmentPage2 = new ListDepartmentPage();
                                    listDepartmentPage2.setDepartmentService(departmentService);
                                    listDepartmentPage2.show();
                                    break;
                                case 3:
                                    //增加部门
                                    AddDepartmentPage addDepartmentPage = new AddDepartmentPage();
                                    addDepartmentPage.setDepartmentService(departmentService);
                                    addDepartmentPage.show();
                                    break;
                                case 4:
                                    //删除部门
                                    DeleteDepartmentPage deleteDepartmentPage = new DeleteDepartmentPage();
                                    deleteDepartmentPage.setDepartmentService(departmentService);
                                    deleteDepartmentPage.show();
                                    break;
                                case 5:
                                    //修改部门信息
                                    ModifyDepartmentPage modifyDepartmentPage = new ModifyDepartmentPage();
                                    modifyDepartmentPage.setDepartmentService(departmentService);
                                    modifyDepartmentPage.show();
                                    break;
                                case 6:
                                    //返回
                                    break;
                                default:
                                    break;
                            }
                        }
                        else {
                            //其他成员权限
                            switch (methodDepartment) {
                                case 1:
                                    //列出所有部门
                                    ListDepartmentPage listDepartmentPage1 = new ListDepartmentPage();
                                    listDepartmentPage1.setDepartmentService(departmentService);
                                    listDepartmentPage1.showALL();
                                    break;
                                case 2:
                                    //查询指定部门
                                    ListDepartmentPage listDepartmentPage2 = new ListDepartmentPage();
                                    listDepartmentPage2.setDepartmentService(departmentService);
                                    listDepartmentPage2.show();
                                    break;
                                case 3:
                                    //返回
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        //退出
                        return;
                    default:
                        break;
                }
            }
        }
    }
}
