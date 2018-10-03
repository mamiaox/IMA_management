package cn.albumenj.util.connectionpool;

import cn.albumenj.model.ResultModel;

import java.sql.ResultSet;

/**
 * @author Albumen
 */
public class ConcurrencySubmit implements Runnable {
    private PooledConnection pooledConnection;
    private ResultModel resultModel;
    private DataCallback dataCallback;

    ConcurrencySubmit(PooledConnection pooledConnection,ResultModel resultModel,DataCallback dataCallback){
        this.resultModel = resultModel;
        this.dataCallback = dataCallback;
        this.pooledConnection = pooledConnection;
    }
    @Override
    public void run() {
        switch (resultModel.getMod()){
            case 1:
                ResultSet rs1 = pooledConnection.query(resultModel.getSql());
                resultModel.setResultSet(rs1);
                break;
            case 2:
                boolean result1 = pooledConnection.execute(resultModel.getSql());
                resultModel.setResult(result1);
                break;
            default:
                break;
        }
        dataCallback.fetchFinished(resultModel);
        pooledConnection.close();
    }
}
