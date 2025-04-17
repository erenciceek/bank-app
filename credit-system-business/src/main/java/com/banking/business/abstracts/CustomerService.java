package com.banking.business.abstracts;

import org.springframework.data.domain.Pageable;

import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.core.utils.results.PageDataResponse;


public interface CustomerService<T extends CustomerResponse> {
    T getByCustomerNumber(String customerNumber);
    PageDataResponse<T> getAllPaged(Pageable pageable);
} 