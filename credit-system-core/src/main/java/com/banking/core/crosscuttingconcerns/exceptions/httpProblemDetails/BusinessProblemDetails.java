package com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setType("https://example.com/probs/business");
        setStatus(HttpStatus.BAD_REQUEST.value());
    }
} 