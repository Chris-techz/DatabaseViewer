package bddmanager.sql.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableJunction implements Table{

    private LinkedHashMap<String, String> m_entry;

    public TableJunction() {
        this.m_entry = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, String> getEntry() {
        return m_entry;
    }

    public void setEntry(String column, String value) {
        this.m_entry.put(column, value);
    }

    public int callback(ResultSet result) {
        try {
            this.m_entry.put("DB_ID", result.getString(1));
            this.m_entry.put("STUDY_ID", result.getString(2));
        }catch(SQLException ex) {
            System.out.println("error " + ex);
            return 1;
        }
        return 0;
    }
}
