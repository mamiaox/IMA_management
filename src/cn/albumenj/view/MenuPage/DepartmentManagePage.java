package cn.albumenj.view.MenuPage;

import cn.albumenj.Application;
import cn.albumenj.util.flushPage;
import cn.albumenj.util.printLine;
import cn.albumenj.util.requestEnter;

public class DepartmentManagePage {
    private Application application;

    public void setApplication(Application application) {
        this.application = application;
    }

    public int show(){
        flushPage.flush();
        printLine.print();
        System.out.println("尊敬的"+application.loginedUser.getName()+"，您好：");

        for (int i = 0;i<10;i++)
            System.out.print(" ");
        System.out.println("1、列出所有部门");

        for (int i = 0;i<10;i++)
            System.out.print(" ");
        System.out.println("2、查询指定部门");

        if(application.loginedUser.getPermission()==1
                ||application.loginedUser.getPermission()==2){
            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("3、增加部门");

            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("4、删除部门");

            for (int i = 0;i<10;i++)
                System.out.print(" ");
            System.out.println("5、修改部门信息");

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
        int method = requestEnter.requestInt();

        printLine.print();
        return method;
    }
}
