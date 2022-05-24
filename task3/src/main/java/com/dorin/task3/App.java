package com.dorin.task3;

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
                createUser(args, dao);
                break;
            case "-showAllUsers":
                List<User> users = dao.selectAllUsers();
                users.forEach(System.out::println);
                break;
            case "-addTask":
                // addTask(args, users, tasks);
                break;
            case "-showTasks":
                // showTasks(args, tasks);
                break;
        }

    }

    public static void createUser(String[] args, DataAccessObject dao) {
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

        int res = dao.insertUser(user);
        if(res > -1){
            System.out.println(res);
        }
    }

}
