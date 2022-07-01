package bddmanager.sql;

import java.sql.*;
// TODO : Make some classes to store retrieved tables
public class Data {
    private Connection m_con = null;
    private final String m_url = "jdbc:sqlite:database/database.db";


    public Data() {
        connect();
    }

    /**
     * Connect to the database
     */
    protected void connect() {
        try {
            this.m_con = DriverManager.getConnection(m_url);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }


    /**
     * Delete the m_con instance
     */
    public void close() {
        try {
            m_con.close();
        }catch(SQLException ex) {
            System.out.println("error " + ex);
        }
    }



}
