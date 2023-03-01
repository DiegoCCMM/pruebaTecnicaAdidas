package com.example.restapiversion.exceptions;

public class StreamFailException extends Exception {
    public StreamFailException(String errorMessage) {
        super(errorMessage);
    }
}
