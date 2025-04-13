package com.banking.repositories.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.entities.enums.CreditApplicationStatus;

import com.banking.entities.CreditApplication;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {
    Page<CreditApplication> findAllByCustomerId(Long customerId, Pageable pageable);
    Page<CreditApplication> findAllByStatus(CreditApplicationStatus status, Pageable pageable);

} 