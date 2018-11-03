package cn.albumenj.model;

import java.util.Map;

/**
 * @author Albumen
 */
public class SqlModel {
    private String sql;
    private Map<Integer,String> condition;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getCondition() {
        return condition;
    }

    public void setCondition(Map<Integer, String> condition) {
        this.condition = condition;
    }
}
