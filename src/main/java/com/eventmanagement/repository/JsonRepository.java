package com.eventmanagement.repository;

import java.util.List;

import com.eventmanagement.model.Event;
import com.eventmanagement.model.Participant;
import com.eventmanagement.model.Organizer;
import com.eventmanagement.model.Registration;
import com.eventmanagement.model.Venue;

import com.eventmanagement.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonRepository {

    private static final String EVENT_FILE = "events.json";
    private static final String PARTICIPANT_FILE = "participants.json";
    private static final String ORGANIZER_FILE = "organizers.json";
    private static final String REGISTRATION_FILE = "registrations.json";
    private static final String VENUE_FILE = "venues.json";

    // Save Events
    public void saveEvents(List<Event> events) {
        JsonUtil.saveToJson(events, EVENT_FILE);
    }

    // Load Events
    public List<Event> loadEvents() {
        return JsonUtil.loadListFromJson(
                EVENT_FILE,
                new TypeReference<List<Event>>() {}
        );
    }

    // Save Participants
    public void saveParticipants(List<Participant> participants) {
        JsonUtil.saveToJson(participants, PARTICIPANT_FILE);
    }

    // Load Participants
    public List<Participant> loadParticipants() {
        return JsonUtil.loadListFromJson(
                PARTICIPANT_FILE,
                new TypeReference<List<Participant>>() {}
        );
    }

    // Save Organizers
    public void saveOrganizers(List<Organizer> organizers) {
        JsonUtil.saveToJson(organizers, ORGANIZER_FILE);
    }

    // Load Organizers
    public List<Organizer> loadOrganizers() {
        return JsonUtil.loadListFromJson(
                ORGANIZER_FILE,
                new TypeReference<List<Organizer>>() {}
        );
    }

    // Save Registrations
    public void saveRegistrations(List<Registration> registrations) {
        JsonUtil.saveToJson(registrations, REGISTRATION_FILE);
    }

    // Load Registrations
    public List<Registration> loadRegistrations() {
        return JsonUtil.loadListFromJson(
                REGISTRATION_FILE,
                new TypeReference<List<Registration>>() {}
        );
    }

    // Save Venues
    public void saveVenues(List<Venue> venues) {
        JsonUtil.saveToJson(venues, VENUE_FILE);
    }

    // Load Venues
    public List<Venue> loadVenues() {
        return JsonUtil.loadListFromJson(
                VENUE_FILE,
                new TypeReference<List<Venue>>() {}
        );
    }
}