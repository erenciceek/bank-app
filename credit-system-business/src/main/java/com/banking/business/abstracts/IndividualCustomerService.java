package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {
    IndividualCustomerResponse getByNationalIdentity(String nationalIdentity);
    IndividualCustomerResponse add(CreateIndividualCustomerRequest request);
} 