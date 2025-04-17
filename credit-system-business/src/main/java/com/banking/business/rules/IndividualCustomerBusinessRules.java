package com.banking.business.rules;

import com.banking.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import com.banking.business.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    
    private final IndividualCustomerRepository individualCustomerRepository;
    
    public void checkIfNationalIdentityExists(String nationalIdentity) {
        if (individualCustomerRepository.existsByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.IndividualCustomer.NATIONAL_IDENTITY_EXISTS);
        }
    }
    
    public void validateNationalIdentity(String nationalIdentity) {
        if (!nationalIdentity.matches("^[0-9]{11}$")) {
            throw new BusinessException(Messages.IndividualCustomer.INVALID_NATIONAL_IDENTITY_FORMAT);
        }
    }

} 