package bddmanager.sql;

import bddmanager.sql.tables.TableDatabase;
import bddmanager.sql.tables.TableJunction;
import bddmanager.sql.tables.TableSerie;
import bddmanager.sql.tables.TableStudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<TableDatabase> retrieveAllDB() {
        String sql = "SELECT * FROM DB;";
        List<TableDatabase> databases = new ArrayList<>();
        try {
            // create statement
            Statement st = m_con.createStatement();

            for (int i = 0; i < st.getFetchSize(); i++) {
                ResultSet result = st.executeQuery(sql);
                this.m_database.callback(result);
                databases.add(this.m_database);
            }
        } catch (SQLException ex) {
            System.err.println("error : " + ex);
        }
        return databases;
    }
}