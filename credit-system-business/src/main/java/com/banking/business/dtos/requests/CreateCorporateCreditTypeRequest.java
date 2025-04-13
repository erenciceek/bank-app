package com.banking.business.dtos.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCorporateCreditTypeRequest {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    @Min(1)
    private Double minAmount;

    @NotNull
    @Min(1)
    private Double maxAmount;

    @NotNull
    @Min(1)
    private Integer minTerm;

    @NotNull
    @Min(1)
    private Integer maxTerm;

    @NotNull
    @DecimalMin("0.01")
    private Double baseInterestRate;

    @NotNull
    @Min(0)
    private Double minRevenue;

    @NotNull
    @Min(0)
    private Integer minCompanyAge;

    private Boolean requiresCollateral = false;
} 