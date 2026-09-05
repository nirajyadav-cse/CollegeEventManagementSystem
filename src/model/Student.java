package model;

public class Student extends User {

    private String course;
    private int year;

    // Constructor
    public Student(int userId, String name, String email,
                   String course, int year) {

        super(userId, name, email);

        this.course = course;
        this.year = year;
    }

    // Getter
    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    // Display student information
    public void displayStudentInfo() {

        displayUserInfo();

        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}