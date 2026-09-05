
package database;

import model.Event;
import model.Registration;
import model.Student;

import java.io.*;
import java.util.ArrayList;

public class RegistrationDatabase {

    private static final String FILE_NAME = "registrations.txt";

    // SAVE REGISTRATIONS
    public static void saveRegistrations(
            ArrayList<Registration> registrations) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Registration registration : registrations) {

                writer.println(
                    registration.getRegistrationId() + "|" +
                    registration.getStudent().getUserId() + "|" +
                    registration.getStudent().getName() + "|" +
                    registration.getStudent().getEmail() + "|" +
                    registration.getStudent().getCourse() + "|" +
                    registration.getStudent().getYear() + "|" +
                    registration.getEvent().getEventId() + "|" +
                    registration.getEvent().getEventName() + "|" +
                    registration.getEvent().getDate() + "|" +
                    registration.getEvent().getVenue() + "|" +
                    registration.getEvent().getCategory() + "|" +
                    registration.getEvent().getCapacity() + "|" +
                    registration.getStatus()
                );
            }

            System.out.println("Registrations saved successfully!");

        } catch (IOException e) {

            System.out.println(
                    "Error saving registrations: " + e.getMessage()
            );
        }
    }

    // LOAD REGISTRATIONS
    public static ArrayList<Registration> loadRegistrations() {

        ArrayList<Registration> registrations = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return registrations;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                int registrationId = Integer.parseInt(data[0]);

                int studentId = Integer.parseInt(data[1]);
                String studentName = data[2];
                String studentEmail = data[3];
                String course = data[4];
                int year = Integer.parseInt(data[5]);

                int eventId = Integer.parseInt(data[6]);
                String eventName = data[7];
                String date = data[8];
                String venue = data[9];
                String category = data[10];
                int capacity = Integer.parseInt(data[11]);

                String status = data[12];

                Student student = new Student(
                        studentId,
                        studentName,
                        studentEmail,
                        course,
                        year
                );

                Event event = new Event(
                        eventId,
                        eventName,
                        date,
                        venue,
                        category,
                        capacity
                );

                Registration registration = new Registration(
                        registrationId,
                        student,
                        event,
                        status
                );

                registrations.add(registration);
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading registrations: " + e.getMessage()
            );
        }

        return registrations;
    }
}