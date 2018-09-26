package cn.albumenj.service.Department;

import cn.albumenj.model.department;
import cn.albumenj.model.user;

import java.util.LinkedList;
import java.util.List;

public class fetchDepartment {
    public List<department> fetchAllDepartment(){
        List<department> departments = new LinkedList<>();
        return  departments;
    }

    public department fetchDepartmentByID(int ID){
        department department = new department();
        return department;
    }
}
