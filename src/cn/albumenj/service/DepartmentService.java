package cn.albumenj.service;

import cn.albumenj.dao.SqlCommit;
import cn.albumenj.model.DepartmentModel;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Albumen
 */
public class DepartmentService {
    private static List<DepartmentModel> departmentModelData;

    public void add(DepartmentModel addDepartmentModel){
         boolean ret = SqlCommit.insert("department",departmentToData(addDepartmentModel));
        if (ret) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    public void delete(DepartmentModel deleteDepartmentModel){
        boolean ret = SqlCommit.delete("department", deleteDepartmentModel.getNo());
        if (ret) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    public List<DepartmentModel> fetchAllDepartment(){
        flashDepartmentData();
        return departmentModelData;
    }

    public DepartmentModel fetchDepartmentByID(int ID){
        flashDepartmentData();
        for(DepartmentModel DepartmentModel : departmentModelData) {
            if (DepartmentModel.getID() == ID) {
                return DepartmentModel;
            }
        }
        return new DepartmentModel();
    }

    public void modify(DepartmentModel modifyDepartmentModel){
        boolean ret = SqlCommit.update("department", modifyDepartmentModel.getNo(),departmentToData(modifyDepartmentModel));
        if (ret) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    private DepartmentModel dataToDepartment(Map<String,String> data){
        DepartmentModel DepartmentModel = new DepartmentModel();
        DepartmentModel.setID(Integer.parseInt(data.get("id")));
        DepartmentModel.setName(data.get("name"));
        DepartmentModel.setNo(Integer.parseInt(data.get("no")));
        return DepartmentModel;
    }

    private List<DepartmentModel> dataListToDepartment(List<Map<String,String>> dataList){
        List<DepartmentModel> departmentModelList = new LinkedList<>();
        for(Map<String,String> data:dataList) {
            departmentModelList.add(dataToDepartment(data));
        }
        return departmentModelList;
    }

    private void flashDepartmentData(){
        departmentModelData = dataListToDepartment(SqlCommit.select("department"));
    }

    private Map<String,String> departmentToData(DepartmentModel DepartmentModel){
        Map<String,String> data = new LinkedHashMap<>();
        data.put("id", DepartmentModel.getID()+"");
        data.put("name", DepartmentModel.getName());
        return data;
    }
}
