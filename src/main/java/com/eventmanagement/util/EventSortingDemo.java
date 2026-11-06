package com.eventmanagement.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.eventmanagement.model.Event;

public class EventSortingDemo {

    public static void main(String[] args) {

        List<Event> events = new ArrayList<>();

        events.add(new Event(103, "Conference", "2026-11-10",
                "Vijayawada", 500, 100));

        events.add(new Event(101, "Wedding", "2026-11-05",
                "Hyderabad", 1000, 200));

        events.add(new Event(102, "Birthday", "2026-11-08",
                "Guntur", 300, 50));

        // Comparable: Sort by Event ID
        Collections.sort(events);

        System.out.println("Events sorted by ID:");

        for (Event event : events) {
            System.out.println(event);
            System.out.println("----------------");
        }

        // Comparator: Sort by Event Name
        Collections.sort(
                events,
                Comparator.comparing(Event::getEventName)
        );

        System.out.println("Events sorted by Name:");

        for (Event event : events) {
            System.out.println(event);
            System.out.println("----------------");
        }
    }
}