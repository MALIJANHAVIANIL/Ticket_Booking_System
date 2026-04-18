package Ticket_Booking_System;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BookingService {

	HashMap<Integer, String> bookings = new HashMap<>();
    HashMap<Integer, Integer> seatMap = new HashMap<>(); // ticket → seat
    HashSet<String> users = new HashSet<>(); //to avoid duplicate users
    HashSet<Integer> bookedSeats = new HashSet<>();// to avoid same seat booking

    int ticketCounter = 1; //Auto ticket number generator

    public void bookTicket(String name, int seatNo) {

        if (users.contains(name)) {
            System.out.println("Already Registered!");
            return;
        }

        if (bookedSeats.contains(seatNo)) {
            System.out.println("Seat Already Booked!");
            return;
        }

        bookings.put(ticketCounter, name);
        seatMap.put(ticketCounter, seatNo);

        users.add(name);
        bookedSeats.add(seatNo);

        System.out.println("Booking Successful!");
        System.out.println("Ticket No: " + ticketCounter);
        System.out.println("Seat No: " + seatNo);

        ticketCounter++;
    }

    public void checkByName(String name) {

        if (!users.contains(name)) {
            System.out.println("No Booking Found!");
            return;
        }

        for (Map.Entry<Integer, String> entry : bookings.entrySet()) {
            if (entry.getValue().equals(name)) {
                int seat = seatMap.get(entry.getKey());
                System.out.println("Booking Found!");
                System.out.println("Name: " + name);
                System.out.println("Ticket No: " + entry.getKey());
                System.out.println("Seat No: " + seat);
            }
        }
    }

    public void checkByTicket(int ticketNo) {

        if (bookings.containsKey(ticketNo)) {
            System.out.println("Booking Found!");
            System.out.println("Name: " + bookings.get(ticketNo));
            System.out.println("Seat No: " + seatMap.get(ticketNo));
        } else {
            System.out.println("Invalid Ticket!");
        }
    }
}
