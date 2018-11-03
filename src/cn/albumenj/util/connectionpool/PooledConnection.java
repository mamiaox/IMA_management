package cn.albumenj.util.connectionpool;

import cn.albumenj.model.SqlModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public ResultSet query(SqlModel sql) {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql.getSql());
            for(int i=1;i<=sql.getCondition().size();i++){
                preparedStatement.setString(i,sql.getCondition().get(i));
            }
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean execute(SqlModel sql) {
        PreparedStatement preparedStatement;
        boolean ret = false;
        try {
            preparedStatement = connection.prepareStatement(sql.getSql());
            for(int i=1;i<=sql.getCondition().size();i++){
                preparedStatement.setString(i,sql.getCondition().get(i));
            }
            ret = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
