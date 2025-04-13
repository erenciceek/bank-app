package com.banking.business.abstracts;

import com.banking.business.dtos.responses.CustomerResponse;

public interface CustomerService<T extends CustomerResponse> {
    T getByCustomerNumber(String customerNumber);
} 