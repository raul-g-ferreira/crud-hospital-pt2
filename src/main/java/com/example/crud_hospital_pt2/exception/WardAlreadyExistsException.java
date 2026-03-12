package com.example.crud_hospital_pt2.exception;

public class WardAlreadyExistsException extends RuntimeException {
    public WardAlreadyExistsException(String message) {
        super(message);
    }
}
