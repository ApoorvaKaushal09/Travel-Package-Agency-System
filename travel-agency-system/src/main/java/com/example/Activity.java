package com.example;
import com.example.exception.ActivityException;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an activity within a travel package.
 * An activity has a name, description, cost, capacity, and is associated with a destination.
 */

@Getter
@Setter
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    /**
     * Creates a new Activity with the specified parameters.
     *
     * @param name        The name of the activity.
     * @param description A brief description of the activity.
     * @param cost        The cost associated with participating in the activity.
     * @param capacity    The maximum capacity of participants for the activity.
     * @param destination The destination where the activity takes place.
     */

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    /**
     * Increments the enrollment count for the activity.
     * Throws an ActivityException if the capacity is already full.
     *
     * @throws ActivityException If there is no remaining capacity in the activity.
     */
    public void incrementEnrollment() throws ActivityException {
        if(capacity <= 0)
            throw new ActivityException("No capacity left in the activity.");
        else
            capacity--;
    }

    /**
     * Retrieves the remaining capacity for the activity.
     *
     * @return The remaining capacity for the activity.
     */
    public int getRemainingCapacity() {
        return capacity;
    }
}