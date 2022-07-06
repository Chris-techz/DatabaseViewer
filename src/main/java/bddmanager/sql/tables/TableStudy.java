package bddmanager.sql.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableStudy implements Table{

    private LinkedHashMap<String, String> m_entry;

    public TableStudy() {
        this.m_entry = new LinkedHashMap<>( );
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
            this.m_entry.put("PATIENT_NAME", result.getString(2));
            this.m_entry.put("PATIENT_ID", result.getString(3));
            this.m_entry.put("PATIENT_BIRTHDATE", result.getString(4));
            this.m_entry.put("PATIENT_SEX", result.getString(5));
            this.m_entry.put("PATIENT_AGE", result.getString(6));
            this.m_entry.put("PATIENT_COMMENTS", result.getString(7));
            this.m_entry.put("STUDY_ID", result.getString(8));
            this.m_entry.put("STUDY_DATE", result.getString(9));
            this.m_entry.put("STUDY_DESCRIPTION", result.getString(10));
            this.m_entry.put("SERIES_COUNT", result.getString(11));
        }catch(SQLException ex) {
            System.out.println("error " + ex);
            return 1;
        }
        return 0;
    }
}
