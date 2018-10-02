package cn.albumenj.util.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class MyPoolImpl implements IMyPool {
    private Vector<PooledConnection> pooledConnections = new Vector<>();
    private static String URL;
            private static String USER;
            private static String PASSWORD;
            private static String DRIVER;
            private static int initCount;
            private static int step;
            private static int maxThread;

    public MyPoolImpl(){
                createPooledConnection(initCount);
            }

            static {
                init();
                try {
                    Class.forName(DRIVER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void init(){
        URL = ConnectionConfig.URL;
        USER = ConnectionConfig.USER;
        PASSWORD = ConnectionConfig.PASSWORD;
        DRIVER = ConnectionConfig.DRIVER;
        initCount = ConnectionConfig.initCount;
        step = ConnectionConfig.step;
        maxThread = ConnectionConfig.maxThread;
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
                createPooledConnection(step);
                pooledConnection = getRealConnectionFromPool();
                return pooledConnection;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pooledConnection;
    }

    @Override
    public void createPooledConnection(int count) {
        if(pooledConnections.size()+count>maxThread){
            throw new RuntimeException("连接池已满！");
        }
        for(int i = 0;i<count;i++){
            try{
                Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
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
                    Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
                    pooledConnection.setConnection(connection);
                    pooledConnection.setBusy(true);
                    return pooledConnection;
                }
            }
        }
        return null;
    }
}
