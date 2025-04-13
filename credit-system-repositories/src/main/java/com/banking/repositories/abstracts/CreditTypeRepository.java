package com.banking.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.banking.entities.CreditType;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository<T extends CreditType> extends JpaRepository<T, Long> {
    boolean existsByName(String name);
} 