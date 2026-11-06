
package com.eventmanagement.main;

import java.util.Scanner;
import java.util.List;

import com.eventmanagement.model.Event;
import com.eventmanagement.model.Participant;
import com.eventmanagement.service.EventService;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final EventService service = new EventService();

    // Read integer safely
    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Read double safely
    public static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== EVENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Participant");
            System.out.println("4. View Participants");
            System.out.println("5. Search Event");
            System.out.println("6. Update Event");
            System.out.println("7. Delete Event");
            System.out.println("8. Cancel Registration");
            System.out.println("9. Search Event By Name");
            System.out.println("10. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                // Add Event
                case 1: {
                    int id = readInt("Enter event ID: ");

                    System.out.print("Enter event name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter event date: ");
                    String date = sc.nextLine();

                    System.out.print("Enter location: ");
                    String location = sc.nextLine();

                    double price = readDouble("Enter ticket price: ");

                    int capacity = readInt("Enter event capacity: ");

                    if (id <= 0 || price < 0 || capacity <= 0
                            || name.trim().isEmpty()
                            || date.trim().isEmpty()
                            || location.trim().isEmpty()) {

                        System.out.println("Enter valid event details.");
                        break;
                    }

                    Event event = new Event(
                            id, name, date, location, price, capacity);

                    service.addEvent(event);

                    break;
                }

                // View Events
                case 2: {
                    service.viewEvents();
                    break;
                }

                // Register Participant
                case 3: {
                    int participantId =
                            readInt("Enter participant ID: ");

                    System.out.print("Enter participant name: ");
                    String participantName = sc.nextLine();

                    System.out.print("Enter participant email: ");
                    String email = sc.nextLine();

                    int eventId = readInt("Enter event ID: ");

                    if (participantId <= 0 || eventId <= 0
                            || participantName.trim().isEmpty()
                            || email.trim().isEmpty()
                            || !email.contains("@")) {

                        System.out.println(
                                "Enter valid participant details.");
                        break;
                    }

                    Participant participant = new Participant(
                            participantId, participantName,
                            email, eventId);

                    service.registerParticipant(participant);

                    break;
                }

                // View Participants
                case 4: {
                    service.viewParticipants();
                    break;
                }

                // Search Event By ID
                case 5: {
                    int searchId =
                            readInt("Enter event ID to search: ");

                    service.searchEvent(searchId);

                    break;
                }

                // Update Event
                case 6: {
                    int updateId =
                            readInt("Enter event ID to update: ");

                    System.out.print("Enter new event name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new event date: ");
                    String newDate = sc.nextLine();

                    System.out.print("Enter new location: ");
                    String newLocation = sc.nextLine();

                    double newPrice =
                            readDouble("Enter new ticket price: ");

                    int newCapacity =
                            readInt("Enter new event capacity: ");

                    if (newPrice < 0 || newCapacity <= 0
                            || newName.trim().isEmpty()
                            || newDate.trim().isEmpty()
                            || newLocation.trim().isEmpty()) {

                        System.out.println("Enter valid event details.");
                        break;
                    }

                    service.updateEvent(
                            updateId, newName, newDate,
                            newLocation, newPrice, newCapacity);

                    break;
                }

                // Delete Event
                case 7: {
                    int deleteId =
                            readInt("Enter event ID to delete: ");

                    service.deleteEvent(deleteId);

                    break;
                }

                // Cancel Registration
                case 8: {
                    int cancelId = readInt(
                            "Enter participant ID to cancel registration: ");

                    service.cancelRegistration(cancelId);

                    break;
                }

                // Search Event By Name
                case 9: {
                    System.out.print("Enter event name to search: ");

                    String searchName = sc.nextLine();

                    if (searchName.trim().isEmpty()) {
                        System.out.println(
                                "Please enter an event name.");
                        break;
                    }

                    List<Event> searchResults =
                            service.searchEventsByName(searchName);

                    if (searchResults.isEmpty()) {

                        System.out.println(
                                "No matching events found.");

                    } else {

                        for (Event e : searchResults) {
                            System.out.println("--------------------");
                            System.out.println(e);
                        }
                    }

                    break;
                }

                // Exit
                case 10: {
                    System.out.println(
                            "Thank you for using Event Management System!");
                    break;
                }

                default: {
                    System.out.println(
                            "Invalid choice. Please try again.");
                }
            }

        } while (choice != 10);

        sc.close();
    }
}
