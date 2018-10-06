package cn.albumenj.view.menupage;

import cn.albumenj.util.commandlineutil.Print;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Menu;

/**
 * @author Albumen
 */
public class DepartmentManagePage extends Menu {
    @Override
    public int page(){
        Print.printWelcome(cn.albumenj.Application.loginedUserModel.getName());

        Print.printChoice("1、列出所有部门");
        Print.printChoice("2、查询指定部门");

        if(cn.albumenj.Application.loginedUserModel.isAdmin()){
            Print.printChoice("3、增加部门");
            Print.printChoice("4、删除部门");
            Print.printChoice("5、修改部门信息");
            Print.printChoice("6、返回");
        }
        else{
            Print.printChoice("3、返回");
        }

        System.out.print("请输出您要进入的功能（数字）：");
        return RequestEnter.requestInt();
    }
}
