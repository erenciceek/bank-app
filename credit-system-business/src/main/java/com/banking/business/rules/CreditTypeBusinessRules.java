package com.banking.business.rules;

import org.springframework.stereotype.Service;

import com.banking.core.constants.Messages;
import com.banking.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.banking.entities.CreditType;
import com.banking.repositories.abstracts.BaseCreditTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditTypeBusinessRules {
    private final BaseCreditTypeRepository repository;

    public void checkIfExists(Long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Credit.CREDIT_TYPE_NOT_FOUND);
        }
    }

    public void checkIfNameExists(String name) {
        if (repository.existsByName(name)) {
            throw new BusinessException(Messages.Credit.CREDIT_TYPE_NAME_EXISTS);
        }
    }

    public void checkIfAmountRangeValid(Double minAmount, Double maxAmount) {
        if (minAmount > maxAmount) {
            throw new BusinessException(Messages.Credit.INVALID_AMOUNT_RANGE);
        }
    }

    public void checkIfTermRangeValid(Integer minTerm, Integer maxTerm) {
        if (minTerm > maxTerm) {
            throw new BusinessException(Messages.Credit.INVALID_TERM_RANGE);
        }
    }


} 