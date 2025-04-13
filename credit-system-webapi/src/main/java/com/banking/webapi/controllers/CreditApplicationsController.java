package com.banking.webapi.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banking.business.abstracts.CreditApplicationService;
import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.core.utils.results.PageDataResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/credit-applications")
@AllArgsConstructor
@Tag(name = "Credit Applications", description = "Credit Application Management APIs")
public class CreditApplicationsController {

    private final CreditApplicationService creditApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Apply for a credit")
    public CreditApplicationResponse apply(@Valid @RequestBody CreateCreditApplicationRequest request) {
        return creditApplicationService.apply(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get credit application by ID")
    public CreditApplicationResponse getById(@PathVariable Long id) {
        return creditApplicationService.getById(id);
    }

    @GetMapping("/by-customer/{customerId}")
    @Operation(summary = "Get all credit applications by customer ID")
    public PageDataResponse<CreditApplicationResponse> getAllByCustomerId(
            @RequestParam Long customerId,
            @RequestParam(defaultValue = "0") @Parameter(description = "Page number") int page,
            @RequestParam(defaultValue = "10") @Parameter(description = "Number of items per page") int size,
            @RequestParam(defaultValue = "createdDate") String sortField,
            @RequestParam(defaultValue = "DESC") @Parameter(description = "Sort direction (ASC or DESC)") String sortDirection) {

        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        return creditApplicationService.getAllByCustomerId(customerId, pageable);
    }

    @GetMapping
    @Operation(summary = "Get all credit applications with pagination")
    public PageDataResponse<CreditApplicationResponse> getAll(
            @Parameter(description = "Page number (starts from 0)")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Number of items per page")
            @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Status filter")
            @RequestParam(required = false) String status) {
        return creditApplicationService.getAll(page, size, status);
    }


    @PutMapping("/{id}/cancel")
    @Operation(summary = "Cancel a credit application")
    public CreditApplicationResponse cancel(@PathVariable Long id) {
        return creditApplicationService.cancel(id);
    }
}
