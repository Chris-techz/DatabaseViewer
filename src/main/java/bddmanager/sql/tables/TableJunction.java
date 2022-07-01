package bddmanager.sql.tables;

import java.sql.ResultSet;
import java.util.Map;

public class TableJunction implements Table{

    private Map<String, String> m_entry;

    public Map<String, String> getEntry() {
        return m_entry;
    }

    public void setEntry(String column, String value) {
        this.m_entry.put(column, value);
    }

    public int callback(ResultSet result) {
        return 0;
    }
}
