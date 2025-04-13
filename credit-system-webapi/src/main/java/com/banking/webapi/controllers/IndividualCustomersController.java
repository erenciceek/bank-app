package com.banking.webapi.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.core.utils.results.PageDataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "Individual Customer Management APIs")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new individual customer")
    public IndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest request) {
        return individualCustomerService.add(request);
    }

    @GetMapping("/by-customer-number/{customerNumber}")
    @Operation(summary = "Get individual customer by customer number")
    public IndividualCustomerResponse getByCustomerNumber(@PathVariable String customerNumber) {
        return individualCustomerService.getByCustomerNumber(customerNumber);
    }

    @GetMapping("/by-national-identity/{nationalIdentity}")
    @Operation(summary = "Get individual customer by national identity")
    public IndividualCustomerResponse getByNationalIdentity(@PathVariable String nationalIdentity) {
        return individualCustomerService.getByNationalIdentity(nationalIdentity);
    }

    @GetMapping
    @Operation(summary = "Get all individual customers with pagination")
    public PageDataResponse<IndividualCustomerResponse> getAllPaged(
            @Parameter(description = "Page number (starts from 0)")
            @RequestParam(defaultValue = "0") int page,
            
            @Parameter(description = "Number of items per page")
            @RequestParam(defaultValue = "10") int size,
            
            @Parameter(description = "Sort field")
            @RequestParam(defaultValue = "id") String sortField,
            
            @Parameter(description = "Sort direction (ASC or DESC)")
            @RequestParam(defaultValue = "ASC") String sortDirection
    ) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        return individualCustomerService.getAllPaged(pageable);
    }
} 