package com.example.search.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String m) {
        super(m);
    }
}
