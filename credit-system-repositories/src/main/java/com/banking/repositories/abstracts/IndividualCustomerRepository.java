package com.banking.repositories.abstracts;

import org.springframework.stereotype.Repository;

import com.banking.entities.IndividualCustomer;

@Repository
public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer> {
    IndividualCustomer findByNationalIdentity(String nationalIdentity);
    boolean existsByNationalIdentity(String nationalIdentity);
    IndividualCustomer findByCustomerNumber(String customerNumber);
} 