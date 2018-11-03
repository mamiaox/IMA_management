package cn.albumenj.dao;

import cn.albumenj.model.SqlModel;
import cn.albumenj.util.connectionpool.PoolSubmit;
import cn.albumenj.model.LogModel;
import cn.albumenj.model.ResultModel;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Albumen
 */
public class SqlCommit {
    private static final String URL = "jdbc:mysql://localhost:3306/ima_management?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection con;
    private static boolean Connected = false;

    public static boolean connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!con.isClosed()) {
                Connected = true;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isConnected() {
        return Connected;
    }

    public static void setConnected(boolean connected) {
        Connected = connected;
    }

    public static List<Map<String, String>> selectWhere(String table,Map<String,String> condition){
        List<Map<String, String>> list = new LinkedList<>();
        String sql = "SELECT * FROM `ima_management`.`" + table + "`";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();
        if(!condition.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sql);
            stringBuilder.append(" WHERE ");
            int count = 1;
            for (String key : condition.keySet()) {
                stringBuilder.append("`");
                stringBuilder.append(key);

                stringBuilder.append("` = ");
                stringBuilder.append("?");
                stringBuilder.append(",");
                prepareCondition.put(count,condition.get(key));
                count++;
            }
            sql = stringBuilder.toString();
            sql = sql.substring(0, sql.length() - 1);
        }

        try {
            ResultModel resultModel = new ResultModel();
            resultModel.setMod(1);
            SqlModel sqlModel = new SqlModel();
            sqlModel.setSql(sql);
            sqlModel.setCondition(prepareCondition);
            resultModel.setSql(sqlModel);
            resultModel = new PoolSubmit().execute(resultModel);

            try {
                while(new PoolSubmit().fetch(resultModel.getSeed())==null) {
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ResultSet rs = resultModel.getResultSet();

            LogModel logModel = new LogModel(sql);
            //LogCommit(logModel);
            LogCommit.submit(logModel);

            ResultSetMetaData rsmd = rs.getMetaData();
            if (!rs.next()) {
                rs.close();
                return list;
            } else {
                int count = rsmd.getColumnCount();
                String[] name = new String[count];

                for (int i = 0; i < count; i++) {
                    name[i] = rsmd.getColumnName(i + 1);
                }

                do {
                    Map<String, String> mapGet = new LinkedHashMap<>();
                    for (int i = 0; i < count; i++) {
                        mapGet.put(name[i], rs.getString(name[i]));
                    }
                    list.add(mapGet);
                } while (rs.next());
            }
            rs.close();
            return list;

        } catch (SQLException e) {
            return list;
        }
    }

    public static boolean update(String table, int no, Map<String, String> data) {
        String sql = "UPDATE `ima_management`.`" + table + "` SET ";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sql);
        int count = 1;
        for (String key : data.keySet()) {
            stringBuilder.append("`");
            stringBuilder.append(key);

            stringBuilder.append("` = ");
            stringBuilder.append("?");
            stringBuilder.append(",");
            prepareCondition.put(count,data.get(key));
            count++;
        }
        sql = stringBuilder.toString();
        sql = sql.substring(0, sql.length() - 1);
        sql = sql + "WHERE `no` = " + no;

        ResultModel resultModel = new ResultModel();
        resultModel.setMod(2);
        SqlModel sqlModel = new SqlModel();
        sqlModel.setSql(sql);
        sqlModel.setCondition(prepareCondition);
        resultModel.setSql(sqlModel);
        resultModel = new PoolSubmit().execute(resultModel);

        LogModel logModel = new LogModel(sql);
        LogCommit.submit(logModel);

        try {
            while((resultModel = new PoolSubmit().fetch(resultModel.getSeed()))!=null) {
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert resultModel != null;
        return !resultModel.isResult();

    }

    public static boolean delete(String table, int no) {
        String sql = "DELETE FROM `ima_management`.`" + table + "` WHERE `no` = " + "?";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();
        prepareCondition.put(1,no+"");

        ResultModel resultModel = new ResultModel();
        resultModel.setMod(2);
        SqlModel sqlModel = new SqlModel();
        sqlModel.setSql(sql);
        sqlModel.setCondition(prepareCondition);
        resultModel.setSql(sqlModel);
        resultModel = new PoolSubmit().execute(resultModel);

        LogModel logModel = new LogModel(sql);
        LogCommit.submit(logModel);

        try {
            while((resultModel = new PoolSubmit().fetch(resultModel.getSeed()))!=null) {
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert resultModel != null;
        return !resultModel.isResult();
    }

    public static boolean insert(String table, Map<String, String> data) {
        String sql = "INSERT `ima_management`.`" + table + "` ( ";
        String value = ") VALUES (";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();

        StringBuilder stringBuilderSQL = new StringBuilder();
        StringBuilder stringBuilderValue = new StringBuilder();
        stringBuilderSQL.append(sql);
        stringBuilderValue.append(value);
        int count = 1;
        for (String key : data.keySet()) {
            stringBuilderSQL.append(" `");
            stringBuilderSQL.append(key);
            stringBuilderSQL.append("`,");

            stringBuilderValue.append("?");
            stringBuilderValue.append(",");
            prepareCondition.put(count,data.get(key));
            count++;
        }
        sql = stringBuilderSQL.toString();
        value = stringBuilderValue.toString();

        sql = sql.substring(0, sql.length() - 1);
        value = value.substring(0, value.length() - 1);
        sql = sql + value + ")";

        ResultModel resultModel = new ResultModel();
        resultModel.setMod(2);
        SqlModel sqlModel = new SqlModel();
        sqlModel.setSql(sql);
        sqlModel.setCondition(prepareCondition);
        resultModel.setSql(sqlModel);
        resultModel = new PoolSubmit().execute(resultModel);

        LogModel logModel = new LogModel(sql);
        LogCommit.submit(logModel);

        try {
            while((resultModel = new PoolSubmit().fetch(resultModel.getSeed()))!=null) {
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert resultModel != null;
        return !resultModel.isResult();

    }
}
