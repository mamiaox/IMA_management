package cn.albumenj.dao.ConnectionPool;

public interface IMyPool {
    public PooledConnection getPooledConnection();
    public void createPooledConnection(int count);
}
