package com.dorin.task3;

public class DataAccessObject {
    private static final String DB_URL = "jdbc:sqlite:local.running.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
