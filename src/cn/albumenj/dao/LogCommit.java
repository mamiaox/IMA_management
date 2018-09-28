package cn.albumenj.dao;

import cn.albumenj.dao.ConnectionPool.PoolSubmit;
import cn.albumenj.model.LogModel;
import cn.albumenj.model.ResultModel;

import java.util.Date;

public class LogCommit {
    public static void submit(LogModel logModel){
        //INSERT INTO `ima_management`.`log`(`user`, `action`, `time`) VALUES ('1', '1', '1')
        String user = logModel.getUser().getID() + " "
                + logModel.getUser().getNo() + " "
                + logModel.getUser().getName();
        String sql = "INSERT INTO `ima_management`.`log`(`user`, `action`, `time" +
                "`) VALUES ('" + user + "', '" +logModel.getAction() + "', '" +logModel.getTime() + "')";

        ResultModel resultModel = new ResultModel();
        resultModel.setMod(2);
        resultModel.setSql(sql);
        new PoolSubmit().execute(resultModel);

    }
}
