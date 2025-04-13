package com.banking.business.dtos.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CorporateCustomerResponse extends CustomerResponse {
    private String companyName;
    private String taxNumber;
    private String tradeRegisterNumber;
    private String contactPerson;
} 