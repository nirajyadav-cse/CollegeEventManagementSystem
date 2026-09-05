package service;

import database.RegistrationDatabase;
import exception.InvalidRegistrationException;
import exception.RegistrationNotFoundException;
import java.util.ArrayList;
import model.Event;
import model.Registration;

public class RegistrationService {

    private ArrayList<Registration> registrations =
        RegistrationDatabase.loadRegistrations();

    // REGISTER STUDENT
    public void registerStudent(Registration registration)
        throws InvalidRegistrationException {
            if (registration == null) {

    throw new InvalidRegistrationException(
            "Registration cannot be null."
    );
}

if (registration.getStudent() == null) {

    throw new InvalidRegistrationException(
            "Student information is required."
    );
}

if (registration.getEvent() == null) {

    throw new InvalidRegistrationException(
            "Event information is required."
    );
}

        Event event = registration.getEvent();

        int registeredCount = 0;

        // Check duplicate registration
        for (Registration r : registrations) {

            if (r.getStudent().getUserId() == registration.getStudent().getUserId()
                    && r.getEvent().getEventId() == event.getEventId()
                    && r.getStatus().equals("Registered")) {

                System.out.println("Registration failed!");
                System.out.println("Student is already registered for this event.");

                return;
            }
        }

        // Count active registrations for this event
        for (Registration r : registrations) {

            if (r.getEvent().getEventId() == event.getEventId()
                    && r.getStatus().equals("Registered")) {

                registeredCount++;
            }
        }

        // Check event capacity
        if (registeredCount >= event.getCapacity()) {

            System.out.println("Registration failed!");
            System.out.println("Event is full.");

            return;
        }

        registrations.add(registration);

RegistrationDatabase.saveRegistrations(registrations);

System.out.println("Student registered successfully!");
    }

    // VIEW REGISTRATIONS
    public void viewRegistrations() {

        if (registrations.isEmpty()) {
            System.out.println("No registrations available.");
            return;
        }

        System.out.println("\n===== ALL REGISTRATIONS =====");

        for (Registration registration : registrations) {

            registration.displayRegistrationInfo();

            System.out.println("-----------------------------");
        }
    }

    // SEARCH REGISTRATION
   public void searchRegistration(int registrationId)
        throws RegistrationNotFoundException {

    for (Registration registration : registrations) {

        if (registration.getRegistrationId() == registrationId) {

            System.out.println("\n===== REGISTRATION FOUND =====");

            registration.displayRegistrationInfo();

            return;
        }
    }

    throw new RegistrationNotFoundException(
            "Registration with ID " + registrationId + " not found."
    );
}
    // CANCEL REGISTRATION
   public void cancelRegistration(int registrationId)
        throws RegistrationNotFoundException {

    for (Registration registration : registrations) {

        if (registration.getRegistrationId() == registrationId) {

           registration.setStatus("Cancelled");

RegistrationDatabase.saveRegistrations(registrations);

System.out.println("Registration cancelled successfully!");

            return;
        }
    }

    throw new RegistrationNotFoundException(
            "Registration with ID " + registrationId + " not found."
    );
}
}