package cn.albumenj.view;

import cn.albumenj.Application;
import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;
import cn.albumenj.util.commandlineutil.Print;

/**
 * @author Albumen
 */
public abstract class Method {
    protected UserService userService;
    protected DepartmentService departmentService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void show(){
        Print.flush();
        Print.printLine();

        page();

        Print.printLine();
    }

    abstract public void page();
}
