package com.banking.business.rules;

import com.banking.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import com.banking.business.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {
    
    private final CorporateCustomerRepository corporateCustomerRepository;
    
    public void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(Messages.CorporateCustomer.TAX_NUMBER_EXISTS);
        }
    }
    
    public void validateTaxNumber(String taxNumber) {
        if (!taxNumber.matches("^[0-9]{10}$")) {
            throw new BusinessException(Messages.CorporateCustomer.INVALID_TAX_NUMBER_FORMAT);
        }
    }
    
    public void checkIfTradeRegisterNumberExists(String tradeRegisterNumber) {
        if (corporateCustomerRepository.findByTradeRegisterNumber(tradeRegisterNumber) != null) {
            throw new BusinessException(Messages.CorporateCustomer.TRADE_REGISTER_NUMBER_EXISTS);
        }
    }
} 