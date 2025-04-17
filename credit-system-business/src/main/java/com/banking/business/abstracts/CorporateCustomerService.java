package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;

public interface CorporateCustomerService extends CustomerService<CorporateCustomerResponse> {
    CorporateCustomerResponse getByTaxNumber(String taxNumber);
    CorporateCustomerResponse add(CreateCorporateCustomerRequest request);
} 