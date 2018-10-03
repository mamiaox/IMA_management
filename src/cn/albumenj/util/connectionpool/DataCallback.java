package cn.albumenj.util.connectionpool;

import cn.albumenj.model.ResultModel;

/**
 * @author Albumen
 */
public interface DataCallback {
    void fetchFinished(ResultModel resultModel);
}
