package com.eventmanagement.util;

class EventSeats {

    private int capacity;
    private int registered = 0;

    public EventSeats(int capacity) {
        this.capacity = capacity;
    }

    // Synchronized method prevents overbooking
    public synchronized void register(String name) {

        if (registered < capacity) {

            registered++;

            System.out.println(
                    name + " registered successfully. Seats: "
                    + registered + "/" + capacity
            );

        } else {

            System.out.println(
                    name + " registration failed. Event is full."
            );
        }
    }

    public synchronized int getRegistered() {
        return registered;
    }
}

public class SeatCapacityDemo {

    public static void main(String[] args) {

        // Event has only 2 seats
        EventSeats event = new EventSeats(2);

        // Create three registration threads
        Thread t1 = new Thread(
                () -> event.register("Prasanna")
        );

        Thread t2 = new Thread(
                () -> event.register("Ravi")
        );

        Thread t3 = new Thread(
                () -> event.register("Sita")
        );

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted.");
        }

        System.out.println(
                "Total registered participants: "
                + event.getRegistered()
        );
    }
}