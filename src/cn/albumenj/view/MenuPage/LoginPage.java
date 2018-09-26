package cn.albumenj.view.MenuPage;
import cn.albumenj.model.user;
import cn.albumenj.service.User.checkUser;
import cn.albumenj.util.*;
import cn.albumenj.*;

public class LoginPage {
    private Application application;

    public void setApplication(Application application){
        this.application = application;
    }

    public boolean show(){
        flushPage.flush();
        printLine.print();

        user loginUser = new user();

        System.out.print("请输入学号：");
        loginUser.setID(requestEnter.requestInt());

        System.out.print("请输入密码：");
        loginUser.setPassword(requestEnter.requestString());

        System.out.println();
        System.out.println("正在尝试登陆，请稍等！");

        if(new checkUser().check(loginUser)==true){
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