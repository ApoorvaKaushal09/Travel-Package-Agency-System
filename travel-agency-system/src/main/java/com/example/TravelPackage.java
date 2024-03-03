package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.exception.TravelPackageAddPassengerException;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a travel package offered by a travel agency.
 * Each travel package has a name, passenger capacity, itinerary (list of destinations),
 * and a list of enrolled passengers.
 *
 * @see Destination
 * @see Passenger
 */
@Getter
@Setter
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    /**
     * Creates a new TravelPackage with the specified parameters.
     *
     * @param name             The name of the travel package.
     * @param passengerCapacity The maximum capacity of passengers for the travel package.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<Destination>();
        this.passengers = new ArrayList<Passenger>();
    }

    /**
     * Adds a destination to the travel package's itinerary.
     *
     * @param destination The destination to be added.
     * @throws NullPointerException If the destination is null.
     */
    public void addDestination(Destination destination) {
        if(destination == null)
            throw new NullPointerException();
        itinerary.add(destination);
    }

    /**
     * Adds a passenger to the travel package.
     *
     * @param passenger The passenger to be added.
     * @throws TravelPackageAddPassengerException If the travel package is full and cannot enroll more passengers.
     */
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            throw new TravelPackageAddPassengerException("Sorry, the travel package is full. Cannot add more passengers.");
        }
    }

    /**
     * Prints the itinerary of the travel package, including destinations and available activities.
     */
    public void printItinerary() {
        System.out.println("Travel Package Itinerary:");
        System.out.println("Package Name: " + name);
        for (Destination destination : itinerary) {
            System.out.println("- Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("  - Activity: " + activity.getName() + ", Capacity: " + activity.getCapacity() +
                        ", Description: " + activity.getDescription() +
                        ", Cost: $" + activity.getCost() + ")");
                        // TODO: Add activity capacity and desc
            }
        }
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Passenger List for " + name + " (Capacity: " + passengerCapacity + "):");
        System.out.println("Number of passengers enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("- Passenger: " + passenger.getName() +
                    " (Passenger Number : " + passenger.getPassengerNumber() + ")" + " available balance: " + passenger.getBalance());
        }
    }

    /**
     * Prints details of all available activities in the travel package's itinerary.
     */
    public void printAllAvailableActivities() {
        for(Destination destination : itinerary) {
            System.out.println("Destination " + destination.getName() + " has the following available activities : ");
            destination.printAvailableActivities(destination.getActivities());
        }
    }
}
