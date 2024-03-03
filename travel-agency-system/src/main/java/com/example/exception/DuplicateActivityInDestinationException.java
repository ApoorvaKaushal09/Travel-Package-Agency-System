package com.example.exception;

public class DuplicateActivityInDestinationException extends RuntimeException {
    public DuplicateActivityInDestinationException(String message) {
        super(message);
    }
}