package cn.albumenj.dao;

import java.sql.ResultSet;

public class PoolSubmit{
    private static MyPoolImpl pool = new MyPoolImpl();
    public String sql;
    public ResultSet rs = null;
    public boolean result = false;

    PoolSubmit(String sql){
        this.sql = sql;
    }

    public ResultSet query(){
        Thread thread = new Thread(new ConcurrencySubmit(pool,this,1,sql));
        thread.start();
        try {
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public boolean execute(){
        Thread thread = new Thread(new ConcurrencySubmit(pool,this,2,sql));
        thread.start();
        try {
            thread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
