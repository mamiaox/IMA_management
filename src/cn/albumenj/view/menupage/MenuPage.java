package cn.albumenj.view.menupage;

import cn.albumenj.util.commandlineutil.Print;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Menu;
import cn.albumenj.view.Method;

/**
 * @author Albumen
 */
public class MenuPage extends Menu {
    @Override
    public int page(){
        Print.printWelcome(cn.albumenj.Application.loginedUserModel.getName());

        Print.printChoice("1、人员管理");
        Print.printChoice("2、部门管理");
        Print.printChoice("3、退出");

        System.out.print("请输出您要进入的功能（数字）：");
        return RequestEnter.requestInt();
    }
}
