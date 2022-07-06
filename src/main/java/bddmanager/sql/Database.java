package bddmanager.sql;

import bddmanager.sql.tables.TableDatabase;
import bddmanager.sql.tables.TableJunction;
import bddmanager.sql.tables.TableSerie;
import bddmanager.sql.tables.TableStudy;

import java.sql.*;
import java.util.*;

// TODO : Make some classes to store retrieved tables
public class Database {
    private TableDatabase m_database;
    private TableStudy m_study;
    private TableJunction m_junction;
    private TableSerie m_serie;
    private Connection m_con = null;
    private final String m_url = "jdbc:sqlite:database/database.db";


    public Database() {
        connect();
        this.m_database = new TableDatabase();
        this.m_study = new TableStudy();
        this.m_junction = new TableJunction();
        this.m_serie = new TableSerie();
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
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    public TableDatabase retrieveDB(int id) {
        String sql = "SELECT * FROM DB WHERE ";

        try {
            sql += "ID = ";
            sql += id;
            sql += ";";

            // create statement
            Statement st = m_con.createStatement();

            // execute querry
            ResultSet result = st.executeQuery(sql);

            this.m_database.callback(result);

        } catch (SQLException ex) {
            System.err.println("error : " + ex);
        }
        return this.m_database;
    }

    public List<LinkedHashMap<String, String>> retrieveAllEntries(String table) {

        String sql = "SELECT * FROM ";
        switch(table) {
            case "DB" :
                sql += "DB;";
                break;
            case "STUDY" :
                sql += "STUDY;";
                break;
            case "SERIES" :
                sql += "SERIES;";
                break;
            case "JUNCTION" :
                sql += "JUNCTION;";
                break;
        }
        List<LinkedHashMap<String, String>> entries = new ArrayList<>();
        try {
            // create statement
            Statement st = m_con.createStatement();
            ResultSet result = st.executeQuery(sql);

            while(result.next()) {
                switch(table) {
                    case "DB" :
                        this.m_database.callback(result);
                        entries.add(new LinkedHashMap<>(m_database.getEntry()));
                        break;
                    case "STUDY" :
                        this.m_study.callback(result);
                        entries.add(new LinkedHashMap<>(m_study.getEntry()));
                        break;
                    case "SERIES" :
                        this.m_serie.callback(result);
                        entries.add(new LinkedHashMap<>(m_serie.getEntry()));
                        break;
                    case "JUNCTION" :
                        this.m_junction.callback(result);
                        entries.add(new LinkedHashMap<>(m_junction.getEntry()));
                        break;
                }
            }
        } catch (SQLException ex) {
            System.err.println("error : " + ex);
        }
        return entries;
    }
}