package com.banking.core.crosscuttingconcerns.exceptions.types;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
} 