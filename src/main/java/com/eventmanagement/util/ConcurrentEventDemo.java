package com.eventmanagement.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentEventDemo {

    public static void main(String[] args) {

        // Create a thread pool with 2 threads
        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        // Create two Callable tasks
        Callable<Double> event1 = () -> {
            return 100 * 50.0;
        };

        Callable<Double> event2 = () -> {
            return 200 * 30.0;
        };

        try {

            // Submit tasks to ExecutorService
            Future<Double> result1 = executor.submit(event1);
            Future<Double> result2 = executor.submit(event2);

            // Get and display results
            System.out.println("Birthday Event Value: " + result1.get());
            System.out.println("Wedding Event Value: " + result2.get());

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            // Stop the ExecutorService
            executor.shutdown();

        }
    }
}