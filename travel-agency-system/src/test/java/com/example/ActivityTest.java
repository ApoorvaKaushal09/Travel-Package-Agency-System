package com.example;

import com.example.exception.ActivityException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class ActivityTest {
    Destination destination = new Destination("Marina Beach, Chennai", new ArrayList<Activity>());
    Activity bonfireActivity = new Activity("Bonfire", "This activity involves firing a bonfire and have fun", 50.0, 5, destination);
    Activity scubaActivity = new Activity("Scube Diving", "This activity involves scuba diving.", 250.0, 0, destination);
//    @Test
//    void activityCreationAndEnrollment() {
//
//        assertEquals("Bonfire", bonfireActivity.getName());
//        assertEquals("This activity involves firing a bonfire and have fun", bonfireActivity.getDescription());
//        assertEquals(50.0, bonfireActivity.getCost());
//        assertEquals(5, bonfireActivity.getCapacity());
//        assertEquals(5, bonfireActivity.getRemainingCapacity());
//        bonfireActivity.incrementEnrollment();
//        assertEquals(4, bonfireActivity.getRemainingCapacity());
//    }
//
//    @Test
//    void noCapacityLeft(){
//        scubaActivity.incrementEnrollment();
//        assertEquals(0, scubaActivity.getRemainingCapacity());
//        assertThrows(RuntimeException.class, () -> scubaActivity.incrementEnrollment());
//    }

    @Test
    void incrementEnrollmentSuccessAndGetRemainingCapacityTest() throws ActivityException {
        bonfireActivity.incrementEnrollment();
        assertEquals(4, bonfireActivity.getRemainingCapacity());
    }
    @Test
    void incrementEnrollmentFailureTest(){
        assertThrows(ActivityException.class, () -> {scubaActivity.incrementEnrollment();});
    }
}
