package com.example;

import com.example.exception.ActivityException;
import com.example.exception.SignUpForActivityException;
import com.example.exception.TravelPackageAddPassengerException;

import java.util.ArrayList;

/**
 * Application to demonstrate the functionality of the travel package system.
 * @author  Apoorva Kaushal
 */
public class TravelPackageAgencyApplication {
    public static void main(String args[]) {
        try {
            runTravelPackageApplication();
        } catch (ActivityException | TravelPackageAddPassengerException | SignUpForActivityException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes the main functionality of the travel package application.
     *
     * @throws ActivityException                 If there is an issue with activities.
     * @throws TravelPackageAddPassengerException If there is an issue with adding passengers to the travel package.
     * @throws SignUpForActivityException         If there is an issue with signing up for an activity.
     */
    private static void runTravelPackageApplication() throws ActivityException, TravelPackageAddPassengerException, SignUpForActivityException {

        TravelPackage travelPackage = new TravelPackage("International Tour Package", 8);

        Destination rajasthanDestination = new Destination("Rajasthan", new ArrayList<Activity>());
        Destination dubaiDestination = new Destination("Dubai", new ArrayList<Activity>());
        Destination canadaDestination= new Destination("Ontario, Canada", new ArrayList<Activity>());


        Activity sightSeeingActivity = new Activity("Sight Seeing", "This activity allows passengers to explore the destination", 250.0, 13, null);
        Activity shoppingActivity = new Activity("Shopping", "Purchase from Several unique shops in Burj Khalifa", 50.0, 10, null);
        Activity photographyActivity = new Activity("Photography", "Get several cool pictures clicked inside Burj Khalifa", 3000.0, 2, null);
        Activity horseRidingActivity = new Activity("Horse Riding", "This activity allows passengers to do horse riding", 150.0, 4, null);
        Activity snowMazeActivity = new Activity("Snow Maze", "This activity allows passengers to play snow maze", 300.0, 5, null);
        Activity skyDivingActivity = new Activity("Sky Diving ", "This activity allows passengers to do sky diving", 50.0, 5, null);

        rajasthanDestination.addActivity(sightSeeingActivity);
        rajasthanDestination.addActivity(horseRidingActivity);
        dubaiDestination.addActivity(shoppingActivity);
        dubaiDestination.addActivity(photographyActivity);
        dubaiDestination.addActivity(skyDivingActivity);
        canadaDestination.addActivity(snowMazeActivity);

        travelPackage.addDestination(rajasthanDestination);
        travelPackage.addDestination(dubaiDestination);
        travelPackage.addDestination(canadaDestination);

        Passenger passenger1 = new Passenger("Apoorva Kaushal", 100.0, PassengerType.GOLD);
        Passenger passenger2 = new Passenger("Kritima Kaushal", 200.0, PassengerType.PREMIUM);
        Passenger passenger3 = new Passenger("Adhyan Kaushal", 300.0, PassengerType.STANDARD);
        Passenger passenger4 = new Passenger("Vedant Kaushal", 400.0, PassengerType.STANDARD);
        Passenger passenger5 = new Passenger("Chhaya Kaushal", 500.0, PassengerType.GOLD);
        Passenger passenger6 = new Passenger("Vinod Kaushal", 600.0, PassengerType.PREMIUM);
        Passenger passenger7 = new Passenger("Mansi Kaushal", 800.0, PassengerType.GOLD);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);
        travelPackage.addPassenger(passenger4);
        travelPackage.addPassenger(passenger5);
        travelPackage.addPassenger(passenger6);
        travelPackage.addPassenger(passenger7);

        passenger1.signUpForActivity(shoppingActivity);
        passenger2.signUpForActivity(horseRidingActivity);
        passenger3.signUpForActivity(sightSeeingActivity);
        passenger4.signUpForActivity(snowMazeActivity);
        passenger5.signUpForActivity(skyDivingActivity);
        passenger6.signUpForActivity(photographyActivity);
        passenger7.signUpForActivity(sightSeeingActivity);

        System.out.println("Task 1 : Print itinerary of the travel package : ");
        travelPackage.printItinerary();
        System.out.println("           ------------------------           ");

        System.out.println("Task 2 : Print the passenger list of the travel package : ");
        travelPackage.printPassengerList();
        System.out.println("           ------------------------           ");

        System.out.println("Task 3 : Print the details of an individual passenger : ");
        for(Passenger passenger : travelPackage.getPassengers()){
            passenger.printDetails();
            System.out.println("           ------------------------           ");
        }

        System.out.println("Task 4 : Print the details of all the activities that still have spaces available, including how many spaces are available : ");
        travelPackage.printAllAvailableActivities();
        System.out.println("           ------------------------           ");

    }
}
