package cn.albumenj.view;

import cn.albumenj.service.DepartmentService;
import cn.albumenj.service.UserService;

/**
 * @author Albumen
 */
public abstract class Manage {
    protected UserService userService;
    protected DepartmentService departmentService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    abstract public void show();
}
