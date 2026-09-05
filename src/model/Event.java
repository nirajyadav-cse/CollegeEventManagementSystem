package model;

public class Event {

    private int eventId;
    private String eventName;
    private String date;
    private String venue;
    private String category;
    private int capacity;

    // Constructor
    public Event(int eventId, String eventName, String date,
                 String venue, String category, int capacity) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
        this.category = category;
        this.capacity = capacity;
    }

    // Getters
    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }
// Setters
public void setEventName(String eventName) {
    this.eventName = eventName;
}

public void setDate(String date) {
    this.date = date;
}

public void setVenue(String venue) {
    this.venue = venue;
}

public void setCategory(String category) {
    this.category = category;
}

public void setCapacity(int capacity) {
    this.capacity = capacity;
}
    // Display event information
    public void displayEventInfo() {

        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
        System.out.println("Category: " + category);
        System.out.println("Capacity: " + capacity);
    }
}