
package com.eventmanagement.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentMapDemo {

    public static void main(String[] args) {

        Map<String, Integer> registrations =
                new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {
            registrations.put("Birthday", 10);
        });

        Thread t2 = new Thread(() -> {
            registrations.put("Wedding", 20);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted.");
            return;
        }

        System.out.println("Registrations: " + registrations);
    }
}
