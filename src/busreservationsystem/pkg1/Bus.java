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
public class Bus {
    String busNumber;
    int totalSeats;
    String startingPoint;
    String endingPoint;
    String startingTime;
    double fare;
    boolean[] seats;
    Queue<Customer> waitingQueue = new LinkedList<>();

    public Bus(String busNumber, int totalSeats, String startingPoint, String endingPoint, String startingTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.seats = new boolean[totalSeats];
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber='" + busNumber + '\'' +
                ", totalSeats=" + totalSeats +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", fare=" + fare +
                '}';
    }
    
}