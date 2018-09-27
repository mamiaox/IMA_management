package cn.albumenj.view.MenuPage;
import cn.albumenj.model.user;
import cn.albumenj.service.UserService;
import cn.albumenj.util.*;
import cn.albumenj.*;

public class LoginPage {
    private Application application;
    private UserService userService;

    public void setApplication(Application application){
        this.application = application;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean show(){
        flushPage.flush();
        printLine.print();

        user loginUser = new user();

        System.out.print("请输入学号：");
        loginUser.setID(requestEnter.requestInt());

        System.out.print("请输入密码：");
        loginUser.setPassword(passwordDecode.EncoderByMd5(requestEnter.requestString()));

        System.out.println();
        System.out.println("正在尝试登陆，请稍等！");

        if((loginUser = userService.check(loginUser)) != null){
            System.out.println("登陆成功！");
            printLine.print();
            application.loginedUser = loginUser;
            return true;
        }
        else{
            System.out.println("登陆失败！");
            printLine.print();
            return false;
        }
    }
}
