package Ticket_Booking_System;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingService service = new BookingService();

        while (true) {
            System.out.println("\n1.Book Ticket  2.Check Status  3.Exit");
            System.out.print("Enter Choice: ");

            if (!sc.hasNextInt()) {   // input validation
                System.out.println("Enter number only!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Seat No: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid Seat!");
                        sc.nextLine();
                        continue;
                    }

                    int seatNo = sc.nextInt();
                    service.bookTicket(name, seatNo);
                }

                case 2 -> {
                    String input = sc.nextLine(); // no message shown

                    if (input.matches("\\d+")) {
                        service.checkByTicket(Integer.parseInt(input));
                    } else {
                        service.checkByName(input);
                    }
                }

                case 3 -> {
                    System.out.println("Thank You!");
                    return;
                }

                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
