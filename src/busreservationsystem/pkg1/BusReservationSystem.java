/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package busreservationsystem.pkg1;

/**
 *
 * @author user
 */
import java.util.*;
public class BusReservationSystem {
    private List<Customer> customers = new ArrayList<>();
    private List<Bus> buses = new ArrayList<>();
    private Map<String, Map<Integer, Customer>> reservations = new HashMap<>();

    public void registerCustomer(String name, String mobileNumber, String email, String city, int age) {
        Customer customer = new Customer(name, mobileNumber, email, city, age);
        customers.add(customer);
        System.out.println("Customer registered successfully!");
    }

    public void addBus(String busNumber, int totalSeats, String startingPoint, String endingPoint, String startingTime, double fare) {
        Bus bus = new Bus(busNumber, totalSeats, startingPoint, endingPoint, startingTime, fare);
        buses.add(bus);
        reservations.put(busNumber, new HashMap<>());
        System.out.println("Bus added successfully!");
    }

    public void searchBuses(String startingPoint, String endingPoint) {
        System.out.println("Available Buses:");
        for (Bus bus : buses) {
            if (bus.startingPoint.equalsIgnoreCase(startingPoint) && bus.endingPoint.equalsIgnoreCase(endingPoint)) {
                System.out.println(bus);
            }
        }
    }

    public void reserveSeat(String busNumber, String customerName) {
        for (Bus bus : buses) {
            if (bus.busNumber.equals(busNumber)) {
                for (int i = 0; i < bus.totalSeats; i++) {
                    if (!bus.seats[i]) {
                        bus.seats[i] = true;
                        for (Customer customer : customers) {
                            if (customer.name.equalsIgnoreCase(customerName)) {
                                reservations.get(busNumber).put(i, customer);
                                System.out.println("Seat reserved for: " + customer);
                                return;
                            }
                        }
                    }
                }
                System.out.println("No seats available! Adding customer to the waiting queue.");
                for (Customer customer : customers) {
                    if (customer.name.equalsIgnoreCase(customerName)) {
                        bus.waitingQueue.add(customer);
                        System.out.println("Customer added to waiting queue: " + customer);
                        return;
                    }
                }
                return;
            }
        }
        System.out.println("Bus not found!");
    }

    public void cancelReservation(String busNumber, int seatIndex) {
        for (Bus bus : buses) {
            if (bus.busNumber.equals(busNumber)) {
                if (bus.seats[seatIndex]) {
                    bus.seats[seatIndex] = false;
                    Customer canceledCustomer = reservations.get(busNumber).remove(seatIndex);
                    System.out.println("Reservation canceled for: " + canceledCustomer);

                    if (!bus.waitingQueue.isEmpty()) {
                        Customer nextCustomer = bus.waitingQueue.poll();
                        bus.seats[seatIndex] = true;
                        reservations.get(busNumber).put(seatIndex, nextCustomer);
                        System.out.println("Seat allocated to next customer in queue: " + nextCustomer);
                    }
                    return;
                } else {
                    System.out.println("Seat is not reserved.");
                }
            }
        }
    }

    public void showReservations() {
        System.out.println("Seat Reservation Details:");
        for (Map.Entry<String, Map<Integer, Customer>> entry : reservations.entrySet()) {
            System.out.println("Bus Number: " + entry.getKey());
            for (Map.Entry<Integer, Customer> seat : entry.getValue().entrySet()) {
                System.out.println("Seat: " + (seat.getKey() + 1) + " | Customer: " + seat.getValue());
            }
        }
    }

    public void displayCustomersNewestToOldest() {
        List<Customer> reversedCustomers = new ArrayList<>(customers);
        Collections.reverse(reversedCustomers);
        System.out.println("Customers (Newest to Oldest):");
        for (Customer customer : reversedCustomers) {
            System.out.println(customer);
        }
    }
    
}
