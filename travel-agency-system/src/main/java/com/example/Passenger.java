package com.example;

import java.util.*;

import com.example.exception.SignUpForActivityException;
import com.example.exception.ActivityException;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a passenger in the travel system.
 * Each passenger has a name, a unique passenger number, a balance, a list of activities signed up for,
 * and a passenger type.
 * @see PassengerType
 * @see Activity
 */
@Getter
@Setter
public class Passenger {
    private String name;
    private String passengerNumber;
    private double balance;
    private List<Activity> activities;
    private PassengerType passengerType;

    /**
     * Creates a new Passenger with the specified parameters.
     *
     * @param name          The name of the passenger.
     * @param balance       The initial balance of the passenger.
     * @param passengerType The type of the passenger.
     */
    public Passenger(String name, double balance, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = UUID.randomUUID().toString();
        this.balance = balance;
        this.activities = new ArrayList<Activity>();
        this.passengerType = passengerType;
    }

    /**
     * Signs up the passenger for a given activity.
     *
     * @param activity The activity to sign up for.
     * @throws SignUpForActivityException          If the activity is already full, has zero capacity, or if the passenger has insufficient balance.
     * @throws SignUpForActivityException If there is an issue with signing up for the activity.
     */
    public void signUpForActivity(Activity activity) throws ActivityException {
        // Check if the activity is already full
        if (activity.getRemainingCapacity() <= 0) {
            throw new SignUpForActivityException("Activity is already full or has zero capacity. Cannot enroll more passengers.");
        }

        // Check if the passenger has sufficient balance
        double cost = calculateCost(activity);
        if (balance < cost) {
            throw new SignUpForActivityException("Insufficient balance. Cannot sign up for the activity.");
        }

        // Deduct the cost from the balance and add the activity to the list
        balance -= cost;
        activities.add(activity);
        activity.incrementEnrollment();

        System.out.println(name + " signed up for activity: " + activity.getName() +
                " at destination: " + activity.getDestination().getName() +
                " for a cost of: $" + cost);
    }

    /**
     * Calculates the cost of signing up for a given activity based on the passenger type.
     *
     * @param activity The activity for which to calculate the cost.
     * @return The cost of signing up for the activity.
     * @throws IllegalArgumentException If the passenger type is invalid.
     */
    public double calculateCost(Activity activity) {
        switch (passengerType) {
            case STANDARD:
                return activity.getCost();
            case GOLD:
                return 0.9 * activity.getCost(); // 10% discount for gold passengers
            case PREMIUM:
                return 0.0; // Premium passengers sign up for free
            default:
                throw new IllegalArgumentException("Invalid passenger type: " + passengerType);
        }
    }

    /**
     * Prints details of the passenger, including name, passenger number, balance, and signed-up activities.
     */
    public void printDetails() {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + name);
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Activities:");
        for (Activity activity : activities) {
            System.out.println("- " + activity.getName() + " at Destination : " + activity.getDestination().getName() +
                    " (Price Paid: $" + calculateCost(activity) + ")");
        }
    }
}
