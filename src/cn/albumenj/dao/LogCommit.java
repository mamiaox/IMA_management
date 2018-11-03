package cn.albumenj.dao;

import cn.albumenj.model.SqlModel;
import cn.albumenj.util.connectionpool.PoolSubmit;
import cn.albumenj.model.LogModel;
import cn.albumenj.model.ResultModel;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Albumen
 */
public class LogCommit {
    public static void submit(LogModel logModel) {
        String user = logModel.getUserModel().getID() + " "
                + logModel.getUserModel().getNo() + " "
                + logModel.getUserModel().getName();
        String sql = "INSERT INTO `ima_management`.`log`(`user`, `action`, `time" +
                "`) VALUES ( ?, ?, ?)";

        Map<Integer,String> prepareCondition = new LinkedHashMap<>();
        prepareCondition.put(1,user);
        prepareCondition.put(2,logModel.getAction());
        prepareCondition.put(3,logModel.getTime());

        ResultModel resultModel = new ResultModel();
        resultModel.setMod(2);
        SqlModel sqlModel = new SqlModel();
        sqlModel.setSql(sql);
        sqlModel.setCondition(prepareCondition);
        resultModel.setSql(sqlModel);
        new PoolSubmit().execute(resultModel);
    }
}
