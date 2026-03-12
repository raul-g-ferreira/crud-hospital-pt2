package com.example.crud_hospital_pt2.exception;

public class BedNotFoundException extends RuntimeException {
    public BedNotFoundException(String message) {
        super(message);
    }
}
