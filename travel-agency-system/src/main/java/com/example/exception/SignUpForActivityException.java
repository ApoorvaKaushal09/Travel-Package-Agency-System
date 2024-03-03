package com.example.exception;

public class SignUpForActivityException extends RuntimeException{
    public SignUpForActivityException(String message) {
        super(message);
    }
}
