package com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> validationErrors;

    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setType("https://example.com/probs/validation");
        setStatus(HttpStatus.BAD_REQUEST.value());
    }
} 