package cn.albumenj.view.MenuPage;

import cn.albumenj.Application;
import cn.albumenj.util.CommandLineUtil.FlushPage;
import cn.albumenj.util.CommandLineUtil.PrintLine;
import cn.albumenj.util.CommandLineUtil.RequestEnter;

public class StaffManagePage {
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
        System.out.println("1、列出所有人员");

        for (int i = 0;i<10;i++)
            System.out.print(" ");
        System.out.println("2、查询指定人员");

        if(application.loginedUserModel.getPermission()==1
                ||application.loginedUserModel.getPermission()==2){
            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("3、增加人员");

            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("4、删除人员");

            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("5、修改人员信息");

            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("6、返回");
        }
        else{
            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("3、返回");
        }

        System.out.print("请输出您要进入的功能（数字）：");
        int method = RequestEnter.requestInt();

        PrintLine.print();
        return method;
    }
}
