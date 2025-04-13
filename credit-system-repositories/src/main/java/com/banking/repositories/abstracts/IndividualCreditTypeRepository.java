package com.banking.repositories.abstracts;

import com.banking.entities.IndividualCreditType;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCreditTypeRepository extends CreditTypeRepository<IndividualCreditType> {
} 