package com.example;

/**
 * Enumeration representing different types of passengers in the travel system.
 * There are three types: STANDARD, GOLD, and PREMIUM.
 */
public enum PassengerType {
    /**
     * Standard passengers have a balance, and the cost of activities is deducted from their balance.
     */
    STANDARD,

    /**
     * Gold passengers have a balance with a 10% discount on the cost of activities.
     */
    GOLD,

    /**
     * Premium passengers can sign up for activities for free.
     */
    PREMIUM
}