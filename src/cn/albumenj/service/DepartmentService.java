package cn.albumenj.service;

import cn.albumenj.dao.SqlCommit;
import cn.albumenj.model.department;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DepartmentService {
    private static List<department> departmentData;

    public boolean add(department addDepartment){
        return SqlCommit.insert("department",departmentToData(addDepartment));
    }

    public boolean delete(department deleteDepartment){
        return SqlCommit.delete("department",deleteDepartment.getNo());
    }

    public List<department> fetchAllDepartment(){
        flashDepartmentData();
        return  departmentData;
    }

    public department fetchDepartmentByID(int ID){
        flashDepartmentData();
        for(department department:departmentData) {
            if (department.getID() == ID)
                return department;
        }
        return new department();
    }

    public boolean modify(department modifyDepartment){
        return SqlCommit.update("department",modifyDepartment.getNo(),departmentToData(modifyDepartment));
    }

    private department dataToDepartment(Map<String,String> data){
        department department = new department();
        department.setID(Integer.parseInt(data.get("id")));
        department.setName(data.get("name"));
        department.setNo(Integer.parseInt(data.get("no")));
        return department;
    }

    private List<department> dataListToDepartment(List<Map<String,String>> dataList){
        List<department> departmentList = new LinkedList<>();
        for(Map<String,String> data:dataList)
            departmentList.add(dataToDepartment(data));
        return departmentList;
    }

    private void flashDepartmentData(){
        departmentData = dataListToDepartment(SqlCommit.select("department"));
    }

    private Map<String,String> departmentToData(department department){
        Map<String,String> data = new LinkedHashMap<>();
        data.put("id",department.getID()+"");
        data.put("name",department.getName());
        return data;
    }
}
