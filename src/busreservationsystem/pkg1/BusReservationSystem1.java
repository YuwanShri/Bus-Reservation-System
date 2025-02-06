/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busreservationsystem.pkg1;

import java.util.*;
public class BusReservationSystem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusReservationSystem system = new BusReservationSystem();

        while (true) {
            System.out.println("\n--- Bus Reservation System ---");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Bus");
            System.out.println("3. Search Buses");
            System.out.println("4. Reserve Seat");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Show Reservations");
            System.out.println("7. Display Customers (Newest to Oldest)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    String mobileNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    system.registerCustomer(name, mobileNumber, email, city, age);
                    break;
                case 2:
                    System.out.print("Enter Bus Number: ");
                    String busNumber = scanner.nextLine();
                    System.out.print("Enter Total Seats: ");
                    int totalSeats = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Starting Point: ");
                    String startingPoint = scanner.nextLine();
                    System.out.print("Enter Ending Point: ");
                    String endingPoint = scanner.nextLine();
                    System.out.print("Enter Starting Time: ");
                    String startingTime = scanner.nextLine();
                    System.out.print("Enter Fare: ");
                    double fare = scanner.nextDouble();
                    system.addBus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
                    break;
                case 3:
                    System.out.print("Enter Starting Point: ");
                    String sp = scanner.nextLine();
                    System.out.print("Enter Ending Point: ");
                    String ep = scanner.nextLine();
                    system.searchBuses(sp, ep);
                    break;
                case 4:
                    System.out.print("Enter Bus Number: ");
                    String reserveBusNumber = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String reserveCustomerName = scanner.nextLine();
                    system.reserveSeat(reserveBusNumber, reserveCustomerName);
                    break;
                case 5:
                    System.out.print("Enter Bus Number: ");
                    String cancelBusNumber = scanner.nextLine();
                    System.out.print("Enter Seat Index (0-based): ");
                    int seatIndex = scanner.nextInt();
                    system.cancelReservation(cancelBusNumber, seatIndex);
                    break;
                case 6:
                    system.showReservations();
                    break;
                case 7:
                    system.displayCustomersNewestToOldest();
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    
    }
    
}
