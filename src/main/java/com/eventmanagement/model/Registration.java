
package com.eventmanagement.model;

import java.util.Objects;

public class Registration {
    private int registrationId;
    private int participantId;
    private int eventId;
    private String registrationDate;
    private String status;

    public Registration() {
    }

    public Registration(int registrationId, int participantId,
                        int eventId, String registrationDate,
                        String status) {
        this.registrationId = registrationId;
        this.participantId = participantId;
        this.eventId = eventId;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Registration ID: " + registrationId
                + "\nParticipant ID: " + participantId
                + "\nEvent ID: " + eventId
                + "\nRegistration Date: " + registrationDate
                + "\nStatus: " + status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Registration)) return false;
        Registration other = (Registration) obj;
        return registrationId == other.registrationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId);
    }
}
