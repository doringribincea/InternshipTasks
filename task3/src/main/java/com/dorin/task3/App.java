package com.dorin.task3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class App {

    public static void main(String[] args) {
        DataAccessObject dao = new DataAccessObject();

        if (args[0].equals("-clean")) {
            dao.cleanDatastore();
            System.out.println("Datastore was cleaned");
        }

        switch (args[0]) {
            case "-clean":
                dao.cleanDatastore();
                System.out.println("Datastore was cleaned");
                return;
            case "-createUser":
                createUser(args);
                break;
            case "-showAllUsers":
                // showAllUsers(users);
                break;
            case "-addTask":
                // addTask(args, users, tasks);
                break;
            case "-showTasks":
                // showTasks(args, tasks);
                break;
        }

    }

    public static void createUser(String[] args) {
        User user = new User();
        for (int i = 1; i < args.length; i++) {
            String[] splitted = args[i].split("=");
            if (splitted[0].equals("-fn")) {
                user.setFirstName(splitted[1]);
            }
            if (splitted[0].equals("-ln")) {
                user.setLastName(splitted[1]);
            }
            if (splitted[0].equals("-un")) {
                user.setUserName(splitted[1]);
            }
        }

        

    }

}
