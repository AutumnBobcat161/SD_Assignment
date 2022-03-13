package com.utcn.sd.assignment.exception;

public class UserNotFoundError extends RuntimeException {

    public UserNotFoundError(String message) {
        super(message);
    }
}
