package cn.albumenj.util.ConnectionPool;

public interface IMyPool {
    public PooledConnection getPooledConnection();
    public void createPooledConnection(int count);
}
