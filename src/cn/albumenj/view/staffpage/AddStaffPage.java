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
public class AddStaffPage extends Method {
    @Override
    public void page() {
        UserModel addUserModel = new UserModel();
        System.out.print("请输入增加人员的学号：");
        addUserModel.setID(RequestEnter.requestInt());

        System.out.print("请输入增加人员的密码：");
        addUserModel.setPassword(PasswordDecode.EncoderByMd5(RequestEnter.requestString()));

        System.out.print("请输入增加人员的姓名：");
        addUserModel.setName(RequestEnter.requestString());

        System.out.print("请输入增加人员的电话号码：");
        addUserModel.setPhone(RequestEnter.requestString());

        do {
            System.out.print("请输入增加人员的QQ：");
            addUserModel.setQq(RequestEnter.requestString());
        } while (!Regex.number(addUserModel.getQq()));

        List<DepartmentModel> departmentModels = departmentService.fetchAllDepartment();
        System.out.println("部门编号如下");
        System.out.println("   编号     名字 ");

        for (DepartmentModel departmentModel : departmentModels) {
            System.out.println(departmentModel.getID() + " " + departmentModel.getName());
        }

        System.out.print("请输入增加人员的部门：");
        addUserModel.setDepartment(RequestEnter.requestInt());

        System.out.println("权限编号如下如下");
        System.out.println("1   会长");
        System.out.println("2   部长");
        System.out.println("3   普通成员");

        System.out.print("请输入增加人员的权限：");
        addUserModel.setPermission(RequestEnter.requestInt());

        System.out.println("正在添加请等待！");

        boolean ret = userService.add(addUserModel);
        resultOutput(ret, method.ADD);
    }
}
