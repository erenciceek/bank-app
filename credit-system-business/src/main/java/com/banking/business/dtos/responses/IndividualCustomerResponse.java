package com.banking.business.dtos.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualCustomerResponse extends CustomerResponse {
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private String birthDate;
} 