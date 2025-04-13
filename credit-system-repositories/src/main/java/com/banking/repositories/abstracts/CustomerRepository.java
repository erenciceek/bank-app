package com.banking.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entities.Customer;

@Repository
public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Long> {
    boolean existsByCustomerNumber(String customerNumber);
    T findByCustomerNumber(String customerNumber);
} 