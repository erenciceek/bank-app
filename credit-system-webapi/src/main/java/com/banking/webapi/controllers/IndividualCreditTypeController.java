package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCreditTypeService;
import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCreditTypeResponse;
import com.banking.core.utils.results.PageDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/individual-credit-types")
@Tag(name = "Individual Credit Types", description = "Individual credit type endpoints")
@AllArgsConstructor
public class IndividualCreditTypeController {
    private final IndividualCreditTypeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new individual credit type")
    public IndividualCreditTypeResponse add(@Valid @RequestBody CreateIndividualCreditTypeRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get individual credit type by id")
    public IndividualCreditTypeResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    @Operation(summary = "Get all individual credit types")
    public PageDataResponse<IndividualCreditTypeResponse> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sort,
            @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort.Direction dir = Sort.Direction.fromString(direction);
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sort));
        return service.getAllPaged(pageable);
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate an individual credit type")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }

    @PutMapping("/{id}/activate")
    @Operation(summary = "Activate an individual credit type")
    public void activate(@PathVariable Long id) {
        service.activate(id);
    }
} 