package database;

import model.User;
import model.Student;
import model.Admin;



import java.io.*;
import java.util.ArrayList;

public class UserDatabase {

    private static final String FILE_NAME = "users.txt";

    public static void saveUsers(ArrayList<User> users) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (User user : users) {

                if (user instanceof Student) {

                    Student student = (Student) user;

                    writer.println(
                            "STUDENT|" +
                            student.getUserId() + "|" +
                            student.getName() + "|" +
                            student.getEmail() + "|" +
                            student.getCourse() + "|" +
                            student.getYear()
                    );

                } else if (user instanceof Admin) {

                    Admin admin = (Admin) user;

                    writer.println(
                            "ADMIN|" +
                            admin.getUserId() + "|" +
                            admin.getName() + "|" +
                            admin.getEmail() + "|" +
                            admin.getDepartment()
                    );
                }
            }

            System.out.println("Users saved successfully!");

        } catch (IOException e) {

            System.out.println(
                    "Error saving users: " + e.getMessage()
            );
        }
    }

    public static ArrayList<User> loadUsers() {

        ArrayList<User> users = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return users;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data[0].equals("STUDENT")) {

                    int userId = Integer.parseInt(data[1]);
                    String name = data[2];
                    String email = data[3];
                    String course = data[4];
                    int year = Integer.parseInt(data[5]);

                    Student student = new Student(
                            userId,
                            name,
                            email,
                            course,
                            year
                    );

                    users.add(student);

                } else if (data[0].equals("ADMIN")) {

                    int userId = Integer.parseInt(data[1]);
                    String name = data[2];
                    String email = data[3];
                    String department = data[4];

                    Admin admin = new Admin(
                            userId,
                            name,
                            email,
                            department
                    );

                    users.add(admin);
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading users: " + e.getMessage()
            );
        }

        return users;
    }
}