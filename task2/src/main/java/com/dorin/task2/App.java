package com.dorin.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "unchecked" })
public class App {
    private static final String FILENAME_USERS = "task2_users_data.out";
    private static final String FILENAME_TASKS = "task2_tasks_data.out";

    private static List<User> loadUsersFromFile() {
        ArrayList<User> users = new ArrayList<>();

        File f = new File(FILENAME_USERS);
        if (!f.exists())
            return users;

        try (FileInputStream fis = new FileInputStream(FILENAME_USERS);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            users = (ArrayList<User>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    private static List<Task> loadTasksFromFile() {
        ArrayList<Task> tasks = new ArrayList<>();

        File f = new File(FILENAME_TASKS);
        if (!f.exists())
            return tasks;

        try (FileInputStream fis = new FileInputStream(FILENAME_TASKS);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            tasks = (ArrayList<Task>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public static void main(String[] args) throws IOException {
        List<User> users = loadUsersFromFile();
        List<Task> tasks = loadTasksFromFile();

        switch (args[0]) {
            case "-createUser":
                createUser(args, users);
                break;
            case "-showAllUsers":
                showAllUsers(users);
                break;
            case "-addTask":
                addTask(args, users, tasks);
                break;
            case "-showTasks":
                showTasks(args, tasks);
                break;
        }

    }

    public static void showAllUsers(List<User> users) {
        users.forEach(u -> {
            System.out.println(u);
        });
    }

    public static void createUser(String[] args, List<User> users) {
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

        if (users.stream().noneMatch(u -> u.getUserName().equals(user.getUserName()))) {
            users.add(user);

            try (FileOutputStream fos = new FileOutputStream(FILENAME_USERS);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                oos.writeObject(users);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            System.out.println(String.format("User with username %s already exists: ABORTING", user.getUserName()));
        }

    }

    public static void addTask(String[] args, List<User> users, List<Task> tasks) {
        Task t = new Task();
        String userName = "";
        for (int i = 1; i < args.length; i++) {
            String[] splitted = args[i].split("=");
            if (splitted[0].equals("-tt")) {
                t.setTitle(splitted[1]);
            }
            if (splitted[0].equals("-td")) {
                t.setDescription(splitted[1]);
            }
            if (splitted[0].equals("-un")) {
                userName = splitted[1];
            }
        }

        for (User user : users) {
            if (user.getUserName().equals(userName)) {

                t.setOwnerUserName(userName);
                tasks.add(t);

                try (FileOutputStream fos = new FileOutputStream(FILENAME_TASKS);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                    oos.writeObject(tasks);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }

                return;
            }
        }

        System.out.println(String.format("User with username %s not found", userName));
    }

    public static void showTasks(String[] args, List<Task> tasks) {
        String userName = "";
        for (int i = 1; i < args.length; i++) {
            String[] splitted = args[i].split("=");
            if (splitted[0].equals("-un")) {
                userName = splitted[1];
            }
        }

        for (Task task : tasks) {
            if(task.getOwnerUserName().equals(userName)){
                System.out.println(task);
            }
        }
    }
}
