package com.banking.business.dtos.responses;

import java.time.LocalDateTime;

import com.banking.entities.enums.CreditApplicationStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationResponse {
    private Long id;
    private Long customerId;
    private Long creditTypeId;
    private Double amount;
    private Integer term;
    private Double interestRate;
    private Double monthlyPayment;
    private Double totalPayment;
    private CreditApplicationStatus status;
    private String rejectionReason;
    private LocalDateTime createdDate;
} 