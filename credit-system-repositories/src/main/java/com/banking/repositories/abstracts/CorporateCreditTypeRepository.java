package com.banking.repositories.abstracts;

import org.springframework.stereotype.Repository;

import com.banking.entities.CorporateCreditType;

@Repository
public interface CorporateCreditTypeRepository extends CreditTypeRepository<CorporateCreditType> {
}