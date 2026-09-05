package service;

import database.EventDatabase;
import exception.EventNotFoundException;
import java.util.ArrayList;
import model.Event;

public class EventService {

    private ArrayList<Event> events =
            EventDatabase.loadEvents();

    // ADD EVENT
    public void addEvent(Event event) {

        if (event == null) {
            System.out.println("Event cannot be null.");
            return;
        }

        for (Event existingEvent : events) {

            if (existingEvent.getEventId()
                    == event.getEventId()) {

                System.out.println(
                        "Event with ID "
                                + event.getEventId()
                                + " already exists."
                );

                return;
            }
        }

        events.add(event);

        EventDatabase.saveEvents(events);

        System.out.println("Event added successfully!");
    }

    // VIEW ALL EVENTS
    public void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("\n===== ALL EVENTS =====");

        for (Event event : events) {

            event.displayEventInfo();

            System.out.println("----------------------");
        }
    }

    // SEARCH EVENT
    public void searchEvent(int eventId)
            throws EventNotFoundException {

        Event event = getEventById(eventId);

        if (event == null) {

            throw new EventNotFoundException(
                    "Event with ID "
                            + eventId
                            + " not found."
            );
        }

        System.out.println("\n===== EVENT FOUND =====");

        event.displayEventInfo();
    }

    // GET EVENT BY ID
    public Event getEventById(int eventId) {

        for (Event event : events) {

            if (event.getEventId() == eventId) {
                return event;
            }
        }

        return null;
    }

    // UPDATE EVENT
    public void updateEvent(
            int eventId,
            String newVenue,
            int newCapacity)
            throws EventNotFoundException {

        Event event = getEventById(eventId);

        if (event == null) {

            throw new EventNotFoundException(
                    "Event with ID "
                            + eventId
                            + " not found."
            );
        }

        event.setVenue(newVenue);
        event.setCapacity(newCapacity);

        EventDatabase.saveEvents(events);

        System.out.println("Event updated successfully!");
    }

    // DELETE EVENT
    public void deleteEvent(int eventId)
            throws EventNotFoundException {

        Event event = getEventById(eventId);

        if (event == null) {

            throw new EventNotFoundException(
                    "Event with ID "
                            + eventId
                            + " not found."
            );
        }

        events.remove(event);

        EventDatabase.saveEvents(events);

        System.out.println("Event deleted successfully!");
    }
}