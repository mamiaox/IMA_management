package cn.albumenj.util.connectionpool;

/**
 * @author Albumen
 */
public interface IMyPool {
    PooledConnection getPooledConnection();
    void createPooledConnection(int count);
}
