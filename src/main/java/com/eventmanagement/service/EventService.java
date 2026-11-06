package com.eventmanagement.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.eventmanagement.model.Event;
import com.eventmanagement.model.Participant;
import com.eventmanagement.repository.JsonRepository;

public class EventService {

    private final JsonRepository repository = new JsonRepository();

    private final List<Event> events;
    private final List<Participant> participants;

    // Constructor: Load existing data from JSON files
    public EventService() {
        events = new ArrayList<>(repository.loadEvents());
        participants = new ArrayList<>(repository.loadParticipants());
    }

    // Add Event
    public synchronized void addEvent(Event event) {

        if (event == null) {
            System.out.println("Invalid event details.");
            return;
        }

        if (findEvent(event.getEventId()) != null) {
            System.out.println("Event ID already exists!");
            return;
        }

        events.add(event);

        events.sort(Comparator.comparingInt(Event::getEventId));

        repository.saveEvents(events);

        System.out.println("Event added successfully!");
    }

    // View Events
    public synchronized void viewEvents() {

        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        for (Event event : events) {

            int registeredCount =
                    getRegistrationCount(event.getEventId());

            int availableSeats =
                    event.getCapacity() - registeredCount;

            System.out.println("--------------------");
            System.out.println(event);

            System.out.println("Total Capacity: " + event.getCapacity());

            System.out.println(
                    "Registered Participants: " + registeredCount);

            System.out.println("Available Seats: " + availableSeats);
        }
    }

    // Register Participant
    public synchronized void registerParticipant(Participant participant) {

        if (participant == null) {
            System.out.println("Invalid participant details.");
            return;
        }

        Event selectedEvent = findEvent(participant.getEventId());

        if (selectedEvent == null) {
            System.out.println("Event not found.");
            return;
        }

        if (findParticipant(participant.getParticipantId()) != null) {
            System.out.println("Participant ID already exists!");
            return;
        }

        if (selectedEvent.getCapacity() <= 0) {
            System.out.println("Event capacity is not set.");
            return;
        }

        int registeredCount =
                getRegistrationCount(participant.getEventId());

        if (registeredCount >= selectedEvent.getCapacity()) {
            System.out.println("Sorry, event is full.");
            return;
        }

        participants.add(participant);

        repository.saveParticipants(participants);

        System.out.println("Participant registered successfully!");
    }

    // View Participants
    public synchronized void viewParticipants() {

        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
            return;
        }

        for (Participant participant : participants) {

            System.out.println("--------------------");
            System.out.println(participant);
        }
    }

    // Search Event By ID
    public synchronized void searchEvent(int eventId) {

        Event event = findEvent(eventId);

        if (event == null) {
            System.out.println("Event not found.");
        } else {
            System.out.println(event);
        }
    }

    // Update Event
    public synchronized void updateEvent(
            int eventId,
            String name,
            String date,
            String location,
            double price,
            int capacity) {

        Event event = findEvent(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        if (capacity <= 0 || price < 0
                || name == null || name.isBlank()
                || date == null || date.isBlank()
                || location == null || location.isBlank()) {

            System.out.println("Enter valid event details.");
            return;
        }

        if (capacity < getRegistrationCount(eventId)) {
            System.out.println(
                    "Capacity cannot be less than registered participants.");
            return;
        }

        event.setEventName(name);
        event.setEventDate(date);
        event.setLocation(location);
        event.setTicketPrice(price);
        event.setCapacity(capacity);

        repository.saveEvents(events);

        System.out.println("Event updated successfully!");
    }

    // Delete Event
    public synchronized void deleteEvent(int eventId) {

        Event event = findEvent(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        events.remove(event);

        participants.removeIf(
                p -> p.getEventId() == eventId);

        repository.saveEvents(events);
        repository.saveParticipants(participants);

        System.out.println("Event and its registrations deleted.");
    }

    // Cancel Registration
    public synchronized void cancelRegistration(int participantId) {

        Participant participant = findParticipant(participantId);

        if (participant == null) {
            System.out.println("Registration not found.");
            return;
        }

        participants.remove(participant);

        repository.saveParticipants(participants);

        System.out.println("Registration cancelled successfully!");
    }

    // Get All Events
    public synchronized List<Event> getAllEvents() {

        return new ArrayList<>(events);
    }

    // Find Event
    private Event findEvent(int eventId) {

        for (Event event : events) {

            if (event.getEventId() == eventId) {
                return event;
            }
        }

        return null;
    }

    // Find Participant
    private Participant findParticipant(int participantId) {

        for (Participant participant : participants) {

            if (participant.getParticipantId() == participantId) {
                return participant;
            }
        }

        return null;
    }

    // Sort Events By ID using Comparable
    public synchronized List<Event> getEventsSortedById() {

        List<Event> sortedEvents = new ArrayList<>(events);

        Collections.sort(sortedEvents);

        return sortedEvents;
    }

    // Search Events By Name
    public synchronized List<Event> searchEventsByName(String name) {

        List<Event> result = new ArrayList<>();

        if (name == null || name.isBlank()) {
            return result;
        }

        String searchText = name.toLowerCase(Locale.ROOT);

        for (Event event : events) {

            if (event.getEventName() != null
                    && event.getEventName()
                            .toLowerCase(Locale.ROOT)
                            .contains(searchText)) {

                result.add(event);
            }
        }

        return result;
    }

    // Search Participants By Name
    public synchronized List<Participant> searchParticipantsByName(
            String name) {

        List<Participant> result = new ArrayList<>();

        if (name == null || name.isBlank()) {
            return result;
        }

        String searchText = name.toLowerCase(Locale.ROOT);

        for (Participant participant : participants) {

            if (participant.getParticipantName() != null
                    && participant.getParticipantName()
                            .toLowerCase(Locale.ROOT)
                            .contains(searchText)) {

                result.add(participant);
            }
        }

        return result;
    }

    // Sort Events By Name using Comparator
    public synchronized List<Event> getEventsSortedByName() {

        List<Event> sortedEvents = new ArrayList<>(events);

        sortedEvents.sort(
                Comparator.comparing(
                        Event::getEventName,
                        Comparator.nullsLast(
                                String.CASE_INSENSITIVE_ORDER)
                )
        );

        return sortedEvents;
    }

    // Count Registered Participants
    public synchronized int getRegistrationCount(int eventId) {

        int count = 0;

        for (Participant participant : participants) {

            if (participant.getEventId() == eventId) {
                count++;
            }
        }

        return count;
    }
}