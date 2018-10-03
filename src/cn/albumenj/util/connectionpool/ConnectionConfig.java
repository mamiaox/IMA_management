package cn.albumenj.util.connectionpool;

/**
 * @author Albumen
 */
public class ConnectionConfig {
    public static final String URL = "jdbc:mysql://localhost:3306/ima_management?serverTimezone=UTC&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final int initCount = 10;
    public static final int step = 2;
    public static final int maxThread = 30;
}
