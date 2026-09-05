package model;

public class Admin extends User {

    private String department;

    // Constructor
    public Admin(int userId, String name, String email, String department) {

        super(userId, name, email);

        this.department = department;
    }

    // Getter
    public String getDepartment() {
        return department;
    }

    // Display admin information
    public void displayAdminInfo() {

        displayUserInfo();

        System.out.println("Department: " + department);
    }
}