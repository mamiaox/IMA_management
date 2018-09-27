package cn.albumenj.dao;

import java.sql.ResultSet;

public class ConcurrencySubmit implements Runnable {
    private MyPoolImpl pool;
    private PoolSubmit poolSubmit;
    private int mod;
    private String sql;

    ConcurrencySubmit(MyPoolImpl pool,PoolSubmit poolSubmit,int mod,String sql){
        this.mod=mod;
        this.pool=pool;
        this.poolSubmit=poolSubmit;
        this.sql = sql;
    }
    @Override
    public void run() {
        PooledConnection pooledConnection = pool.getPooledConnection();
        switch (mod){
            case 1:
                ResultSet rs1 = pooledConnection.query(sql);
                poolSubmit.rs = rs1;
                break;
            case 2:
                boolean result1 = pooledConnection.execute(sql);
                poolSubmit.result = result1;
                break;
        }
        pooledConnection.close();
    }
}
