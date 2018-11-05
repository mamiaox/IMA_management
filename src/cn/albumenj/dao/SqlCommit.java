package cn.albumenj.dao;

import cn.albumenj.model.SqlCommitModel;
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

    public static List<Map<String, String>> selectWhere(SqlCommitModel sqlCommitModel){
        List<Map<String, String>> list = new LinkedList<>();
        String sql = "SELECT * FROM `"+sqlCommitModel.getDatabase()+"`.`" + sqlCommitModel.getTable() + "`";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();
        if(!sqlCommitModel.getCondition().isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sql);
            stringBuilder.append(" WHERE ");
            int count = 1;
            for (String key : sqlCommitModel.getCondition().keySet()) {
                stringBuilder.append("`");
                stringBuilder.append(key);

                stringBuilder.append("` = ");
                stringBuilder.append("?");
                stringBuilder.append(",");
                prepareCondition.put(count,sqlCommitModel.getCondition().get(key));
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

    public static boolean update(SqlCommitModel sqlCommitModel) {
        String sql = "UPDATE `"+sqlCommitModel.getDatabase()+"`.`" + sqlCommitModel.getTable() + "` SET ";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sql);
        int count = 1;
        for (String key : sqlCommitModel.getData().keySet()) {
            stringBuilder.append("`");
            stringBuilder.append(key);

            stringBuilder.append("` = ");
            stringBuilder.append("?");
            stringBuilder.append(",");
            prepareCondition.put(count,sqlCommitModel.getData().get(key));
            count++;
        }
        sql = stringBuilder.toString();
        sql = sql.substring(0, sql.length() - 1);
        sql = sql + "WHERE `no` = " + sqlCommitModel.getNo();

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

    public static boolean delete(SqlCommitModel sqlCommitModel) {
        String sql = "DELETE FROM `"+sqlCommitModel.getDatabase()+"`.`" + sqlCommitModel.getTable() + "` WHERE `no` = " + "?";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();
        prepareCondition.put(1,sqlCommitModel.getNo()+"");

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

    public static boolean insert(SqlCommitModel sqlCommitModel) {
        String sql = "INSERT `"+sqlCommitModel.getDatabase()+"`.`" + sqlCommitModel.getTable() + "` ( ";
        String value = ") VALUES (";
        Map<Integer,String> prepareCondition = new LinkedHashMap<>();

        StringBuilder stringBuilderSQL = new StringBuilder();
        StringBuilder stringBuilderValue = new StringBuilder();
        stringBuilderSQL.append(sql);
        stringBuilderValue.append(value);
        int count = 1;
        for (String key : sqlCommitModel.getData().keySet()) {
            stringBuilderSQL.append(" `");
            stringBuilderSQL.append(key);
            stringBuilderSQL.append("`,");

            stringBuilderValue.append("?");
            stringBuilderValue.append(",");
            prepareCondition.put(count,sqlCommitModel.getData().get(key));
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
