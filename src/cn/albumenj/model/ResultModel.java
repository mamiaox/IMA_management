package cn.albumenj.model;

import java.sql.ResultSet;

/**
 * @author Albumen
 */
public class ResultModel {
    private double seed;
    private String sql;
    private int mod;
    private ResultSet resultSet;
    private boolean result;

    public double getSeed() {
        return seed;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void setSeed(double seed) {
        this.seed = seed;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
}
