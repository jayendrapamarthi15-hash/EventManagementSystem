package com.eventmanagement.model;

import java.util.Objects;

public class Event implements Comparable<Event> {

    private int eventId;
    private String eventName;
    private String eventDate;
    private String location;
    private double ticketPrice;
    private int capacity;

    // Default constructor
    public Event() {
    }

    // Parameterized constructor
    public Event(int eventId, String eventName, String eventDate,
                 String location, double ticketPrice, int capacity) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.ticketPrice = ticketPrice;
        this.capacity = capacity;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Comparable: Sort events by Event ID
    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.eventId, other.eventId);
    }

    // Display event details
    @Override
    public String toString() {
        return "Event ID: " + eventId
                + "\nEvent Name: " + eventName
                + "\nEvent Date: " + eventDate
                + "\nLocation: " + location
                + "\nTicket Price: " + ticketPrice
                + "\nCapacity: " + capacity;
    }

    // Compare two events using Event ID
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Event)) {
            return false;
        }

        Event other = (Event) obj;
        return eventId == other.eventId;
    }

    // Generate hash code using Event ID
    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}
