package com.example;

import com.example.exception.DuplicateActivityInDestinationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

class DestinationTest {

    Destination canadaDestination= new Destination("Ontario, Canada", new ArrayList<Activity>());
    Destination dubaiDestination= new Destination("Dubai, UAE", new ArrayList<Activity>());
    Activity sightSeeingActivity = new Activity("Sight Seeing", "This activity allows passengers to explore the destination", 250.0, 5, null);



//    @Test
//    void destinationCreationAndActivityAddition() {
//        assertNotEquals("Ontario,Canada", canadaDestination.getName());
//        assertEquals("Ontario, Canada", canadaDestination.getName());
//        assertNotNull(canadaDestination.getActivities());
//        assertTrue(canadaDestination.getActivities().isEmpty());
//        Activity sightSeeingActivity = new Activity("Sight Seeing", "This activity allows passengers to explore the destination", 250.0, 5, canadaDestination);
//        canadaDestination.addActivity(sightSeeingActivity);
//
//        assertFalse(canadaDestination.getActivities().isEmpty());
//        assertEquals("Sight Seeing", canadaDestination.getActivities().get(0).getName());
//    }
    @Test
    void addActivitySuccessTest(){
        canadaDestination.addActivity(sightSeeingActivity);
        assertFalse(canadaDestination.getActivities().isEmpty());
        assertEquals("Sight Seeing", canadaDestination.getActivities().get(0).getName());
    }

    @Test
    void addActivityFailureTest(){
        canadaDestination.addActivity(sightSeeingActivity);
        assertThrows(DuplicateActivityInDestinationException.class, () -> {dubaiDestination.addActivity(sightSeeingActivity);});
    }
}
