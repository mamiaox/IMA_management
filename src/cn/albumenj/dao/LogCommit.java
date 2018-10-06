package cn.albumenj.dao;

import cn.albumenj.util.connectionpool.PoolSubmit;
import cn.albumenj.model.LogModel;
import cn.albumenj.model.ResultModel;

/**
 * @author Albumen
 */
public class LogCommit {
    public static void submit(LogModel logModel) {
        String user = logModel.getUserModel().getID() + " "
                + logModel.getUserModel().getNo() + " "
                + logModel.getUserModel().getName();
        String sql = "INSERT INTO `ima_management`.`log`(`user`, `action`, `time" +
                "`) VALUES ('" + user + "', '" + logModel.getAction() + "', '" + logModel.getTime() + "')";

        ResultModel resultModel = new ResultModel();
        resultModel.setMod(2);
        resultModel.setSql(sql);
        new PoolSubmit().execute(resultModel);
    }
}
