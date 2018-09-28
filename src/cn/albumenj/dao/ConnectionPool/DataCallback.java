package cn.albumenj.dao.ConnectionPool;


import cn.albumenj.model.ResultModel;

public interface DataCallback {
    void fetchFinished(ResultModel resultModel);
}
