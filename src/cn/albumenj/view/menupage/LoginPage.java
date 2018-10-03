package cn.albumenj.view.menupage;
import cn.albumenj.model.UserModel;
import cn.albumenj.service.UserService;
import cn.albumenj.util.*;
import cn.albumenj.*;
import cn.albumenj.util.commandlineutil.FlushPage;
import cn.albumenj.util.commandlineutil.PrintLine;
import cn.albumenj.util.commandlineutil.RequestEnter;

/**
 * @author Albumen
 */
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

        UserModel loginUserModel = new UserModel();

        System.out.print("请输入学号：");
        loginUserModel.setID(RequestEnter.requestInt());

        System.out.print("请输入密码：");
        loginUserModel.setPassword(PasswordDecode.EncoderByMd5(RequestEnter.requestString()));

        System.out.println();
        System.out.println("正在尝试登陆，请稍等！");

        if((loginUserModel = userService.check(loginUserModel)) != null){
            System.out.println("登陆成功！");
            PrintLine.print();
            cn.albumenj.Application.loginedUserModel = loginUserModel;
            return true;
        }
        else{
            System.out.println("登陆失败！");
            PrintLine.print();
            return false;
        }
    }
}
