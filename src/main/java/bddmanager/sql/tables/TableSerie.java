package bddmanager.sql.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TableSerie implements Table{

    private LinkedHashMap<String, String> m_entry;

    public TableSerie() {
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
            this.m_entry.put("ID", result.getString(0));
            this.m_entry.put("MODALITY", result.getString(2));
            this.m_entry.put("IMAGE_TYPE", result.getString(3));
            this.m_entry.put("MANUFACTURER", result.getString(4));
            this.m_entry.put("SERIES_DESCRIPTION", result.getString(5));
            this.m_entry.put("SLICE_THICKNESS", result.getString(6));
            this.m_entry.put("STUDY_IUID", result.getString(7));
            this.m_entry.put("SERIES_IUID", result.getString(8));
            this.m_entry.put("PATIENT_ORIENTATION", result.getString(9));
        }catch(SQLException ex) {
            System.out.println("error " + ex);
            return 1;
        }
        return 0;
    }
}
