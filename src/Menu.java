
import exception.EventNotFoundException;
import exception.InvalidRegistrationException;
import exception.RegistrationNotFoundException;
import java.util.Scanner;
import model.Admin;
import model.Event;
import model.Registration;
import model.Student;
import service.EventService;
import service.RegistrationService;
import service.UserService;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    private UserService userService = new UserService();
    private EventService eventService = new EventService();
    private RegistrationService registrationService =
            new RegistrationService();

    private int nextRegistrationId = 500;

    // ================================
    // START APPLICATION
    // ================================

    public void start() {

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("     COLLEGE EVENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. User Management");
            System.out.println("2. Event Management");
            System.out.println("3. Registration Management");
            System.out.println("4. Exit");
            System.out.println("========================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    userMenu();
                    break;

                case 2:
                    eventMenu();
                    break;

                case 3:
                    registrationMenu();
                    break;

                case 4:
                    System.out.println(
                            "Thank you for using College Event Management System!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 4);
    }

    // ================================
    // USER MANAGEMENT
    // ================================

    private void userMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("===== USER MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Admin");
            System.out.println("3. View Users");
            System.out.println("4. Search User");
            System.out.println("5. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addAdmin();
                    break;

                case 3:
                    userService.viewUsers();
                    break;

                case 4:
                    searchUser();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    private void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        int id = readInt("Enter Student ID: ");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        int year = readInt("Enter Year: ");

        Student student = new Student(
                id,
                name,
                email,
                course,
                year
        );

        userService.addUser(student);
    }

    private void addAdmin() {

        System.out.println("\n===== ADD ADMIN =====");

        int id = readInt("Enter Admin ID: ");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Admin admin = new Admin(
                id,
                name,
                email,
                department
        );

        userService.addUser(admin);
    }

    private void searchUser() {

        int id = readInt("Enter User ID: ");

        userService.searchUser(id);
    }

    // ================================
    // EVENT MANAGEMENT
    // ================================

    private void eventMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("===== EVENT MANAGEMENT =====");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Search Event");
            System.out.println("4. Update Event");
            System.out.println("5. Delete Event");
            System.out.println("6. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addEvent();
                    break;

                case 2:
                    eventService.viewEvents();
                    break;

                case 3:
                    searchEvent();
                    break;

                case 4:
                    updateEvent();
                    break;

                case 5:
                    deleteEvent();
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    private void addEvent() {

        System.out.println("\n===== ADD EVENT =====");

        int id = readInt("Enter Event ID: ");

        System.out.print("Enter Event Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Venue: ");
        String venue = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        int capacity = readInt("Enter Capacity: ");

        Event event = new Event(
                id,
                name,
                date,
                venue,
                category,
                capacity
        );

        eventService.addEvent(event);
    }

    private void searchEvent() {

        int id = readInt("Enter Event ID: ");

        try {

            eventService.searchEvent(id);

        } catch (EventNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateEvent() {

        int id = readInt("Enter Event ID: ");

        System.out.print("Enter New Venue: ");
        String venue = scanner.nextLine();

        int capacity = readInt("Enter New Capacity: ");

        try {

            eventService.updateEvent(
                    id,
                    venue,
                    capacity
            );

        } catch (EventNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteEvent() {

        int id = readInt("Enter Event ID: ");

        try {

            eventService.deleteEvent(id);

        } catch (EventNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================================
    // REGISTRATION MANAGEMENT
    // ================================

    private void registrationMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("===== REGISTRATION MANAGEMENT =====");
            System.out.println("1. Register Student");
            System.out.println("2. View Registrations");
            System.out.println("3. Search Registration");
            System.out.println("4. Cancel Registration");
            System.out.println("5. Back");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    registrationService.viewRegistrations();
                    break;

                case 3:
                    searchRegistration();
                    break;

                case 4:
                    cancelRegistration();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    private void registerStudent() {

    System.out.println("\n===== REGISTER STUDENT =====");

    int studentId = readInt("Enter Student ID: ");

    Student student = userService.getStudentById(studentId);

    if (student == null) {
        System.out.println("Student with ID " + studentId + " not found.");
        return;
    }

    int eventId = readInt("Enter Event ID: ");

    Event event = eventService.getEventById(eventId);

    if (event == null) {
        System.out.println("Event with ID " + eventId + " not found.");
        return;
    }

    Registration registration = new Registration(
            nextRegistrationId++,
            student,
            event,
            "Registered"
    );

    try {

        registrationService.registerStudent(registration);

    } catch (InvalidRegistrationException e) {

        System.out.println(
                "Registration failed: " + e.getMessage()
        );
    }
}
private void searchRegistration() {

    System.out.println("\n===== SEARCH REGISTRATION =====");

    int registrationId =
            readInt("Enter Registration ID: ");

    try {

        registrationService.searchRegistration(registrationId);

    } catch (RegistrationNotFoundException e) {

        System.out.println(
                "Search failed: " + e.getMessage()
        );
    }
}
    private void cancelRegistration() {

        int id = readInt("Enter Registration ID: ");

        try {

            registrationService.cancelRegistration(id);

        } catch (RegistrationNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================================
    // INPUT VALIDATION
    // ================================

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value = scanner.nextInt();

                scanner.nextLine();

                return value;

            } catch (Exception e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
            }
        }
    }
}