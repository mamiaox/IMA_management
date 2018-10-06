package cn.albumenj.view.menupage;
import cn.albumenj.model.UserModel;
import cn.albumenj.util.*;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class LoginPage extends Method {
    @Override
    public void page(){
        UserModel loginUserModel = new UserModel();

        System.out.print("请输入学号：");
        loginUserModel.setID(RequestEnter.requestInt());

        System.out.print("请输入密码：");
        loginUserModel.setPassword(PasswordDecode.EncoderByMd5(RequestEnter.requestString()));

        System.out.println();
        System.out.println("正在尝试登陆，请稍等！");

        if((loginUserModel = userService.check(loginUserModel)) != null) {
            System.out.println("登陆成功！");
            cn.albumenj.Application.loginedUserModel = loginUserModel;
        }
        else{
            System.out.println("登陆失败！");
            System.out.println();
            page();
        }
    }
}
