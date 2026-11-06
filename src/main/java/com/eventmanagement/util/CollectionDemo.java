
package com.eventmanagement.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {

    public static void main(String[] args) {

        // List allows duplicate values
        List<String> events = new ArrayList<>();
        events.add("Birthday");
        events.add("Wedding");
        events.add("Birthday");

        System.out.println("List: " + events);

        // Set stores unique values
        Set<String> uniqueEvents = new HashSet<>(events);
        System.out.println("Set: " + uniqueEvents);

        // HashMap stores key-value pairs
        Map<Integer, String> eventMap = new HashMap<>();
        eventMap.put(101, "Birthday");
        eventMap.put(102, "Wedding");

        System.out.println("HashMap: " + eventMap);
    }
}
