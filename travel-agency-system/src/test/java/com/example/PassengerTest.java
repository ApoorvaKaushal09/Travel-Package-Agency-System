package com.example;

import com.example.exception.SignUpForActivityException;
import com.example.exception.ActivityException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class PassengerTest {

    final Passenger standardPassenger = new Passenger("Apoorva Kaushal", 300, PassengerType.STANDARD);
    final Passenger goldPassenger = new Passenger("John Doe", 500, PassengerType.GOLD);
    final Passenger premiumPassenger = new Passenger("Alice Cooper", 200, PassengerType.PREMIUM);
    final Destination destination = new Destination("Burj Khalifa, Dubai", new ArrayList<Activity>());
//    @Test
//    void passengerCreationAndSignUpForActivity() {
//
//        assertEquals("Apoorva Kaushal", standardPassenger.getName());
//        assertEquals(500, goldPassenger.getBalance());
//        assertEquals(PassengerType.PREMIUM, premiumPassenger.getPassengerType());
//        assertNotNull(standardPassenger.getActivities());
//        assertTrue(standardPassenger.getActivities().isEmpty());
//
//        Destination destination = new Destination("Burj Khalifa, Dubai", new ArrayList<Activity>());
//        Activity shoppingActivity = new Activity("Shopping", "Purchase from Several unique shops in Burj Khalifa", 50.0, 10, destination);
//        Activity photographyActivity = new Activity("Photography", "Get several cool pictures clicked inside Burj Khalifa", 3000.0, 2, destination);
//
//        standardPassenger.signUpForActivity(shoppingActivity);
//        premiumPassenger.signUpForActivity(photographyActivity);
//
//        assertFalse(standardPassenger.getActivities().isEmpty());
//        assertTrue(goldPassenger.getActivities().isEmpty());
//        assertEquals("Shopping", standardPassenger.getActivities().get(0).getName());
//    }
    @Test
    void signUpForActivitySuccessWhenBalanceAndCapacityIsAvailableTest() throws ActivityException {
        Activity foodActivity = getActivity(250.0, 1);
        standardPassenger.signUpForActivity(foodActivity);
        assertEquals(50, standardPassenger.getBalance());
        assertEquals(0, foodActivity.getRemainingCapacity());
        assertEquals(1, standardPassenger.getActivities().size());
        assertEquals("Shopping", standardPassenger.getActivities().get(0).getName());
    }
    @Test
    void signUpForActivityFailureWhenBalanceIsNotAvailableTest(){
        Activity shoppingActivity = getActivity(3000.0, 3);
        assertThrows(SignUpForActivityException.class, () -> {goldPassenger.signUpForActivity(shoppingActivity);});
    }
    @Test
    void signUpForActivityFailureWhenActivityCapacityExhaustedTest(){
        Activity shoppingActivity = getActivity(30.0, 0);
        assertThrows(SignUpForActivityException.class, () -> {goldPassenger.signUpForActivity(shoppingActivity);});
    }

    @Test
    void calculateCostSuccessTest(){
        Activity shoppingActivity = getActivity(500.0, 5);
        assertEquals(500.0, standardPassenger.calculateCost(shoppingActivity));
        assertEquals(450.0, goldPassenger.calculateCost(shoppingActivity));
        assertEquals(0.0, premiumPassenger.calculateCost(shoppingActivity));
    }

    @Test
    void calculateCostFailureTest(){
        Passenger otherPassenger = new Passenger("Chhaya Kaushal", 30, null);
        Activity shoppingActivity = getActivity(500.0, 5);

        assertThrows(NullPointerException.class, () -> {otherPassenger.calculateCost(shoppingActivity);});
    }
    Activity getActivity(double cost, int capacity){
        return new Activity("Shopping", "Purchase from Several unique shops in Burj Khalifa", cost, capacity, destination);
    }



//    @Test
//    void expectedExceptionForLessBalanceAvailibility(){
//        Destination destination = new Destination("Burj Khalifa, Dubai", new ArrayList<Activity>());
//        final Activity foodActivity = new Activity("Binge Eat", "Try out dubai special food items", 3000.0, 0, destination);
//        assertThrows(RuntimeException.class, () -> {
//            standardPassenger.signUpForActivity(foodActivity);
//        });
//    }
//    @Test
//    void expectedExceptionForNoRemainingCapacity(){
//        Destination destination = new Destination("Burj Khalifa, Dubai", new ArrayList<Activity>());
//        final Activity foodActivity = new Activity("Binge Eat", "Try out dubai special food items", 300.0, 0, destination);
//        assertThrows(RuntimeException.class, () -> {
//            standardPassenger.signUpForActivity(foodActivity);
//        });
//    }
//    @Test
//    void printPassengerDetails() {
//        Destination destination = new Destination("Burj Khalifa, Dubai", new ArrayList<Activity>());
//        Activity shoppingActivity = new Activity("Shopping", "Purchase from Several unique shops in Burj Khalifa", 50.0, 10, destination);
//        goldPassenger.signUpForActivity(shoppingActivity);
//        assertEquals(1, goldPassenger.getActivities().size());
//        goldPassenger.printDetails();
//    }
}
