package cn.albumenj.dao;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class mysqlConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/ima_management?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection con;
    private static boolean Connected = false;

    public static boolean connect(){
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            if(!con.isClosed()) {
                Connected = true;
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static void close() {
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isConnected() {
        return Connected;
    }

    public static void setConnected(boolean connected) {
        Connected = connected;
    }

    public static List<Map<String,String>> select(String table){
        List<Map<String,String>> list = new LinkedList<>();
        String sql = "SELECT * FROM `ima_management`.`" + table+"`";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            if(!rs.next()) {
                rs.close();
                return list;
            }
            else {
                int count = rsmd.getColumnCount();
                String[] name=new String[count];

                for(int i=0;i<count;i++)
                    name[i]=rsmd.getColumnName(i+1);

                do{
                    Map<String,String> mapGet = new LinkedHashMap<>();
                    for(int i=0;i<count;i++)
                        mapGet.put(name[i],rs.getString(name[i]));
                    list.add(mapGet);
                }while(rs.next());
            }
            rs.close();
            return list;

        }catch(SQLException e) {
            return list;
        }
    }

    public static boolean update(String table,int no,Map<String,String> data){
        String sql = "UPDATE `ima_management`.`" + table + "` SET ";
        for(String key:data.keySet())
            sql = sql + "`" + key + "` = '" + data.get(key) + "',";
        sql = sql.substring(0,sql.length() - 1);
        sql = sql + "WHERE `no` = "+no;

        try {
            Statement statement = con.createStatement();
            return !statement.execute(sql);
        }catch(SQLException e)
        {
            return false;
        }
    }

    public static boolean delete(String table,int no){
        String sql = "DELETE FROM `ima_management`.`" + table + "` WHERE `no` = "+no;
        try {
            Statement statement = con.createStatement();
            return !statement.execute(sql);
        }catch(SQLException e) {
            return false;
        }
    }

    public static boolean insert(String table,Map<String,String> data){
        String sql = "INSERT `ima_management`.`" + table + "` ( ";
        String value = ") VALUES (";
        for(String key:data.keySet()){
            sql = sql + " `" + key + "`,";
            value = value + " '" + data.get(key) + "',";
        }
        sql = sql.substring(0,sql.length() - 1);
        value = value.substring(0,value.length() - 1);
        sql = sql +value + ")";

        try {
            Statement statement = con.createStatement();
            return !statement.execute(sql);
        }catch(SQLException e) {
            return false;
        }
    }
}