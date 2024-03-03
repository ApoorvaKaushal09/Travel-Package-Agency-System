package com.example;

import java.util.List;

import com.example.exception.DuplicateActivityInDestinationException;
import lombok.Getter;
import lombok.Setter;
/**
 * Represents a destination within a travel package.
 * Each destination has a name and a list of activities associated with it.
 *
 * @see Activity
 */
@Getter
@Setter
public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Creates a new Destination with the specified parameters.
     *
     * @param name       The name of the destination.
     * @param activities The list of activities associated with the destination.
     */
    public Destination(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    /**
     * Adds an activity to the destination.
     *
     * @param activity The activity to be added.
     * @throws DuplicateActivityInDestinationException If the activity is already present in another destination.
     */
    public void addActivity(Activity activity) {
        if(activity.getDestination() == null) {
            activities.add(activity);
            activity.setDestination(this);
        }
        else
            throw new DuplicateActivityInDestinationException("This activity is already present in another Destination");
    }

    /**
     * Prints details of available activities with remaining capacity.
     *
     * @param activities The list of activities to check for availability.
     */
    public void printAvailableActivities(List<Activity> activities){
        for(Activity activity : activities){
            if(activity.getRemainingCapacity() > 0){
                System.out.println("Activity " + activity.getName() + " has " + activity.getRemainingCapacity() + " spaces available.");
                System.out.println("Activity details:- ");
                System.out.println(activity.getName() + " - "+ activity.getDescription() + " which is located in " + activity.getDestination().getName() + " available at cost = " + activity.getCost());
            }
        }
    }
}
