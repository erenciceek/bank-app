package com.banking.business.dtos.responses;

import lombok.Data;

@Data
public class CreditTypeResponse {
    private Long id;
    private String name;
    private String description;
    private Double minAmount;
    private Double maxAmount;
    private Integer minTerm;
    private Integer maxTerm;
    private Double baseInterestRate;
    private Boolean active;
} 