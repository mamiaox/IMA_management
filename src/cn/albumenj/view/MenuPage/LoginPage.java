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
        FlushPage.flush();
        PrintLine.print();

        user loginUser = new user();

        System.out.print("请输入学号：");
        loginUser.setID(RequestEnter.requestInt());

        System.out.print("请输入密码：");
        loginUser.setPassword(PasswordDecode.EncoderByMd5(RequestEnter.requestString()));

        System.out.println();
        System.out.println("正在尝试登陆，请稍等！");

        if((loginUser = userService.check(loginUser)) != null){
            System.out.println("登陆成功！");
            PrintLine.print();
            application.loginedUser = loginUser;
            return true;
        }
        else{
            System.out.println("登陆失败！");
            PrintLine.print();
            return false;
        }
    }
}
