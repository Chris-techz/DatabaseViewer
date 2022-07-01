package bddmanager.sql.tables;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public interface Table {

    /**
     * Retrieve data from SQL database
     */
    public int callback(ResultSet result);

}
