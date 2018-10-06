package cn.albumenj.util.connectionpool;

public interface IMyPool {
    PooledConnection getPooledConnection();
    void createPooledConnection(int count);
}
