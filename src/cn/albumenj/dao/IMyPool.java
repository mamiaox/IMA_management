package cn.albumenj.dao;

public interface IMyPool {
    public PooledConnection getPooledConnection();
    public void createPooledConnection(int count);
}
