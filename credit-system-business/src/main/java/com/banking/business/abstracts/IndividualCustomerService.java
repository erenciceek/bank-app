package com.banking.business.abstracts;

import org.springframework.data.domain.Pageable;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.core.utils.results.PageDataResponse;

public interface IndividualCustomerService {
    IndividualCustomerResponse add(CreateIndividualCustomerRequest request);
    IndividualCustomerResponse getByCustomerNumber(String customerNumber);
    IndividualCustomerResponse getByNationalIdentity(String nationalIdentity);
    PageDataResponse<IndividualCustomerResponse> getAllPaged(Pageable pageable);
} 