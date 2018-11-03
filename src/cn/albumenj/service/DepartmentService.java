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

    public boolean add(DepartmentModel addDepartmentModel){
        return SqlCommit.insert("department",departmentToData(addDepartmentModel));
    }

    public boolean delete(DepartmentModel deleteDepartmentModel){
        return SqlCommit.delete("department", deleteDepartmentModel.getNo());
    }

    public List<DepartmentModel> fetchAllDepartment(){
        Map<String,String> condition = new LinkedHashMap<>();
        return selectDepartmentData(condition);
    }

    public DepartmentModel fetchDepartmentByID(int ID){
        Map<String,String> condition = new LinkedHashMap<>();
        condition.put("id",""+ID);
        List<DepartmentModel> result = selectDepartmentData(condition);
        for(DepartmentModel DepartmentModel : result) {
            if (DepartmentModel.getID() == ID) {
                return DepartmentModel;
            }
        }
        return new DepartmentModel();
    }

    public boolean modify(DepartmentModel modifyDepartmentModel){
        return SqlCommit.update("department", modifyDepartmentModel.getNo(),departmentToData(modifyDepartmentModel));
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

    private List<DepartmentModel> selectDepartmentData(Map<String,String> condition){
        return dataListToDepartment(SqlCommit.selectWhere("department",condition));
    }

    private Map<String,String> departmentToData(DepartmentModel DepartmentModel){
        Map<String,String> data = new LinkedHashMap<>();
        data.put("id", DepartmentModel.getID()+"");
        data.put("name", DepartmentModel.getName());
        return data;
    }
}
