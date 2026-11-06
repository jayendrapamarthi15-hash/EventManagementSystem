
package com.eventmanagement.util;

class EventTask implements Runnable {

    private String eventName;

    public EventTask(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public void run() {
        System.out.println(
            "Processing event: " + eventName
        );
    }
}

public class ThreadDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(
            new EventTask("Birthday")
        );

        Thread t2 = new Thread(
            new EventTask("Wedding")
        );

        t1.start();
        t2.start();
    }
}
