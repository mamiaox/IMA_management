package cn.albumenj.util.ConnectionPool;


import cn.albumenj.model.ResultModel;

public interface DataCallback {
    void fetchFinished(ResultModel resultModel);
}
