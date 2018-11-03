package cn.albumenj.model;

import java.sql.ResultSet;

/**
 * @author Albumen
 */
public class ResultModel {
    private double seed;
    private SqlModel sql;
    private int mod;
    private ResultSet resultSet;
    private boolean result;

    public double getSeed() {
        return seed;
    }

    public void setSeed(double seed) {
        this.seed = seed;
    }

    public SqlModel getSql() {
        return sql;
    }

    public void setSql(SqlModel sql) {
        this.sql = sql;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
