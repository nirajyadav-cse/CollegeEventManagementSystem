
package model;

public class Registration {

    private int registrationId;
    private Student student;
    private Event event;
    private String status;

    public Registration(int registrationId, Student student,
                        Event event, String status) {

        this.registrationId = registrationId;
        this.student = student;
        this.event = event;
        this.status = status;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public Event getEvent() {
        return event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayRegistrationInfo() {

        System.out.println("Registration ID: " + registrationId);
        System.out.println("Student ID: " + student.getUserId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Event ID: " + event.getEventId());
        System.out.println("Event Name: " + event.getEventName());
        System.out.println("Status: " + status);
    }
}