package cn.albumenj.view.staffpage;

import cn.albumenj.model.DepartmentModel;
import cn.albumenj.model.UserModel;
import cn.albumenj.util.*;
import cn.albumenj.util.commandlineutil.RequestEnter;
import cn.albumenj.view.Method;

import java.util.List;

/**
 * @author Albumen
 */
public class ModifyStaffPage extends Method {
    @Override
    public void page(){
        System.out.print("请输入要查询人员学号：");
        UserModel userModel = userService.fetchUserByID(RequestEnter.requestInt());

        System.out.println("   学号     姓名     电话     QQ    权限");
        System.out.println(userModel.getID() + " " +
                userModel.getName() + " " + userModel.getPhone() + " " +
                userModel.getQq()+ " " + userModel.getPermission());
        System.out.println();

        if(RequestEnter.requestContinueDo()) {
            System.out.print("请输入修改后人员的学号：");
            userModel.setID(RequestEnter.requestInt());

            System.out.print("请输入修改后人员的姓名：");
            userModel.setName(RequestEnter.requestString());

            System.out.print("请输入增加人员的密码：");
            userModel.setPassword(PasswordDecode.EncoderByMd5(RequestEnter.requestString()));

            System.out.print("请输入修改后人员的电话号码：");
            userModel.setPhone(RequestEnter.requestString());

            do {
                System.out.print("请输入修改后人员的QQ：");
                userModel.setQq(RequestEnter.requestString());
            } while (!Regex.number(userModel.getQq()));

            List<DepartmentModel> departmentModels = departmentService.fetchAllDepartment();
            System.out.println("部门编号如下");
            System.out.println("   编号     名字 ");

            for (DepartmentModel departmentModel : departmentModels) {
                System.out.println(departmentModel.getID() + " " + departmentModel.getName());
            }

            System.out.print("请输入修改后人员的部门：");
            userModel.setDepartment(RequestEnter.requestInt());

            System.out.println("权限编号如下如下");
            System.out.println("1   会长");
            System.out.println("2   部长");
            System.out.println("3   普通成员");

            System.out.print("请输入修改后人员的权限：");
            userModel.setPermission(RequestEnter.requestInt());

            boolean ret = userService.modify(userModel);
            resultOutput(ret,cn.albumenj.view.Method.method.MODIFY);
        }
    }
}
