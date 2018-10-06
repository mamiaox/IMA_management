package cn.albumenj;
import cn.albumenj.model.*;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.view.Menu;
import cn.albumenj.view.Method;
import cn.albumenj.view.departmentpage.*;
import cn.albumenj.view.menupage.DepartmentManagePage;
import cn.albumenj.view.menupage.LoginPage;
import cn.albumenj.view.menupage.MenuPage;
import cn.albumenj.view.menupage.StaffManagePage;
import cn.albumenj.view.pagemanage.MenuManage;
import cn.albumenj.view.staffpage.*;

/**
 * @author Albumen
 */
public class Application {
    /**
     * 保存已登录用户
     */
    public static UserModel loginedUserModel;

    private Application() {
        //初始化
        loginedUserModel = new UserModel();
    }

    public static void main(String[] args) {
        Application app = new Application();
        UserService userService = new UserService();
        DepartmentService departmentService = new DepartmentService();

        //LoginPage
        Method loginPage = new LoginPage();
        loginPage.setUserService(userService);
        loginPage.show();

        //Login Success
        //MenuPage
        MenuManage menuManage = new MenuManage();
        menuManage.setDepartmentService(departmentService);
        menuManage.setUserService(userService);
        menuManage.show();

    }
}
