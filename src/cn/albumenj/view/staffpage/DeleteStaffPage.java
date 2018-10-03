package cn.albumenj.view.staffpage;

import cn.albumenj.model.UserModel;
import cn.albumenj.service.UserService;
import cn.albumenj.util.commandlineutil.FlushPage;
import cn.albumenj.util.commandlineutil.PrintLine;
import cn.albumenj.util.commandlineutil.RequestEnter;

/**
 * @author Albumen
 */
public class DeleteStaffPage {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void show(){
        FlushPage.flush();
        PrintLine.print();

        System.out.print("请输入要删除人员学号：");
        UserModel deleteUserModel = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(deleteUserModel.getID() + " " +
                deleteUserModel.getName() + " " + deleteUserModel.getPhone() + " " +
                deleteUserModel.getQq()+ " " + deleteUserModel.getPermission());
        System.out.println();

        System.out.print("是否删除（是 1 /否 2）：");
        switch (RequestEnter.requestInt()){
            case 1:
                boolean ret = userService.delete(deleteUserModel);
                if(ret) {
                    System.out.println("删除成功！");
                }
                else {
                    System.out.println("删除失败！");
                }
                break;
            case 2:
                break;
            default:
                break;
        }
        PrintLine.print();
    }
}
