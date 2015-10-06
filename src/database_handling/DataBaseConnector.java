package database_handling;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class DataBaseConnector {
    //================================================================================
    // Fields
    //================================================================================

    private final static DataBaseConnector INSTANCE = new DataBaseConnector();

    private final String driver = "com.mysql.jdbc.Driver";
    private String name = "companymanagementsystem"; // name of our database
    private final String url = "jdbc:mysql://127.0.0.1:3306/" + name;
    private final String user = "user";
    private final String password = "password";

    //================================================================================
    // Constructors
    //================================================================================
    private DataBaseConnector() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Exception. " + e.getMessage());
        }
    }

    //================================================================================
    // Methods
    //================================================================================
    public Optional<ResultSet> sendQuery(String sql) {

        //statement declaration
        Connection conn = null;
        Statement stmt = null;

        //creating statement
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Exception while connecting DB. " + e.getMessage());
        }

        //SELECT query
        if (sql.startsWith("SELECT")) {
            try {
                return Optional.of(stmt.executeQuery(sql));
            } catch (SQLException e) {
                System.out.println("Exception while sending query to DB. " + e.getMessage());
            }
        } //UPDATE query
        else {
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Exception while updating query to DB. " + e.getMessage());
            }
        }

        disconnect(conn, stmt);

        return Optional.empty();
    }

    public Optional<ResultSet> sendQuery(String sql, ArrayList parameters) {

        //PreparedStatement declaration
        Connection conn = null;
        PreparedStatement stmt = null;

        //creating statement with parameters
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }

        } catch (SQLException e) {
            System.out.println("Exception while creating a statement. " + e.getMessage());
        }

        //SELECT query
        if (sql.startsWith("SELECT")) {
            try {
                return Optional.of(stmt.executeQuery());
            } catch (SQLException e) {
                System.out.println("Exception while sending query to DB. " + e.getMessage());
            }
        } //other queries
        else {
            try {
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Exception while updating query to DB. " + e.getMessage());
            }
        }

        disconnect(conn, stmt);

        return Optional.empty();
    }

    private void disconnect(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception in while disconnecting from DB. " + e.getMessage());
        }
    }

    //================================================================================
    // Accessors
    //================================================================================
    static DataBaseConnector getINSTANCE() {
        return INSTANCE;
    }
}

