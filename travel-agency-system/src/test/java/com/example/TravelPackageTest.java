package com.example;

import com.example.exception.TravelPackageAddPassengerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class TravelPackageTest {

    public static TravelPackage travelPackage;
    public static Destination destination;


    @BeforeAll
    public static void setup() {
        travelPackage = new TravelPackage("Test Travel Package", 2);
        destination = new Destination("Goa, India", new ArrayList<Activity>());
    }


    @Test
    void travelPackageAddDestinationSuccessTest() {
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getItinerary().size());
        assertEquals(destination, travelPackage.getItinerary().get(0));
    }
    @Test
    void travelPackageAddDestinationFailureTest() {
        assertThrows(NullPointerException.class, () -> {travelPackage.addDestination(null);});
    }

    @Test
    void travelPackageAddPassengerSuccessTest() {
        Passenger passenger = getPassenger();
        travelPackage.addPassenger(passenger);
        assertEquals(1, travelPackage.getPassengers().size());
        assertEquals(passenger, travelPackage.getPassengers().get(0));
    }

    @Test
    void travelPackageAddPassengerFailureTest() {
        travelPackage = new TravelPackage("Test Travel Package", 2);
        travelPackage.addPassenger(getPassenger());
        travelPackage.addPassenger(getPassenger());
        assertThrows(TravelPackageAddPassengerException.class, () -> {
            travelPackage.addPassenger(getPassenger());
        });
    }

//    @Test
//    void travelPackageCreationAndPassengerAddition() {
//
//        assertEquals("Test Travel Package", travelPackage.getName());
//        assertEquals(5, travelPackage.getPassengerCapacity());
//        assertNotNull(travelPackage.getItinerary());
//        assertTrue(travelPackage.getItinerary().isEmpty());
//        assertNotNull(travelPackage.getPassengers());
//        assertTrue(travelPackage.getPassengers().isEmpty());
//
//        Activity activity = new Activity("Sky diving Activity", "This activity allows passengers to do sky diving", 50.0, 10, destination);
//        destination.addActivity(activity);
//
//        travelPackage.addDestination(destination);
//
//        assertFalse(travelPackage.getItinerary().isEmpty());
//        assertEquals("Goa, India", travelPackage.getItinerary().get(0).getName());
//
//        Passenger passenger = new Passenger("Apoorva Kaushal", 100.0, PassengerType.STANDARD);
//        travelPackage.addPassenger(passenger);
//
//        assertFalse(travelPackage.getPassengers().isEmpty());
//        assertEquals("Apoorva Kaushal", travelPackage.getPassengers().get(0).getName());
//    }
//
//    @Test
//    void printTravelPackageItenary() {
//        TravelPackage travelPackage = new TravelPackage("Travel Package", 5);
//
//        Destination rajasthanDestination = new Destination("Rajasthan", new ArrayList<Activity>());
//        Activity sightSeeingActivity = new Activity("Sight Seeing", "This activity allows passengers to explore the destination", 250.0, 5, rajasthanDestination);
//        rajasthanDestination.addActivity(sightSeeingActivity);
//
//        Activity horseRidingActivity = new Activity("Horse Riding", "This activity allows passengers to do horse riding", 50.0, 10, rajasthanDestination);
//        rajasthanDestination.addActivity(horseRidingActivity);
//
//        Destination dubaiDestination = new Destination("Dubai", new ArrayList<Activity>());
//
//        Activity skyDivingActivity = new Activity("Sky Diving ", "This activity allows passengers to do sky diving", 150.0, 15, dubaiDestination);
//        dubaiDestination.addActivity(skyDivingActivity);
//
//        travelPackage.addDestination(rajasthanDestination);
//        travelPackage.addDestination(dubaiDestination);
//
//
//        Passenger passenger = new Passenger("Apoorva Kaushal", 100.0, PassengerType.STANDARD);
//        travelPackage.addPassenger(passenger);
//
//        assertThrows(RuntimeException.class, () -> { passenger.signUpForActivity(skyDivingActivity);});
//
//        travelPackage.printItinerary();
//    }
//
//    @Test
//    void printAllAvailableActivities() {
//        TravelPackage travelPackage = new TravelPackage("Travel Package", 5);
//
//        Destination rajasthanDestination = new Destination("Rajasthan", new ArrayList<Activity>());
//        Activity sightSeeingActivity = new Activity("Sight Seeing", "This activity allows passengers to explore the destination", 250.0, 13, rajasthanDestination);
//        rajasthanDestination.addActivity(sightSeeingActivity);
//
//        Activity horseRidingActivity = new Activity("Horse Riding", "This activity allows passengers to do horse riding", 150.0, 4, rajasthanDestination);
//        rajasthanDestination.addActivity(horseRidingActivity);
//
//        Destination dubaiDestination = new Destination("Dubai", new ArrayList<Activity>());
//
//        Activity skyDivingActivity = new Activity("Sky Diving ", "This activity allows passengers to do sky diving", 50.0, 5, dubaiDestination);
//        dubaiDestination.addActivity(skyDivingActivity);
//
//        travelPackage.addDestination(rajasthanDestination);
//        travelPackage.addDestination(dubaiDestination);
//
//
//        Passenger passenger = new Passenger("Apoorva Kaushal", 100.0, PassengerType.GOLD);
//        travelPackage.addPassenger(passenger);
//
//        assertThrows(RuntimeException.class, () ->{
//            passenger.signUpForActivity(sightSeeingActivity);
//        });
//        assertEquals(2, travelPackage.getItinerary().size());
//        travelPackage.printAllAvailableActivities();
//    }
//
//    @Test
//    void printPassengerDetails() {
//        TravelPackage travelPackage = new TravelPackage("Travel Package", 5);
//
//        Destination rajasthanDestination = new Destination("Rajasthan", new ArrayList<Activity>());
//        Activity sightSeeingActivity = new Activity("Sight Seeing", "This activity allows passengers to explore the destination", 20.0, 13, rajasthanDestination);
//        rajasthanDestination.addActivity(sightSeeingActivity);
//
//        Activity horseRidingActivity = new Activity("Horse Riding", "This activity allows passengers to do horse riding", 150.0, 4, rajasthanDestination);
//        rajasthanDestination.addActivity(horseRidingActivity);
//
//        Destination dubaiDestination = new Destination("Dubai", new ArrayList<Activity>());
//
//        Activity skyDivingActivity = new Activity("Sky Diving ", "This activity allows passengers to do sky diving", 50.0, 5, dubaiDestination);
//        dubaiDestination.addActivity(skyDivingActivity);
//
//        travelPackage.addDestination(rajasthanDestination);
//        travelPackage.addDestination(dubaiDestination);
//
//
//        Passenger passenger1 = new Passenger("Apoorva Kaushal", 100.0, PassengerType.GOLD);
//        travelPackage.addPassenger(passenger1);
//        Passenger passenger2 = new Passenger("John Kaushal", 150.0, PassengerType.PREMIUM);
//        travelPackage.addPassenger(passenger2);
//
//        passenger1.signUpForActivity(sightSeeingActivity);
//        passenger1.signUpForActivity(skyDivingActivity);
//        passenger2.signUpForActivity(horseRidingActivity);
//        assertEquals(2, passenger1.getActivities().size());
//        travelPackage.printPassengerList();
//    }

    private Passenger getPassenger() {
        return new Passenger("Apoorva Kaushal", 100.0, PassengerType.STANDARD);
    }

}
