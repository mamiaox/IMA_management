package cn.albumenj.util.connectionpool;
/**
 * @author Albumen
 */
public interface IMyPool {
    /**
     * getPooledConnection
     * @return 返回可用连接
     */
    PooledConnection getPooledConnection();

    /**
     * createPooledConnection
     * @param count 初始线程池大小
     * 创建连接池
     */
    void createPooledConnection(int count);
}
