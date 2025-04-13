package com.banking.business.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditApplicationRequest {
    @NotNull
    private Long customerId;

    @NotNull
    private Long creditTypeId;

    @NotNull
    @Min(1)
    private Double amount;

    @NotNull
    @Min(1)
    private Integer term;
} 