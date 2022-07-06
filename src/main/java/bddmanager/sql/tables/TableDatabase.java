package bddmanager.sql.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableDatabase implements Table{

    private LinkedHashMap<String, String> m_entry;

    public TableDatabase() {
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
                this.m_entry.put("ID", result.getString(1));
                this.m_entry.put("DB_NAME", result.getString(2));
                this.m_entry.put("DB_VERSION", result.getString(3));
                this.m_entry.put("DB_COMMENT", result.getString(4));
                this.m_entry.put("STUDY_COUNT", result.getString(5));
                this.m_entry.put("CREATION_DATE", result.getString(6));
                this.m_entry.put("USER_CHECK", result.getString(7));
            }catch(SQLException ex) {
            System.out.println("error " + ex);
            return 1;
        }
        return 0;
    }
}
