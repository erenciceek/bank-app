package com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class InternalServerErrorProblemDetails extends ProblemDetails {
    public InternalServerErrorProblemDetails() {
        setTitle("Internal Server Error");
        setType("https://example.com/probs/internal");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
} 