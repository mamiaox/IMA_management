package cn.albumenj.util.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Albumen
 */
public class PooledConnection {

    private boolean isBusy;
    private Connection connection;

    public PooledConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }

    public void close() {
        this.isBusy = false;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet query(String sql) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean execute(String sql) {
        Statement statement;
        ResultSet resultSet = null;
        boolean ret = false;
        try {
            statement = connection.createStatement();
            ret = statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
