package service;

import model.Student;
import model.Admin;
import model.User;
import database.UserDatabase; 

import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users = UserDatabase.loadUsers();

    // ADD USER
    public void addUser(User user) {

        if (user == null) {
            System.out.println("User cannot be null.");
            return;
        }

        for (User existingUser : users) {

            if (existingUser.getUserId() == user.getUserId()) {

                System.out.println(
                        "User with ID " + user.getUserId()
                                + " already exists."
                );

                return;
            }
        }

        users.add(user);

       UserDatabase.saveUsers(users);

      System.out.println("User added successfully!");  
    }

    // VIEW ALL USERS
    public void viewUsers() {

        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        System.out.println("\n===== ALL USERS =====");

        for (User user : users) {

            user.displayUserInfo();

            if (user instanceof Student) {

                Student student = (Student) user;

                System.out.println(
                        "Course: " + student.getCourse()
                );

                System.out.println(
                        "Year: " + student.getYear()
                );

            } else if (user instanceof Admin) {

                Admin admin = (Admin) user;

                System.out.println(
                        "Department: " + admin.getDepartment()
                );
            }

            System.out.println("--------------------");
        }
    }

    // SEARCH USER
    public void searchUser(int userId) {

        User user = getUserById(userId);

        if (user == null) {

            System.out.println(
                    "User with ID " + userId + " not found."
            );

            return;
        }

        System.out.println("\n===== USER FOUND =====");

        user.displayUserInfo();

        if (user instanceof Student) {

            Student student = (Student) user;

            System.out.println(
                    "Course: " + student.getCourse()
            );

            System.out.println(
                    "Year: " + student.getYear()
            );

        } else if (user instanceof Admin) {

            Admin admin = (Admin) user;

            System.out.println(
                    "Department: " + admin.getDepartment()
            );
        }
    }

    // GET USER BY ID
    public User getUserById(int userId) {

        for (User user : users) {

            if (user.getUserId() == userId) {
                return user;
            }
        }

        return null;
    }

    // GET STUDENT BY ID
    public Student getStudentById(int userId) {

        User user = getUserById(userId);

        if (user instanceof Student) {
            return (Student) user;
        }

        return null;
    }
}