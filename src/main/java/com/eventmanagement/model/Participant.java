
package com.eventmanagement.model;

import java.util.Objects;

public class Participant extends Person {

    private int eventId;

    public Participant() {
        super();
    }

    public Participant(int participantId, String participantName,
                       String email, int eventId) {
        super(participantId, participantName, email);
        this.eventId = eventId;
    }

    public int getParticipantId() {
        return getId();
    }

    public void setParticipantId(int participantId) {
        setId(participantId);
    }

    public String getParticipantName() {
        return getName();
    }

    public void setParticipantName(String participantName) {
        setName(participantName);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String getRole() {
        return "Participant";
    }

    @Override
    public String toString() {
        return super.toString() + "\nEvent ID: " + eventId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Participant)) {
            return false;
        }

        Participant other = (Participant) obj;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
