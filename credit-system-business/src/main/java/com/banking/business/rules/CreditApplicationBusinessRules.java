package com.banking.business.rules;

import org.springframework.stereotype.Service;

import com.banking.business.constants.Messages;
import com.banking.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.banking.entities.CreditApplication;
import com.banking.entities.CreditType;
import com.banking.entities.Customer;
import com.banking.entities.IndividualCreditType;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.enums.CreditApplicationStatus;
import com.banking.repositories.abstracts.CreditApplicationRepository;
import com.banking.repositories.abstracts.CreditTypeRepository;
import com.banking.repositories.abstracts.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditApplicationBusinessRules {
    private final CustomerRepository customerRepository;
    private final CreditTypeRepository<CreditType> creditTypeRepository;
    private final CreditApplicationRepository applicationRepository;

    public void checkIfCustomerExists(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new BusinessException(Messages.Customer.CUSTOMER_NOT_FOUND);
        }
    }

    public void checkIfCreditTypeExists(Long creditTypeId) {
        if (!creditTypeRepository.existsById(creditTypeId)) {
            throw new BusinessException(Messages.Credit.CREDIT_TYPE_NOT_FOUND);
        }
    }

    public void checkIfApplicationExists(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new BusinessException(Messages.Credit.APPLICATION_NOT_FOUND);
        }
    }

    public void checkIfCustomerCanApplyForCreditType(Customer customer, CreditType creditType) {
        boolean isIndividualCustomer = customer instanceof IndividualCustomer;
        boolean isIndividualCreditType = creditType instanceof IndividualCreditType;

        if (isIndividualCustomer != isIndividualCreditType) {
            throw new BusinessException(Messages.Credit.INVALID_CREDIT_TYPE_FOR_CUSTOMER);
        }
    }

    public void checkIfAmountInRange(Double amount, CreditType creditType) {
        if (amount < creditType.getMinAmount() || amount > creditType.getMaxAmount()) {
            throw new BusinessException(Messages.Credit.AMOUNT_OUT_OF_RANGE);
        }
    }

    public void checkIfTermInRange(Integer term, CreditType creditType) {
        if (term < creditType.getMinTerm() || term > creditType.getMaxTerm()) {
            throw new BusinessException(Messages.Credit.TERM_OUT_OF_RANGE);
        }
    }

    public void checkIfApplicationCanBeCancelled(CreditApplication application) {
        if (application.getStatus() != CreditApplicationStatus.PENDING) {
            throw new BusinessException(Messages.Credit.APPLICATION_CANNOT_BE_CANCELLED);
        }
    }
} 