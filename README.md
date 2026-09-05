College Event Management System

📌 About the Project

The College Event Management System is a Java-based console application developed to make college event management easier and more organized.
In colleges, managing students, events, and registrations manually can become difficult. This project provides a simple system where users can add and search students, manage events, register students for events, and cancel registrations.
The project is developed using Core Java and focuses on applying Object-Oriented Programming concepts in a practical project.

🎯 Objectives

The main objectives of this project are:

- To manage student and admin information.
- To create and manage college events.
- To allow students to register for events.
- To prevent duplicate registrations.
- To check event capacity before registration.
- To search users, events, and registrations.
- To allow registration cancellation.
- To store important data using text files.
- To understand how Java concepts can be used in a real-world application.

  
✨ Features

👤 User Management

The system allows us to:

- Add a Student
- Add an Admin
- View all users
- Search a user by ID
- Prevent duplicate User IDs
- Save user information in a file
  
🎫 Event Management

The system allows us to:

- Add a new event
- View all events
- Search an event
- Update event venue and capacity
- Delete an event
- Prevent duplicate Event IDs
- Save event information in a file
  
📝 Registration Management

The system allows us to:

- Register a student for an event
- View all registrations
- Search a registration
- Cancel a registration
- Prevent duplicate registrations
- Check event capacity
- Save registration information
  
🛠️ Technologies Used

- Java
- Core JavaObject-Oriented Programming
- ArrayList
- File Handling
- Exception Handling
- Custom Exceptions
- Visual Studio Code
- Git
- GitHub


🏗️ Project Structure

```team
CollegeEventManagementSystem
│
├── src
│   ├── Main.java
│   ├── Menu.java
│   │
│   ├── model
│   │   ├── User.java
│   │   ├── Student.java
│   │   ├── Admin.java
│   │   ├── Event.java
│   │   └── Registration.java
│   │
│   ├── service
│   │   ├── UserService.java
│   │   ├── EventService.java
│   │   └── RegistrationService.java
│   │
│   ├── database
│   │   ├── UserDatabase.java
│   │   ├── EventDatabase.java
│   │   └── RegistrationDatabase.java
│   │
│   └── exception
│       ├── EventNotFoundException.java
│       ├── RegistrationNotFoundException.java
│       └── InvalidRegistrationException.java
│
├── .gitignore
├── README.md
└── statement.md

```
🔄 How the System Works

The application starts with a main menu:
```
========================================
      COLLEGE EVENT MANAGEMENT SYSTEM
========================================

1. User Management
2. Event Management
3. Registration Management
4. Exit

Enter your choice:

```
The user can select any of the three main modules and perform the required operations.

Basic Workflow
```
Start Application
       ↓
    Main Menu
       ↓
 ┌─────┼──────────────┐
 ↓     ↓              ↓
User  Event      Registration
Menu  Menu           Menu
 ↓     ↓              ↓
Add   Add          Register
View  View         Search
Search Search      Cancel
       ↓
      Exit
```
💾 Data Storage

The project uses simple text files for storing data.
```
users.txt
events.txt
registrations.txt
```
This allows the application to retain important information even after the program is closed.

⚠️ Validation and Error Handling

Different validations have been added to make the application more reliable.

For example:

- A duplicate User ID cannot be added.
- A duplicate Event ID cannot be added.
- A student cannot register for the same event twice.
- Registration is rejected when an event is full.
- Searching for a non-existing user/event/registration shows an appropriate message.
- Invalid registration information is handled using custom exceptions.
- File-related errors are handled during data storage.

  
📚 Java Concepts Used

While developing this project, the following Java concepts have been implemented:

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Constructors
- Method Overriding
- ArrayList
- Packages
- File Handling
- Exception Handling
- Custom Exceptions
- Menu-driven Programming

For example, Student and Admin inherit common properties from the User class.

```
              User
             /    \
            /      \
       Student     Admin
```
🧪 Testing

The application has been tested for important operations such as:

Adding students
Adding admins
Searching users
Duplicate user validation
Adding events
Searching events
Updating events
Deleting events
Registering students
Searching registrations
Cancelling registrations
Duplicate registration validation
Event capacity validation
Invalid ID testing
File data persistence

🚀 How to Run

Open the project in VS Code and open the terminal inside the src folder.

Compile
```
javac database/*.java exception/*.java model/*.java service/*.java Main.java Menu.java
```
Run
java Main

🔮 Future Improvements

In the future, this project can be improved by adding:

- GUI using Java Swing or JavaFX
- MySQL database
- Student login system
- Admin authentication
- Email notifications
- Event reminders
- Attendance management
- Event feedback and ratings
- Event reports
- Better search and filtering

  
👨‍💻 Author

Niraj Yadav

This project was developed as a Java project to practice programming concepts and build a practical college event management application.

🔗 GitHub Repository

College Event Management System

https://github.com/nirajyadav-cse/CollegeEventManagementSystem
