
package com.eventmanagement.model;

import java.util.Objects;

public class Venue {
    private int venueId;
    private String venueName;
    private String address;
    private int capacity;

    public Venue() {
    }

    public Venue(int venueId, String venueName,
                 String address, int capacity) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.address = address;
        this.capacity = capacity;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Venue ID: " + venueId
                + "\nVenue Name: " + venueName
                + "\nAddress: " + address
                + "\nCapacity: " + capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Venue)) return false;
        Venue other = (Venue) obj;
        return venueId == other.venueId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueId);
    }
}
