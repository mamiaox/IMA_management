package cn.albumenj.view.MenuPage;

import cn.albumenj.Application;
import cn.albumenj.util.CommandLineUtil.FlushPage;
import cn.albumenj.util.CommandLineUtil.PrintLine;
import cn.albumenj.util.CommandLineUtil.RequestEnter;

public class MenuPage {
    private Application application;

    public void setApplication(Application application) {
        this.application = application;
    }

    public int show(){
        FlushPage.flush();
        PrintLine.print();
        System.out.println("尊敬的"+application.loginedUserModel.getName()+"，您好：");

        for (int i = 0;i<10;i++)
            System.out.print(" ");
        System.out.println("1、人员管理");

        for (int i = 0;i<10;i++)
            System.out.print(" ");
        System.out.println("2、部门管理");

        for (int i = 0;i<10;i++)
            System.out.print(" ");
        System.out.println("3、退出");

        System.out.print("请输出您要进入的功能（数字）：");
        int method = RequestEnter.requestInt();

        PrintLine.print();
        return method;
    }
}
