package cn.albumenj.util.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author Albumen
 */
public class MyPoolImpl implements IMyPool {
    private Vector<PooledConnection> pooledConnections = new Vector<>();

    public MyPoolImpl() {
        createPooledConnection(ConnectionConfig.initCount);
    }

    static {
        try {
            Class.forName(ConnectionConfig.DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PooledConnection getPooledConnection() {

        if(pooledConnections.size() == 0){
            throw new RuntimeException("连接池初始化失误！");
        }
        PooledConnection pooledConnection = null;
        try{
            pooledConnection = getRealConnectionFromPool();

            while(pooledConnection == null){
                createPooledConnection(ConnectionConfig.step);
                pooledConnection = getRealConnectionFromPool();
            }
            return pooledConnection;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pooledConnection;
    }

    @Override
    public void createPooledConnection(int count) {
        if(pooledConnections.size()+count>ConnectionConfig.maxThread){
            throw new RuntimeException("连接池已满！");
        }
        for(int i = 0;i<count;i++){
            try{
                Connection connection = DriverManager.getConnection(ConnectionConfig.URL,
                        ConnectionConfig.USER,ConnectionConfig.PASSWORD);
                PooledConnection pooledConnection = new PooledConnection(connection,false);
                pooledConnections.add(pooledConnection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private synchronized PooledConnection getRealConnectionFromPool() throws SQLException{
        for(PooledConnection pooledConnection:pooledConnections){
            if(!pooledConnection.isBusy()){
                if(pooledConnection.getConnection().isValid(3000)){
                    pooledConnection.setBusy(true);
                    return pooledConnection;
                }else{
                    Connection connection = DriverManager.getConnection(ConnectionConfig.URL,
                            ConnectionConfig.USER,ConnectionConfig.PASSWORD);
                    pooledConnection.setConnection(connection);
                    pooledConnection.setBusy(true);
                    return pooledConnection;
                }
            }
        }
        return null;
    }
}
