package database;

import model.Event;
import java.io.*;
import java.util.ArrayList;

public class EventDatabase {

    private static final String FILE_NAME = "events.txt";

    // SAVE EVENTS
    public static void saveEvents(ArrayList<Event> events) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Event event : events) {

                writer.println(
                    event.getEventId() + "|" +
                    event.getEventName() + "|" +
                    event.getDate() + "|" +
                    event.getVenue() + "|" +
                    event.getCategory() + "|" +
                    event.getCapacity()
                );
            }

            System.out.println("Events saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    // LOAD EVENTS
    public static ArrayList<Event> loadEvents() {

        ArrayList<Event> events = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return events;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                int eventId = Integer.parseInt(data[0]);
                String eventName = data[1];
                String date = data[2];
                String venue = data[3];
                String category = data[4];
                int capacity = Integer.parseInt(data[5]);

                Event event = new Event(
                        eventId,
                        eventName,
                        date,
                        venue,
                        category,
                        capacity
                );

                events.add(event);
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error loading events: " + e.getMessage());
        }

        return events;
    }
}