package com.example.crud_hospital_pt2.exception;

public class WardNotFoundException extends RuntimeException {
    public WardNotFoundException(String message) {
        super(message);
    }
}
