package cn.albumenj.util.ConnectionPool;

import cn.albumenj.model.ResultModel;

import java.util.Vector;

public class PoolSubmit implements DataCallback {
    private static MyPoolImpl pool = new MyPoolImpl();
    private static Vector<ResultModel> resultModels = new Vector<>();

    public ResultModel execute(ResultModel resultModel){
        resultModel.setSeed(Math.random());
        Thread thread = new Thread(new ConcurrencySubmit(pool.getPooledConnection(),resultModel,new PoolSubmit()));
        thread.run();
        return resultModel;
    }

    public ResultModel fetch(double seed){
        for(ResultModel resultModel:resultModels){
            if(resultModel.getSeed()==seed){
                resultModels.remove(resultModel);
                return resultModel;
            }
        }
        return null;
    }

    @Override
    public void fetchFinished(ResultModel resultModel) {
        resultModels.add(resultModel);
    }
}
