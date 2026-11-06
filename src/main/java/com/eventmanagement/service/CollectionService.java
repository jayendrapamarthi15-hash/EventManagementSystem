
package com.eventmanagement.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eventmanagement.model.Event;

public class CollectionService {

    public Map<Integer, Event> createEventMap(List<Event> events) {
        Map<Integer, Event> eventMap = new HashMap<>();

        for (Event event : events) {
            eventMap.put(event.getEventId(), event);
        }

        return eventMap;
    }

    public Set<Integer> getUniqueEventIds(List<Event> events) {
        Set<Integer> eventIds = new HashSet<>();

        for (Event event : events) {
            eventIds.add(event.getEventId());
        }

        return eventIds;
    }
}
