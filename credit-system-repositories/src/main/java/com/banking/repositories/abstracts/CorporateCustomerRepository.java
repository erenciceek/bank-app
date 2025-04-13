package com.banking.repositories.abstracts;

import org.springframework.stereotype.Repository;

import com.banking.entities.CorporateCustomer;

@Repository
public interface CorporateCustomerRepository extends CustomerRepository<CorporateCustomer> {
    CorporateCustomer findByTaxNumber(String taxNumber);
    boolean existsByTaxNumber(String taxNumber);
    CorporateCustomer findByTradeRegisterNumber(String tradeRegisterNumber);
} 