package com.dorin.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {
    public static final String DB_URL = "jdbc:sqlite:local.running.template.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection connection;

    

    public Connection getConnection() {
        return connection;
    }


    public void setConnection(Connection connection) {
        this.connection = connection;
    }



    public DataAccessObject() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanDatastore() {
        String query1 = "DELETE FROM Users";
        String query2 = "DELETE FROM `Group`";
        String query3 = "DELETE FROM Task";

        try{
            var stmt = connection.createStatement();
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int insertUser(User user){
       
        return 0;
    }
}
