package com.banking.core.crosscuttingconcerns.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails.AuthorizationProblemDetails;
import com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails.BusinessProblemDetails;
import com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails.NotFoundProblemDetails;
import com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails.ProblemDetails;
import com.banking.core.crosscuttingconcerns.exceptions.httpProblemDetails.ValidationProblemDetails;
import com.banking.core.crosscuttingconcerns.exceptions.types.BusinessException;

@RestControllerAdvice
public class HttpExceptionHandler extends com.banking.core.crosscuttingconcerns.exceptions.handlers.ExceptionHandler {

    @Override
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleException(Exception exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setTitle("Exception");
        problemDetails.setType("https://example.com/probs/internal");
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
            validationErrors.put(error.getField(), error.getDefaultMessage())
        );
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setValidationErrors(validationErrors);
        problemDetails.setDetail("Validation failed");
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ProblemDetails handleAuthorizationException(SecurityException exception) {
        AuthorizationProblemDetails problemDetails = new AuthorizationProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetails handleNotFoundException(RuntimeException exception) {
        NotFoundProblemDetails problemDetails = new NotFoundProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }
} 