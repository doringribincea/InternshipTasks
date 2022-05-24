package com.dorin.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

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

        try {
            var stmt = connection.createStatement();
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertUser(User user) {
        String query = String
                .format("Insert into Users (Username, Firstname, Lastname) VALUES (\"%s\", \"%s\", \"%s\")",
                        user.getUserName(), user.getFirstName(), user.getLastName());

        try {

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid() AS q");
            while (rs.next()) {
                System.out.println(rs.getInt("q"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<User> selectAllUsers() {
        List<User> result = new LinkedList<>();

        String query = "SELECT UserId, GroupId, Username, Firstname, Lastname FROM `Users`";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("UserId"));
                u.setId(rs.getInt("GroupId"));
                u.setUserName(rs.getString("Username"));
                u.setFirstName(rs.getString("Firstname"));
                u.setLastName(rs.getString("Lastname"));

                result.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
